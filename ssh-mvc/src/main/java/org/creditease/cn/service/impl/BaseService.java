package org.creditease.cn.service.impl;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.creditease.cn.common.Result;
import org.creditease.cn.dao.IBaseDAO;
import org.creditease.cn.model.IBaseModel;
import org.creditease.cn.model.PageInfo;
import org.creditease.cn.model.SpecialModel;
import org.creditease.cn.service.IBaseService;
import org.creditease.cn.utils.DateUitils;
import org.creditease.cn.utils.NumberUtils;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.strongmvc.orm.hibernate.GenericDAOHibernate;
import com.strongmvc.orm.hibernate.Page;

/**
 * 
 * @ClassName: BaseService
 * @Description: TODO
 * @author caliph
 * @date May 13, 2015 9:11:16 AM
 * @param <T>
 *            Entity
 * @param <E>
 *            DAO
 */
public abstract class BaseService<T extends IBaseModel, E extends IBaseDAO<T, Serializable>>
		implements IBaseService<T> {
	protected static Pattern paramPattern;
	protected static String numberFormat;

	static {
		paramPattern = Pattern.compile("\\$\\{(\\w+)\\}");
		numberFormat = "#,###,###,###,###.##";
	}

	protected GenericDAOHibernate<T, String> gDAO;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		gDAO = new GenericDAOHibernate<T, String>(sessionFactory,
				getEntityClass());
	}

	protected abstract E getDao();

	@SuppressWarnings("unchecked")
	protected Class<T> getEntityClass() {
		Type type = getClass().getGenericSuperclass();
		Type[] types = ((ParameterizedType) type).getActualTypeArguments();
		return (Class<T>) (types[0]);
	}

	protected void checkUser(T oldValue, T newValue) throws Exception {
		Field[] fields = getEntityClass().getDeclaredFields();
		for (Field field : fields) {
			String name = field.getName();
			if (!"serialVersionUID".equalsIgnoreCase(name)) {
				field.setAccessible(true);
				if (field.get(newValue) != null) {
					field.set(oldValue, field.get(newValue));
				}
			}
		}
	}

	protected String getHqlStr(StringBuilder sb, T entity) throws Exception {
		Field[] fields = getEntityClass().getDeclaredFields();
		for (Field field : fields) {
			String name = field.getName();
			if (!"serialVersionUID".equalsIgnoreCase(name)) {
				field.setAccessible(true);
				if (field.get(entity) != null) {
					sb.append(" and ").append(name).append("=? ");
				}
			}
		}
		return sb.toString();
	}

	protected void getParams(List<Object> params, T entity) throws Exception {
		Field[] fields = getEntityClass().getDeclaredFields();
		for (Field field : fields) {
			String name = field.getName();
			if (!"serialVersionUID".equalsIgnoreCase(name)) {
				field.setAccessible(true);
				if (field.get(entity) != null) {
					params.add(field.get(entity));
				}
			}
		}
	}

	protected String formatSqlTemplate(String sqlTemplate,
			Map<String, Object> params) {
		Matcher m = paramPattern.matcher(sqlTemplate);
		String key;
		Object value;
		String newValue;
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			key = m.group(1);
			value = params.get(key);
			if (value == null) {
				m.appendReplacement(sb, "NULL");
				continue;
			} else if (value instanceof Object[]) {
				StringBuilder sb1 = new StringBuilder();
				for (Object obj : (Object[]) value) {
					if (obj instanceof String) {
						if (((String) obj).indexOf("'") < 0) {
							sb1.append("'").append(obj).append("'").append(",");
						} else {
							sb1.append(obj).append(",");
						}
					} else if (obj instanceof SpecialModel<?>) {
						sb1.append(
								String.valueOf(((SpecialModel<?>) obj)
										.getValue())).append(",");
					} else {
						sb1.append(String.valueOf(obj)).append(",");
					}
				}
				newValue = sb1.lastIndexOf(",") >= 0 ? sb1.substring(0,
						sb1.lastIndexOf(",")) : sb1.toString();
			} else if (value instanceof List) {
				StringBuilder sb1 = new StringBuilder();
				for (Object obj : (List<?>) value) {
					if (obj instanceof String) {
						if (((String) obj).indexOf("'") < 0) {
							sb1.append("'").append(obj).append("'").append(",");
						} else {
							sb1.append(obj).append(",");
						}
					} else if (obj instanceof SpecialModel<?>) {
						sb1.append(
								String.valueOf(((SpecialModel<?>) obj)
										.getValue())).append(",");
					} else {
						sb1.append(String.valueOf(obj)).append(",");
					}
				}
				newValue = sb1.lastIndexOf(",") >= 0 ? sb1.substring(0,
						sb1.lastIndexOf(",")) : sb1.toString();
			} else if (value instanceof String) {
				if (((String) value).indexOf("'") < 0) {
					newValue = "'" + value + "'";
				} else {
					newValue = (String) value;
				}

			} else if (value instanceof SpecialModel<?>) {
				newValue = String.valueOf(((SpecialModel<?>) value).getValue());
			} else {
				newValue = String.valueOf(value);
			}
			m.appendReplacement(sb, newValue);
		}
		m.appendTail(sb);
		return sb.toString();
	}

	protected Map<String, Object> formatParams(Map<String, Object> args) {
		Map<String, Object> args1 = new HashMap<String, Object>();
		for (Map.Entry<String, Object> entry : args.entrySet()) {
			args1.put(entry.getKey().toLowerCase(), entry.getValue());
		}
		args.clear();
		args = null;
		return args1;
	}

	protected void formatDate(List<Map<String, Object>> results) {
		for (Map<String, Object> result : results) {
			for (Map.Entry<String, Object> entry : result.entrySet()) {
				if (entry.getValue() instanceof Date) {
					result.put(entry.getKey(),
							DateUitils.getDatetime((Date) entry.getValue()));
				}
			}
		}
	}

	protected void formatNumber(List<Map<String, Object>> results) {
		for (Map<String, Object> result : results) {
			for (Map.Entry<String, Object> entry : result.entrySet()) {
				if (entry.getValue() instanceof Number) {
					result.put(entry.getKey(), NumberUtils.formatNumber(
							(Number) entry.getValue(), numberFormat));
				}
			}
		}
	}

	@Override
	public Result delete(T entity) {
		// TODO Auto-generated method stub
		Result result = null;
		try {
			getDao().delete(entity);
			result = new Result(1, "成功", entity);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result = new Result(0, e.getMessage(), null);
		}
		return result;
	}

	@Override
	public Page<T> getList(Page<T> page, T entity) {
		// TODO Auto-generated method stub
		try {
			String hqlStr = null;
			List<Object> params = new ArrayList<Object>();
			StringBuilder sb = new StringBuilder();
			sb.append("from ").append(getEntityClass().getSimpleName())
					.append(" ");
			if (entity != null) {
				sb.append("where 1=1 ");
				hqlStr = getHqlStr(sb, entity);
				getParams(params, entity);
			} else {
				hqlStr = sb.toString();
			}
			gDAO.find(page, hqlStr, params.toArray());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return page;
	}

	@SuppressWarnings("unchecked")
	@Override
	public PageInfo<T> getList(PageInfo<T> pageInfo, T entity) {
		// TODO Auto-generated method stub
		try {
			String hqlStr = null;
			List<Object> params = new ArrayList<Object>();
			StringBuilder sb = new StringBuilder();
			sb.append("from ").append(getEntityClass().getSimpleName())
					.append(" ");
			if (entity != null) {
				sb.append("where 1=1 ");
				hqlStr = getHqlStr(sb, entity);
				getParams(params, entity);
			} else {
				hqlStr = sb.toString();
			}
			Integer totalSize = getDao().getQueryCount(hqlStr, params);
			pageInfo.setTotalCount(totalSize);
			pageInfo.setTotalPage(totalSize % pageInfo.getPageSize() == 0 ? totalSize
					/ pageInfo.getPageSize()
					: (int) Math.floor(totalSize / pageInfo.getPageSize()) + 1);
			pageInfo.setResult((List<T>) getDao().executeQuery(hqlStr, params,
					pageInfo.getPageNo(), pageInfo.getPageSize()));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return pageInfo;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getList(T entity) {
		// TODO Auto-generated method stub
		try {
			String hqlStr = null;
			List<Object> params = new ArrayList<Object>();
			StringBuilder sb = new StringBuilder();
			sb.append("from ").append(getEntityClass().getSimpleName())
					.append(" ");
			if (entity != null) {
				sb.append("where 1=1 ");
				hqlStr = getHqlStr(sb, entity);
				getParams(params, entity);
			} else {
				hqlStr = sb.toString();
			}
			List<T> results = getDao().executeQuery(hqlStr, params);
			return results;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Result save(T entity) {
		// TODO Auto-generated method stub
		Result result = null;
		try {
			result = new Result(1, "成功", getDao().save(entity));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result = new Result(0, e.getMessage(), null);
		}
		return result;
	}

	@Override
	public Result update(T entity) {
		// TODO Auto-generated method stub
		Result result = null;
		try {
			T oldValue = getDao().getById(getEntityClass(), entity.getId());
			checkUser(oldValue, entity);
			getDao().update(oldValue);
			result = new Result(1, "成功", oldValue);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result = new Result(0, e.getMessage(), null);
		}
		return result;
	}

	@Override
	public Result getById(Serializable id) {
		// TODO Auto-generated method stub
		return new Result(Result.SUCCESS, Result.SUCCESS_MSG, getDao().getById(
				getEntityClass(), id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public <S> PageInfo<S> getList(PageInfo<S> pageInfo, String sqlStr,
			Map<String, Object> args, Class<S> class1) {
		// TODO Auto-generated method stub
		args = formatParams(args);
		sqlStr = sqlStr.toLowerCase();
		sqlStr = formatSqlTemplate(sqlStr, args);
		String countSqlStr = "SELECT COUNT(*) FROM (" + sqlStr + ") AS SC";
		Integer totalSize = getDao().getSqlQueryCount(countSqlStr, null);
		pageInfo.setTotalCount(totalSize);
		pageInfo.setTotalPage(totalSize % pageInfo.getPageSize() == 0 ? totalSize
				/ pageInfo.getPageSize()
				: (int) Math.floor(totalSize / pageInfo.getPageSize()) + 1);
		pageInfo.setResult((List<S>) getDao().executeSqlQuery(sqlStr, null,
				pageInfo.getPageNo(), pageInfo.getPageSize(), class1));
		return pageInfo;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <S> List<S> getList(String sqlStr, Map<String, Object> args,
			Class<S> class1) {
		// TODO Auto-generated method stub
		args = formatParams(args);
		sqlStr = sqlStr.toLowerCase();
		sqlStr = formatSqlTemplate(sqlStr, args);
		List<S> result = (List<S>) getDao().executeSqlQuery(sqlStr, null,
				class1);
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public PageInfo<Map<String, Object>> getList(
			PageInfo<Map<String, Object>> pageInfo, String sqlStr,
			Map<String, Object> args, boolean formateDate, boolean formateNumber) {
		// TODO Auto-generated method stub
		args = formatParams(args);
		sqlStr = sqlStr.toLowerCase();
		sqlStr = formatSqlTemplate(sqlStr, args);
		String countSqlStr = "SELECT COUNT(*) FROM (" + sqlStr + ") AS SC";
		Integer totalSize = getDao().getSqlQueryCount(countSqlStr, null);
		pageInfo.setTotalCount(totalSize);
		pageInfo.setTotalPage(totalSize % pageInfo.getPageSize() == 0 ? totalSize
				/ pageInfo.getPageSize()
				: (int) Math.floor(totalSize / pageInfo.getPageSize()) + 1);
		pageInfo.setResult((List<Map<String, Object>>) getDao()
				.executeSqlQuery(sqlStr, null, pageInfo.getPageNo(),
						pageInfo.getPageSize()));
		if (formateDate) {
			formatDate(pageInfo.getResult());
		}
		if (formateNumber) {
			formatNumber(pageInfo.getResult());
		}
		return pageInfo;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> getList(String sqlStr,
			Map<String, Object> args, boolean formateDate, boolean formateNumber) {
		// TODO Auto-generated method stub
		args = formatParams(args);
		sqlStr = sqlStr.toLowerCase();
		sqlStr = formatSqlTemplate(sqlStr, args);
		List<Map<String, Object>> result = (List<Map<String, Object>>) getDao()
				.executeSqlQuery(sqlStr, null);
		if (formateDate) {
			formatDate(result);
		}
		if (formateNumber) {
			formatNumber(result);
		}
		return result;
	}

	@Override
	public Result queryCount(T entity) {
		// TODO Auto-generated method stub
		Result result = null;
		try {
			String hqlStr = null;
			List<Object> params = new ArrayList<Object>();
			StringBuilder sb = new StringBuilder();
			sb.append("from ").append(getEntityClass().getSimpleName())
					.append(" ");
			if (entity != null) {
				sb.append("where 1=1 ");
				hqlStr = getHqlStr(sb, entity);
				getParams(params, entity);
			} else {
				hqlStr = sb.toString();
			}
			Integer count = getDao().getQueryCount(hqlStr, params);
			result = new Result(Result.SUCCESS, Result.SUCCESS_MSG, count);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result = new Result(Result.ERROR, e.getMessage(), 0);
		}
		return result;
	}

	@Override
	public Result queryCount(String sqlStr, Map<String, Object> args) {
		// TODO Auto-generated method stub
		Result result = null;
		try {
			args = formatParams(args);
			sqlStr = sqlStr.toLowerCase();
			sqlStr = formatSqlTemplate(sqlStr, args);
			Integer count = getDao().getSqlQueryCount(sqlStr, null);
			result = new Result(Result.SUCCESS, Result.SUCCESS_MSG, count);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result = new Result(Result.ERROR, e.getMessage(), 0);
		}
		return result;
	}

}
