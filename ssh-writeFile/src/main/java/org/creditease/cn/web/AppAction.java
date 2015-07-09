package org.creditease.cn.web;

import java.io.UnsupportedEncodingException;

import org.apache.struts2.ServletActionContext;
import org.creditease.cn.service.impl.AppSubmitEventInfoUploadService;
import org.creditease.cn.service.impl.DeviceInfoService;
import org.creditease.cn.service.impl.LocationInfoUploadService;
import org.creditease.cn.utils.Base64Util;
import org.creditease.cn.utils.FinalConstant;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("appAction")
@Scope("prototype")
public class AppAction extends BaseAction {

	/**
	 * @Fields serialVersionUID:TODO
	 */
	private static final long serialVersionUID = -1658835539839912359L;

	public String devInfo; // 设备+通讯录+已安装App列表
	public String event_info;// app event信息列表

	public String outPath = ServletActionContext.getServletContext()
			.getRealPath("data");

	/**
	 * 读取dev、install和contact信息，写入文件
	 * 
	 * 扫描频率：1分钟
	 * 
	 * @throws UnsupportedEncodingException
	 */
	public void devSave() throws UnsupportedEncodingException {
		devInfo = ServletActionContext.getRequest().getParameter("devInfo");
		devInfo = Base64Util.decode(devInfo);
		// System.out.println("解密后："+devInfo);
		// devInfo = FileUitls.trasitionStr(devInfo);
		DeviceInfoService cl = new DeviceInfoService(devInfo, outPath
				+ FinalConstant.DEV_DIR, FinalConstant.MESSAGE_DEV_PRE,
				FinalConstant.RATE_MINUTE, ServletActionContext.getResponse());
		cl.run();
	}

	public void submitEvent() throws Exception {
		String event_info = ServletActionContext.getRequest().getParameter(
				"event_info");
		event_info = Base64Util.decode(event_info);
		AppSubmitEventInfoUploadService cl = new AppSubmitEventInfoUploadService(
				event_info, outPath + FinalConstant.APPEVENT_DIR,
				FinalConstant.MESSAGE_APP_EVENT_PRE, FinalConstant.RATE_MINUTE,
				ServletActionContext.getResponse());
		cl.run();
	}

	public void locationSave() throws Exception {
		String locationInfo = this.get("locationInfo", "utf-8");
		locationInfo = Base64Util.decode(locationInfo);
		LocationInfoUploadService cl = new LocationInfoUploadService(
				locationInfo, outPath + FinalConstant.APPLOCATION_DIR,
				FinalConstant.MESSAGE_APP_LOCATION_PRE,
				FinalConstant.RATE_MINUTE, this.getResponse());
		cl.run();

	}

	public String getDevInfo() {
		return devInfo;
	}

	public void setDevInfo(String devInfo) {
		this.devInfo = devInfo;
	}

	public String getEvent_info() {
		return event_info;
	}

	public void setEvent_info(String event_info) {
		this.event_info = event_info;
	}

}
