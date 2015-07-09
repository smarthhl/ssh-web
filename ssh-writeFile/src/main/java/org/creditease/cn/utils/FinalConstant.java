package org.creditease.cn.utils;

import java.io.File;
import java.util.Calendar;

public class FinalConstant {

	public static final int RATE_MINUTE = Calendar.MINUTE;
	public static final int RATE_HOUR = Calendar.HOUR;
	public static final int RATE_DATE = Calendar.DATE;

	public static final String MESSAGE_DEV_PRE = "device";
	public static final String MESSAGE_APP_EVENT_PRE = "appevent";
	public static final String MESSAGE_APP_LOCATION_PRE = "applocation";

	public static final String DEV_DIR = File.separator + "device";
	public static final String APPEVENT_DIR = File.separator + "appevent";
	public static final String APPLOCATION_DIR = File.separator + "applocation";

	public static final String STA_APP_USER_UPLOAD_SUCCESS = "0";
	public static final String MSG_APP_USER_UPLOAD_SUCCESS = "上传成功";

	public static final String STA_APP_USER_UPLOAD_FAIL = "1";
	public static final String MSG_APP_USER_UPLOAD_FAIL = "上传失败";

}
