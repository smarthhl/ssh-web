package org.creditease.cn.service;

import java.util.List;

import org.creditease.cn.common.Result;
import org.creditease.cn.model.BIAppType;
import org.json.JSONArray;

import com.strongmvc.orm.hibernate.Page;

/**
 * 
 * @Title: IUserService
 * @Description:
 * @Copyright:Copyright (c) 2014
 * @Date:2015-3-19
 * @author:xiezhongyong
 */
public interface IBIAppTypeService {
	/**
	 * 保存app type
	 * 
	 * @Title: saveAppType
	 * @Description: TODO
	 * @param @param appType
	 * @param @return
	 * @return Result
	 * @throws
	 */
	public Result saveAppType(BIAppType appType);

	/**
	 * 更新app type
	 * 
	 * @Title: updateAppType
	 * @Description: TODO
	 * @param @param appType
	 * @param @return
	 * @return Result
	 * @throws
	 */
	public Result updateAppType(BIAppType appType);

	/**
	 * 删除app type
	 * 
	 * @Title: deleteAppType
	 * @Description: TODO
	 * @param @param appType
	 * @param @return
	 * @return Result
	 * @throws
	 */
	public Result deleteAppType(BIAppType appType);

	/**
	 * 获取app type列表
	 * 
	 * @Title: getAppTypeList
	 * @Description: TODO
	 * @param @return
	 * @return Page<BIAppType>
	 * @throws
	 */
	public Page<BIAppType> getAppTypeList(Page<BIAppType> page,BIAppType appType);
	/**
	 * 获取app type
	 * @return
	 */
	public JSONArray getAppType();
	
	/**
	 * 获取app type列表
	  * @Title: getAppTypeList
	  * @Description: TODO
	  * @param @return
	  * @return List<BIAppType>
	  * @throws
	 */
	public List<BIAppType> getAppTypeList(BIAppType appType);
}
