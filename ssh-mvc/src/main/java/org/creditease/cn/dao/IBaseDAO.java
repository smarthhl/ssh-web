package org.creditease.cn.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * BaseDAOInterface
 * 
 * @author _xie
 * 
 * @param <T>
 * @param <PK>
 */
public interface IBaseDAO<T, PK extends Serializable> {

	/**
	 * 保存
	 * 
	 * @param entity
	 *            Entity对象
	 */
	public Object save(T entity);

	/**
	 * 删除
	 * 
	 * @param entity
	 *            Entity对象
	 */
	public void delete(T entity);

	/**
	 * 修改
	 * 
	 * @param entity
	 *            Entity对象
	 */
	public void update(T entity);

	/**
	 * 批量删除
	 * 
	 * @param entity
	 * @param ids
	 *            ID串【数组】
	 */
	public void delete(T entity, PK[] ids);

	/**
	 * 通过ID getEntity【即时加载】
	 * 
	 * @param entity
	 * @param id
	 *            主键
	 */
	public T getById(Class c, PK id);

	/**
	 * 通过ID loadEntity【延时加载】
	 * 
	 * @param entity
	 * @param id
	 *            主键
	 */
	public T loadById(T entity, PK id);

	/**
	 * 检测对象是否存在
	 * 
	 * @param entity
	 * @param propertyName
	 * @param value
	 * @return
	 */
	public boolean isExist(final T entity, final String propertyName,
			final Object value);

	/**
	 * 查全部,支持分页
	 * 
	 * @param hql
	 * @param args
	 * @param pageBean
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List executeQuery(final String hql, final Map<String, Object> args,
			final Integer pageNo, final Integer pageSize);
	
	public List executeQuery(final String hql, final List<Object> args,
			final Integer pageNo, final Integer pageSize);
	
	/**
	 * 执行sql原生语句，并且返回自定义对象列表,支持分页
	  * @Title: executeSqlQuery
	  * @Description: TODO
	  * @param @param sql 以jdbc风格编写
	  * @param @param args
	  * @param @param pageNo
	  * @param @param pageSize
	  * @param @param class1
	  * @param @return
	  * @return List<T>
	  * @throws
	 */
	public List<?> executeSqlQuery(final String sql, final List<Object> args,
			final Integer pageNo, final Integer pageSize,Class<?> class1);
	
	public List<?> executeSqlQuery(final String sql, final List<Object> args,
			final Integer pageNo, final Integer pageSize);

	/**
	 * 查全部,支持分页
	 * 
	 * @param hql
	 * @param args
	 * @param pageBean
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List executeQuery(final String hql, final Map<String, Object> args);
	
	public List executeQuery(final String hql, final List<Object> args);
	
	/**
	 * 执行sql原生语句，并且返回自定义对象列表
	  * @Title: executeSqlQuery
	  * @Description: TODO
	  * @param @param sql 以jdbc风格编写
	  * @param @param args
	  * @param @param class1
	  * @param @return
	  * @return List<?>
	  * @throws
	 */
	public List<?> executeSqlQuery(final String sql, final List<Object> args,Class<?> class1);
	
	public List<?> executeSqlQuery(final String sql, final List<Object> args);
	
	public Integer executeSqlUpdate(final String sql, final List<Object> args);

	/**
	 * 查全部,支持分页
	 * 
	 * @param hql
	 * @param args
	 * @param pageBean
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List executeQuery(final String hql);

	/**
	 * 查全部,获取匹配条件count
	 * 
	 * @param hql
	 * @param args
	 * @param pageBean
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Integer getQueryCount(final String hql,
			final Map<String, Object> args);
	
	public Integer getQueryCount(final String hql,
			final List<Object> args);
	
	/**
	 * 执行sql原生语句,获取满足查询条件总数
	  * @Title: getSqlQueryCount
	  * @Description: TODO
	  * @param @param sql 以jdbc风格编写
	  * @param @param args
	  * @param @return
	  * @return Integer
	  * @throws
	 */
	public Integer getSqlQueryCount(final String sql,
			final List<Object> args);
	
	/**
	 * 批量更新
	 * 
	 * @param hql
	 * @param args
	 * @return
	 */
	public Integer executeUpdate(final String hql,
			final Map<String, Object> args);
	
	public Integer executeUpdate(final String hql,
			final List<Object> args);

	/**
	 * 批量删除
	 * 
	 * @param hql
	 * @param args
	 */
	public void deleteAll(final String hql, final Map<String, Object> args);
}
