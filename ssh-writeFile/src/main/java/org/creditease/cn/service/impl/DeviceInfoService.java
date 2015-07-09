package org.creditease.cn.service.impl;

import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.servlet.http.HttpServletResponse;

import org.creditease.cn.utils.FileUitls;
import org.creditease.cn.utils.FinalConstant;
import org.json.JSONObject;

/**
 * 创建写文件的进程
 * 
 * @author huhl
 *
 */
public class DeviceInfoService implements Runnable {

	private static String parentDirectory = null; // 根目录
	private static long et; // 时间间隔时间
	private static int rate;// 采集频率
	private static String filePath; // 文件路径
	private static String prefixFile; // 文件路径
	private static int count = 0; // 记数器
	private static String info;
	private static Lock lock;
	private HttpServletResponse response;
	static {
		lock = new ReentrantLock();
	}

	@SuppressWarnings("static-access")
	public DeviceInfoService(String info, String parentDirectory,
			String prefixFile, int rate, HttpServletResponse response) {
		this.info = info;
		this.parentDirectory = parentDirectory;
		this.prefixFile = prefixFile;
		this.rate = rate;
		this.response = response;
	}

	private static void init() {

		filePath = null;
		Calendar cInstance = new GregorianCalendar();

		SimpleDateFormat cMonth = new SimpleDateFormat("yyyy-MM");
		String dirName = cMonth.format(cInstance.getTime());
		parentDirectory = parentDirectory + File.separator + dirName;

		SimpleDateFormat cDate = new SimpleDateFormat("yyyyMMddHHmm");
		String curDate = cDate.format(cInstance.getTime());
		filePath = parentDirectory + File.separator + prefixFile + curDate
				+ ".log.tmp";

		// 时间间隔在此设置，我设置为每一分钟创建一个文件夹
		cInstance.add(rate, (+1));
		++count;
		et = cInstance.getTimeInMillis() >>> 10;

		FileUitls.createDirectory(parentDirectory);
		FileUitls.createNewFile(filePath);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		JSONObject jsonObject = new JSONObject();
		lock.lock();
		try {
			if (count == 0)
				init();
			FileUitls.fileWriteToDisk(filePath, info);
			if (FileUitls.timeInseconds() > et) {
				FileUitls.generateNewFile(filePath);
				init();
			}
			jsonObject.accumulate("api_status_cd",
					FinalConstant.STA_APP_USER_UPLOAD_SUCCESS);
			jsonObject.accumulate("api_msg",
					FinalConstant.MSG_APP_USER_UPLOAD_SUCCESS);
		} catch (Exception e) {
			// TODO: handle exception
			jsonObject.accumulate("api_status_cd",
					FinalConstant.STA_APP_USER_UPLOAD_FAIL);
			jsonObject.accumulate("api_msg",
					FinalConstant.MSG_APP_USER_UPLOAD_FAIL);
		} finally {
			lock.unlock();
		}

		try {
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			out.write(jsonObject.toString());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
