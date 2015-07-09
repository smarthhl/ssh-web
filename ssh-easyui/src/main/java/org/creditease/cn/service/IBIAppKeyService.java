package org.creditease.cn.service; 

import java.util.List;

import javax.transaction.SystemException;

import org.creditease.cn.common.Result;
import org.creditease.cn.model.BIAppKey;
import org.json.JSONArray;
import org.json.JSONObject;




import com.strongmvc.orm.hibernate.Page;

/**
 * 
 * @Title: IUserService
 * @Description: 
 * @Copyright:Copyright (c) 2014
 * @Date:2015-3-19
 * @author:xiezhongyong
 */
public interface IBIAppKeyService {
	/**
	 * 保存app key
	  * @Title: saveAppKey
	  * @Description: TODO
	  * @param @param appKey
	  * @param @return
	  * @return Result
	  * @throws
	 */
	public Result saveAppKey(BIAppKey appKey)throws SystemException;
	
	/**
	 * 更新app key
	  * @Title: updateAppKey
	  * @Description: TODO
	  * @param @param appKey
	  * @param @return
	  * @return Result
	  * @throws
	 */
	public Result updateAppKey(BIAppKey appKey);
	
	/**
	 * 删除app key
	  * @Title: deleteAppKey
	  * @Description: TODO
	  * @param @param appKey
	  * @param @return
	  * @return boolean
	  * @throws
	 */
	public Result deleteAppKey(BIAppKey appKey);
	
	/**
	 * 根据app key获取其对应的应用列表
	  * @Title: getAppListByKey
	  * @Description: TODO
	  * @param @param appKey
	  * @param @return
	  * @return Page<BIAppKey>
	  * @throws
	 */
	public Page<BIAppKey> getAppListByKey(Page<BIAppKey> page,BIAppKey appKey);
	
	/**
	 * 根据app key获取其对应的应用列表
	  * @Title: getAppListByKey
	  * @Description: TODO
	  * @param @param appKey
	  * @param @return
	  * @return List<BIAppKey>
	  * @throws
	 */
	public List<BIAppKey> getAppListByKey(BIAppKey appKey);
	
	public JSONArray getAppByUser(BIAppKey user) ;
	public JSONObject checkKeyStatus(BIAppKey appkey) throws Exception;
}
 
