package org.creditease.cn.service; 

import org.creditease.cn.model.BIEvnEffect;
import org.json.JSONObject;


/**
 * 
 * @Title: IUserService
 * @Description: 
 * @Copyright:Copyright (c) 2014
 * @Date:2015-3-19
 * @author:xiezhongyong
 */
public interface IAppEvnEffectService extends IBaseService<BIEvnEffect> {
	
	public JSONObject aapStr(String beginDate, String endDate, String appKey,String channel,String channel_sub)throws Exception;
	public JSONObject retention(String beginDate, String endDate, String app_key,String channel,String channel_sub)throws Exception;
	public JSONObject usageDur(String beginDate, String endDate, String app_key)throws Exception;
	public JSONObject exception(String beginDate, String endDate, String app_key)throws Exception;
	public JSONObject redLo(String beginDate, String endDate, String app_key)throws Exception;
	
}
 
