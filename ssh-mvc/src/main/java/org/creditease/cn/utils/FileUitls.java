package org.creditease.cn.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.channels.FileChannel;

import sun.jdbc.odbc.OdbcDef;

public class FileUitls {

	@SuppressWarnings("unused")
	public static void createDirectory(String dirName) {
		File directory = new File(dirName);
		if (!directory.exists())
			directory.mkdirs();
	}

	@SuppressWarnings("unused")
	public static void createNewFile(String filePath) {
		File file = new File(filePath);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public static void renameFile(String oldFilePath,String newFilePath)
	{
		File oldFile=new File(oldFilePath);
		if (oldFile.exists()) {
			try {
				oldFile.renameTo(new File(newFilePath));
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

	@SuppressWarnings("unused")
	public static void fileWriteToDisk(String filePath, String info) {
		File path = new File(filePath);
		if (path.exists()) {
			try {
				BufferedWriter bout = new BufferedWriter(
						new OutputStreamWriter(new FileOutputStream(path, true)));
				bout.write(info);
				bout.newLine();
				bout.flush();
			} catch (FileNotFoundException fn) {
				System.out.println("fileNotFound-->" + fn.getMessage());
			} catch (IOException ex) {
				;
			}
		}
	}

	public static long timeInseconds() {
		return System.currentTimeMillis() >>> 10;
	}

	public static String trasitionStr(String str)
			throws UnsupportedEncodingException {
		return new String(str.getBytes("ISO-8859-1"), "UTF-8");
	}

	/**
	 * 使用文件通道的方式复制文件
	 * @param s
	 * @param t
	 */
	public static int fileChannelCopy(File s, File t) {
		int flag=0;
		FileInputStream fi = null;
		FileOutputStream fo = null;
		FileChannel in = null;
		FileChannel out = null;
		try {
			fi = new FileInputStream(s);
			fo = new FileOutputStream(t);
			in = fi.getChannel();// 得到对应的文件通道
			out = fo.getChannel();// 得到对应的文件通道
			in.transferTo(0, in.size(), out);// 连接两个通道，并且从in通道读取，然后写入out通道

		} catch (IOException e) {
			e.printStackTrace();
			return flag;
		} finally {
			try {
				fi.close();
				in.close();
				fo.close();
				out.close();
				
			} catch (IOException e) {
				e.printStackTrace();
				return flag;
			}
		}
		flag=1;
		return flag;
		
	}
	/**
	 * 生成以log文件
	 * @param filePath
	 */
	public static void generateNewFile(String filePath){
		String saveLog=filePath.substring(0, filePath.lastIndexOf("."));
		FileUitls.createNewFile(saveLog);
		File sFile = new File(filePath);
		File tFile = new File(saveLog);
		int flag=fileChannelCopy(sFile,tFile);
		if(flag==1){
			System.gc();
			sFile.getAbsoluteFile().delete();
			System.gc();
		}
	}
}
