package org.creditease.cn.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.creditease.cn.dao.IBaseDAO;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * IBaseDAO
 * 
 * @author _xie
 * 
 * @param <T>
 * @param <PK>
 */
public class BaseDAOImpl<T, PK extends Serializable> implements IBaseDAO<T, PK> {

	private static final Logger log = Logger.getLogger(BaseDAOImpl.class);
	private static HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource(name = "hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {

		this.hibernateTemplate = hibernateTemplate;
	}

	/**
	 * 保存
	 * 
	 * @param entity
	 *            Entity对象
	 */
	public Object save(T entity) {
		return getHibernateTemplate().merge(entity);
	}

	/**
	 * 删除
	 * 
	 * @param entity
	 *            Entity对象
	 */
	public void delete(T entity) {
		getHibernateTemplate().delete(entity);
	}

	/**
	 * 修改
	 * 
	 * @param entity
	 *            Entity对象
	 */
	public void update(T entity) {
		getHibernateTemplate().update(entity);
	}

	/**
	 * 批量删除
	 * 
	 * @param entity
	 * @param ids
	 *            ID串【数组】
	 */
	public void delete(T entity, PK[] ids) {
		for (PK id : ids) {
			Object object = this.getHibernateTemplate().get(entity.getClass(),
					id);
			this.getHibernateTemplate().delete(object);
		}
	}

	/**
	 * 通过ID getEntity【即时加载】
	 * 
	 * @param entity
	 * @param id
	 *            主键
	 */
	@SuppressWarnings("unchecked")
	public T getById(Class c, PK id) {
		return (T) getHibernateTemplate().get(c, id);
	}

	/**
	 * 通过ID loadEntity【延时加载】
	 * 
	 * @param entity
	 * @param id
	 *            主键
	 */
	@SuppressWarnings("unchecked")
	public T loadById(T entity, PK id) {
		return (T) getHibernateTemplate().load(entity.getClass(), id);
	}

