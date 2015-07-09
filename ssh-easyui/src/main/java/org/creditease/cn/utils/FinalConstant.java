package org.creditease.cn.utils;

import java.io.File;
import java.util.Calendar;

public class FinalConstant {
	
	public static final int RATE_MINUTE=Calendar.MINUTE;
	public static final int RATE_HOUR=Calendar.HOUR;
	public static final int RATE_DATE=Calendar.DATE;
	
	public static final String MESSAGE_DEV_PRE="device";
	public static final String MESSAGE_APPACTIVE_PRE="active";
	public static final String MESSAGE_APPPAGE_PRE="apppage";
	public static final String MESSAGE_WIFI_PRE="wifi";
	public static final String MESSAGE_APPSCAN_PRE="appscan";
	public static final String MESSAGE_AC_WIFI_PRE="acwifi";
	
	public static final String DEV_DIR=File.separator+"device";
	public static final String APPACTIVE_DIR=File.separator+"active";
	public static final String APPPAGE_DIR=File.separator+"apppage";
	public static final String WIFI_DIR=File.separator+"wifi";
	public static final String APPSCAN_DIR=File.separator+"appscan";
	public static final String ACWIFI_DIR=File.separator+"acwifi";
	
	public static final String SECURITY_KEY="creditease";
	
	public static final String STA_VALID="0";
	public static final String APP_VALID="APP KEY有效";
	
	public static final String STA_OVERDUE="1";
	public static final String APP_OVERDUE="APP KEY已过期";
	
	public static final String STA_APPLY="2";
	public static final String APP_APPLY="请先申请APP KEY";
	
	public static final String STA_INPUT="3";
	public static final String APP_INPUT="请填写正确的APP KEY";
	
	//app_user reference
	public static final String STA_APP_USER_LOGIN_SUCCESS="0";
	public static final String MSG_APP_USER_LOGIN_SUCCESS="登陆成功";
	
	public static final String STA_APP_USER_LOGIN_FAIL="1";
	public static final String MSG_APP_USER_LOGIN_FAIL="用户名或密码错误";
	
	public static final String STA_APP_USER_UPDATE_PASWD_SUCCESS="0";
	public static final String MSG_APP_USER_UPDATE_PASWD_SUCCESS="密码修改成功";
	
	public static final String STA_APP_USER_UPDATE_PASWD_FAIL="1";
	public static final String MSG_APP_USER_UPDATE_PASWD_FAIL="密码修改失败，请重新修改";
	
	public static final String STA_APP_USER_UPDATE_PASWD_SAME="2";
	public static final String MSG_APP_USER_UPDATE_PASWD_SAME="新密码与原有密码相同，请重新修改";
	
	public static final String STA_APP_USER_QUERY_SUCCESS="0";
	public static final String MSG_APP_USER_QUERY_SUCCESS="查询成功";
	
	public static final String STA_APP_USER_QUERY_FAIL="1";
	public static final String MSG_APP_USER_QUERY_FAIL="查询失败";
	
	public static final String STA_APP_USER_UPLOAD_SUCCESS="0";
	public static final String MSG_APP_USER_UPLOAD_SUCCESS="上传成功";
	
	public static final String STA_APP_USER_UPLOAD_FAIL="1";
	public static final String MSG_APP_USER_UPLOAD_FAIL="上传失败";
	
	
}
