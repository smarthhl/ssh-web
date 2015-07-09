package org.creditease.cn.service; 

import java.util.List;

import org.creditease.cn.common.Result;
import org.creditease.cn.model.IpDown;


/**
 * 
 * @Title: IUserService
 * @Description: 
 * @Copyright:Copyright (c) 2014
 * @Date:2015-3-19
 * @author:xiezhongyong
 */
public interface IIpDownService {
	
	/**
	  * @Title: userRegister
	  * @Description: TODO
	  * @param @param user
	  * @param @return
	  * @return Result
	  * @throws
	 */
	public Result saveIp(IpDown ip);
	
	/**
	 * 根据app key获取其对应的应用列表
	  * @Title: getAppListByKey
	  * @Description: TODO
	  * @param @param appKey
	  * @param @return
	  * @return List<BIAppKey>
	  * @throws
	 */
	public List<IpDown> getIpList(IpDown ip);
	
}
 