	/**
	 * 检测对象是否存在
	 * 
	 * @param entity
	 * @param propertyName
	 * @param value
	 * @return
	 */
	public boolean isExist(final T entity, final String propertyName,
			final Object value) {
		Integer count = (Integer) getHibernateTemplate().execute(
				new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						String queryString = "select count(*) from "
								+ entity.getClass().getSimpleName() + " where "
								+ propertyName + "=:" + propertyName;

						Object count = session.createQuery(queryString)
								.setParameter(propertyName, value)
								.uniqueResult();

						return Integer.parseInt(count + "");
					}

				});
		if (count > 0) {
			return true;
		}
		return false;
	}

	// Query接口通用赋值
	@SuppressWarnings({ "rawtypes" })
	private final void setParameters(Query query, Map<String, Object> args) {
		if (log.isInfoEnabled()) {
			log.info("args=" + args);
		}
		if (null == args || 0 == args.size()) {
			return;
		}

		String name = null;
		Object value = null;
		Iterator<String> it = args.keySet().iterator();
		while (it.hasNext()) {
			name = it.next();
			value = args.get(name);
			if (value instanceof Collection) {// 仅:命名参数支持Collection集合或数组
				query.setParameterList(name, (Collection) value);
			} else if (value instanceof Object[]) {
				query.setParameterList(name, (Object[]) value);
			} else {
				query.setParameter(name, value);
			}
		}
	}

	/**
	 * 为以jdbc风格编写的sql的变量进行赋值
	 * 
	 * @Title: setParameters
	 * @Description: TODO
	 * @param @param query
	 * @param @param args
	 * @return void
	 * @throws
	 */
	private final void setParameters(Query query, List<Object> args) {
		if (log.isInfoEnabled()) {
			log.info("args=" + args);
		}
		if (null == args || 0 == args.size()) {
			return;
		}

		if (args != null) {
			int i = 0;
			for (Object arg : args) {
				query.setParameter(i, arg);
				i++;
			}
		}
	}

	/**
	 * 查全部,支持分页
	 * 
	 * @param hql
	 * @param args
	 * @param pageBean
	 * @return
	 */
	@SuppressWarnings({ "rawtypes" })
	public List executeQuery(final String hql, final Map<String, Object> args,
			final Integer pageNo, final Integer pageSize) {

		try {
			return getHibernateTemplate().executeFind(new HibernateCallback() {

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					Query query = session.createQuery(hql);
					setParameters(query, args);
					query.setMaxResults(pageSize).setFirstResult(
							(pageNo - 1) * pageSize);
					return query.list();
				}

			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@SuppressWarnings("rawtypes")
	@Override
	public List executeQuery(final String hql, final List<Object> args,
			final Integer pageNo, final Integer pageSize) {
		// TODO Auto-generated method stub
		try {
			return getHibernateTemplate().executeFind(new HibernateCallback() {

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					Query query = session.createQuery(hql);
					setParameters(query, args);
					query.setMaxResults(pageSize).setFirstResult(
							(pageNo - 1) * pageSize);
					return query.list();
				}

			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 查全部,支持分页
	 * 
	 * @param hql
	 * @param args
	 * @param pageBean
	 * @return
	 */
	@SuppressWarnings({ "rawtypes" })
	public List executeQuery(final String hql, final Map<String, Object> args) {

		try {
			return getHibernateTemplate().executeFind(new HibernateCallback() {

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					Query query = session.createQuery(hql);
					setParameters(query, args);
					return query.list();
				}

			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@SuppressWarnings("rawtypes")
	public List executeQuery(final String hql, final List<Object> args) {

		try {
			return getHibernateTemplate().executeFind(new HibernateCallback() {

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					Query query = session.createQuery(hql);
					setParameters(query, args);
					return query.list();
				}

			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 查全部,支持分页
	 * 
	 * @param hql
	 * @param args
	 * @param pageBean
	 * @return
	 */
	@SuppressWarnings({ "rawtypes" })
	public List executeQuery(final String hql) {

		try {
			return getHibernateTemplate().executeFind(new HibernateCallback() {

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					Query query = session.createQuery(hql);
					return query.list();
				}

			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 查全部,获取匹配条件count
	 * 
	 * @param hql
	 * @param args
	 * @param pageBean
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Integer getQueryCount(final String hql,
			final Map<String, Object> args) {

		return (Integer) getHibernateTemplate().execute(
				new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(" SELECT COUNT(*) "
								+ hql);
						setParameters(query, args);
						return Integer.parseInt(query.uniqueResult() + "");
					}

				});

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Integer getQueryCount(final String hql, final List<Object> args) {
		// TODO Auto-generated method stub
		return (Integer) getHibernateTemplate().execute(
				new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(" SELECT COUNT(*) "
								+ hql);
						setParameters(query, args);
						return Integer.parseInt(query.uniqueResult() + "");
					}

				});
	}

	/**
	 * 批量更新
	 * 
	 * @param hql
	 * @param args
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Integer executeUpdate(final String hql,
			final Map<String, Object> args) {
		if (log.isInfoEnabled()) {
			log.info("hql=[" + hql + "]");
		}
		return (Integer) getHibernateTemplate().execute(
				new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(hql);
						setParameters(query, args);
						Integer rowCount = query.executeUpdate();
						return rowCount;
					}

				});

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Integer executeUpdate(final String hql, final List<Object> args) {
		// TODO Auto-generated method stub
		if (log.isInfoEnabled()) {
			log.info("hql=[" + hql + "]");
		}
		return (Integer) getHibernateTemplate().execute(
				new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(hql);
						setParameters(query, args);
						Integer rowCount = query.executeUpdate();
						return rowCount;
					}

				});
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void deleteAll(final String hql, final Map<String, Object> args) {

		try {
			getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					Query query = session.createQuery(hql);
					setParameters(query, args);
					return query.executeUpdate();
				}

			});
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public T getByTerm(final String hql, final Map<String, Object> args) {

		try {
			Object obj = getHibernateTemplate().execute(
					new HibernateCallback() {

						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
							Query query = session.createQuery(hql);
							setParameters(query, args);
							return query.uniqueResult();
						}

					});
			if (null != obj)
				return (T) obj;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public List<?> executeSqlQuery(String sql, List<Object> args,
			Class<?> class1) {
		// TODO Auto-generated method stub
		Session session = getHibernateTemplate().getSessionFactory()
				.openSession();
		try {
			Query query = session.createSQLQuery(sql);
			setParameters(query, args);
			query.setResultTransformer(Transformers.aliasToBean(class1));
			return query.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<?> executeSqlQuery(String sql, List<Object> args) {
		// TODO Auto-generated method stub
		Session session = getHibernateTemplate().getSessionFactory()
				.openSession();
		try {
			Query query = session.createSQLQuery(sql);
			setParameters(query, args);
			query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
			return query.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<?> executeSqlQuery(String sql, List<Object> args,
			Integer pageNo, Integer pageSize, Class<?> class1) {
		// TODO Auto-generated method stub
		Session session = getHibernateTemplate().getSessionFactory()
				.openSession();
		try {
			Query query = session.createSQLQuery(sql);
			setParameters(query, args);
			query.setMaxResults(pageSize)
					.setFirstResult((pageNo - 1) * pageSize)
					.setResultTransformer(Transformers.aliasToBean(class1));
			return query.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<?> executeSqlQuery(String sql, List<Object> args,
			Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		Session session = getHibernateTemplate().getSessionFactory()
				.openSession();
		try {
			Query query = session.createSQLQuery(sql);
			setParameters(query, args);
			query.setMaxResults(pageSize)
					.setFirstResult((pageNo - 1) * pageSize)
					.setResultTransformer(
							CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
			return query.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public Integer getSqlQueryCount(String sql, List<Object> args) {
		// TODO Auto-generated method stub
		Session session = getHibernateTemplate().getSessionFactory()
				.openSession();
		try {
			Query query = session.createSQLQuery(sql);
			setParameters(query, args);
			return Integer.valueOf(query.uniqueResult() + "");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			session.close();
		}
		return 0;
	}

	@Override
	public Integer executeSqlUpdate(String sql, List<Object> args) {
		// TODO Auto-generated method stub
		Session session = getHibernateTemplate().getSessionFactory()
				.openSession();
		try {
			Query query = session.createSQLQuery(sql);
			setParameters(query, args);
			return query.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			session.close();
		}
		return 0;
	}

}
