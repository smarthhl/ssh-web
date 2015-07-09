package org.creditease.cn.service; 

import java.util.List;

import org.creditease.cn.common.Result;
import org.creditease.cn.model.BIAppKey;
import org.creditease.cn.model.BIUser;

import com.strongmvc.orm.hibernate.Page;

/**
 * 
 * @Title: IUserService
 * @Description: 
 * @Copyright:Copyright (c) 2014
 * @Date:2015-3-19
 * @author:xiezhongyong
 */
public interface IBIUserService {
	/**
	 * 使用油箱和密码进行用户登录验证
	  * @Title: userLogin
	  * @Description: TODO
	  * @param @param user
	  * @param @return
	  * @return Result
	  * @throws
	 */
	public Result userLogin(BIUser user);
	
	/**
	 * 注册用户
	  * @Title: userRegister
	  * @Description: TODO
	  * @param @param user
	  * @param @return
	  * @return Result
	  * @throws
	 */
	public Result userRegister(BIUser user);
	
	/**
	 * 修改用户信息
	  * @Title: userUpdate
	  * @Description: TODO
	  * @param @param user
	  * @param @return
	  * @return Result
	  * @throws
	 */
	public Result userUpdate(BIUser user);
	
	/**
	 * 根据邮箱获取用户信息
	  * @Title: getUserByEmail
	  * @Description: TODO
	  * @param @param email
	  * @param @return
	  * @return Result
	  * @throws
	 */
	public Result getUserByEmail(BIUser user);
	

	/**
	 * 根据用户名获取用户信息
	  * @Title: getUserByName
	  * @Description: TODO
	  * @param @param userName
	  * @param @return
	  * @return Result
	  * @throws
	 */
	public Result getUserByName(BIUser user);
	
	/**
	 * 获取用户列表
	  * @Title: getAppListByKey
	  * @Description: TODO
	  * @param @param appKey
	  * @param @return
	  * @return Page<BIAppKey>
	  * @throws
	 */
	public Page<BIUser> getUserList(Page<BIUser> page,BIUser user);
	
	/**
	 * 根据app key获取其对应的应用列表
	  * @Title: getAppListByKey
	  * @Description: TODO
	  * @param @param appKey
	  * @param @return
	  * @return List<BIAppKey>
	  * @throws
	 */
	public List<BIUser> getUserList(BIUser user);
	
	public Result saveUser(BIUser model)throws Exception;
	
	public void delete(int id) ;
	public String formatApp_key(List<BIAppKey> appKeys);
}
 
