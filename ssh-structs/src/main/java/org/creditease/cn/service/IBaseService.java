package org.creditease.cn.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.creditease.cn.common.Result;
import org.creditease.cn.model.IBaseModel;
import org.creditease.cn.model.PageInfo;

import com.strongmvc.orm.hibernate.Page;

public interface IBaseService<T extends IBaseModel> {
	/**
	 * 保存
	 * 
	 * @Title: save
	 * @Description: TODO
	 * @param @param t
	 * @param @return
	 * @return Result
	 * @throws
	 */
	public Result save(T entity);

	/**
	 * 更新
	 * 
	 * @Title: update
	 * @Description: TODO
	 * @param @param entity
	 * @param @return
	 * @return Result
	 * @throws
	 */
	public Result update(T entity);

	/**
	 * 删除
	 * 
	 * @Title: delete
	 * @Description: TODO
	 * @param @param entity
	 * @param @return
	 * @return Result
	 * @throws
	 */
	public Result delete(T entity);
	
	/**
	 * 根据Id获取实例
	  * @Title: getById
	  * @Description: TODO
	  * @param @param id
	  * @param @return
	  * @return Result
	  * @throws
	 */
	public Result getById(Serializable id);

	/**
	 * 查询数量
	 * 
	 * @Title: queryCount
	 * @Description: TODO
	 * @param @param entity
	 * @param @return
	 * @return Result
	 * @throws
	 */
	public Result queryCount(T entity);

	/**
	 * 查询数量
	 * 
	 * @Title: queryCount
	 * @Description: TODO
	 * @param @param sqlStr
	 * @param @param args
	 * @param @return
	 * @return Result
	 * @throws
	 */
	public Result queryCount(String sqlStr, Map<String, Object> args);

	/**
	 * 查询,支持分页
	 * 
	 * @Title: getAppTypeList
	 * @Description: TODO
	 * @param @param page
	 * @param @param entity
	 * @param @return
	 * @return Page<T>
	 * @throws
	 */
	public Page<T> getList(Page<T> page, T entity);

	/**
	 * 查询,支持分页
	 * 
	 * @Title: getList
	 * @Description: TODO
	 * @param @param page
	 * @param @param entity
	 * @param @return
	 * @return Page<T>
	 * @throws
	 */
	public PageInfo<T> getList(PageInfo<T> pageInfo, T entity);

	/**
	 * 查询，不支持分页
	 * 
	 * @Title: getList
	 * @Description: TODO
	 * @param @param entity
	 * @param @return
	 * @return List<T>
	 * @throws
	 */
	public List<T> getList(T entity);

	/**
	 * 执行原生sql语句查询，支持分页
	 * 
	 * @Title: getList
	 * @Description: TODO
	 * @param @param pageInfo
	 * @param @param sqlStr
	 * @param @param args
	 * @param @param class1
	 * @param @return
	 * @return PageInfo<S>
	 * @throws
	 */
	public <S> PageInfo<S> getList(PageInfo<S> pageInfo, String sqlStr,
			Map<String, Object> args, Class<S> class1);

	/**
	 * 执行原生sql语句查询，支持分页
	 * 
	 * @Title: getList
	 * @Description: TODO
	 * @param pageInfo
	 * @param sqlStr
	 * @param args
	 * @param formateDate
	 * @param formateNumber
	 * @param @return
	 * @return PageInfo<Map<String,Object>>
	 * @throws
	 */
	public PageInfo<Map<String, Object>> getList(
			PageInfo<Map<String, Object>> pageInfo, String sqlStr,
			Map<String, Object> args, boolean formateDate, boolean formateNumber);

	/**
	 * 执行原生sql语句查询，不支持分页
	 * 
	 * @Title: getList
	 * @Description: TODO
	 * @param @param sqlStr
	 * @param @param args
	 * @param @param class1
	 * @param @return
	 * @return List<S>
	 * @throws
	 */
	public <S> List<S> getList(String sqlStr, Map<String, Object> args,
			Class<S> class1);

	/**
	 * 执行原生sql语句查询，不支持分页
	 * 
	 * @Title: getList
	 * @Description: TODO
	 * @param sqlStr
	 * @param args
	 * @param formateDate
	 * @param formateNumber
	 * @param @return
	 * @return List<Map<String,Object>>
	 * @throws
	 */
	public List<Map<String, Object>> getList(String sqlStr,
			Map<String, Object> args, boolean formateDate, boolean formateNumber);
}
