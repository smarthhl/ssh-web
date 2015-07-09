package org.creditease.cn.service.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.creditease.cn.common.Result;
import org.creditease.cn.dao.IBIAppTypeDAO;
import org.creditease.cn.model.BIAppType;
import org.creditease.cn.service.IBIAppTypeService;
import org.hibernate.SessionFactory;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.strongmvc.orm.hibernate.GenericDAOHibernate;
import com.strongmvc.orm.hibernate.Page;

/**
 * 
 * @Title: UserServiceImpl
 * @Description:
 * @Copyright:Copyright (c) 2014
 * @Date:2015-3-19
 * @author:xiezhongyong
 */
@Component
public class BIAppTypeServiceImpl implements IBIAppTypeService {
	@Resource
	private IBIAppTypeDAO appTypeDAO;

	private GenericDAOHibernate<BIAppType, String> atDAO;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		atDAO = new GenericDAOHibernate<BIAppType, String>(sessionFactory,
				BIAppType.class);
	}

	@Override
	public Result deleteAppType(BIAppType appType) {
		// TODO Auto-generated method stub
		Result result = null;
		try {
			appTypeDAO.delete(appType);
			result = new Result(1, "成功", appType);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result = new Result(0, e.getMessage(), null);
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Page<BIAppType> getAppTypeList(Page<BIAppType> page,
			BIAppType appType) {
		// TODO Auto-generated method stub
		try {
			String hqlStr = null;
			List<Object> params = new ArrayList<Object>();
			if (appType == null) {
				hqlStr = "from BIAppType";
			} else {
				StringBuilder sb = new StringBuilder(
						"from BIAppType where 1=1 ");
				hqlStr = getHqlStr(sb, appType);
				getParams(params, appType);
			}
			atDAO.find(hqlStr, params.toArray());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return page;
	}

	@Override
	public Result saveAppType(BIAppType appType) {
		// TODO Auto-generated method stub
		Result result = null;
		try {
			appType.setApp_type_id((Long) appTypeDAO.save(appType));
			result = new Result(1, "成功", appType);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result = new Result(0, e.getMessage(), null);
		}
		return result;
	}

	@Override
	public Result updateAppType(BIAppType appType) {
		// TODO Auto-generated method stub
		Result result = null;
		try {
			BIAppType oldAppType = appTypeDAO.getById(BIAppType.class,
					appType.getApp_type_id());
			checkUser(oldAppType, appType);
			appTypeDAO.update(oldAppType);
			result = new Result(1, "成功", oldAppType);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result = new Result(0, e.getMessage(), null);
		}
		return result;
	}

	private void checkUser(BIAppType oldAppType, BIAppType newAppType)
			throws Exception {
		Field[] fields = BIAppType.class.getDeclaredFields();
		for (Field field : fields) {
			String name = field.getName();
			if (!"serialVersionUID".equalsIgnoreCase(name)) {
				field.setAccessible(true);
				if (field.get(newAppType) != null) {
					field.set(oldAppType, field.get(newAppType));
				}
			}
		}
	}

	private String getHqlStr(StringBuilder sb, BIAppType appType)
			throws Exception {
		Field[] fields = BIAppType.class.getDeclaredFields();
		for (Field field : fields) {
			String name = field.getName();
			if (!"serialVersionUID".equalsIgnoreCase(name)) {
				field.setAccessible(true);
				if (field.get(appType) != null) {
					sb.append(" and ").append(name).append("=? ");
				}
			}
		}
		return sb.toString();
	}

	private void getParams(List<Object> params, BIAppType appType)
			throws Exception {
		Field[] fields = BIAppType.class.getDeclaredFields();
		for (Field field : fields) {
			String name = field.getName();
			if (!"serialVersionUID".equalsIgnoreCase(name)) {
				field.setAccessible(true);
				if (field.get(appType) != null) {
					params.add(field.get(appType));
				}
			}
		}
	}

	@Override
	public JSONArray getAppType() {
		// TODO Auto-generated method stub
		JSONArray jsonArr = new JSONArray();
		// String hql="from BIAppType";
		List<BIAppType> lis = atDAO.findAll();
		if (!lis.isEmpty() && lis.size() != 0) {
			for (BIAppType type : lis) {
				JSONObject ob = new JSONObject();
				ob.put("id", type.getApp_type_id());
				ob.put("text", type.getApp_type());
				jsonArr.put(ob);
			}
		}
		// System.out.println(jsonArr.toJSONString());
		return jsonArr;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BIAppType> getAppTypeList(BIAppType appType) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		try {
			String hqlStr = null;
			List<Object> params = new ArrayList<Object>();
			if (appType == null) {
				hqlStr = "from BIAppType";
			} else {
				StringBuilder sb = new StringBuilder(
						"from BIAppType where 1=1 ");
				hqlStr = getHqlStr(sb, appType);
				getParams(params, appType);
			}
			List<BIAppType> results = appTypeDAO.executeQuery(hqlStr, params);
			return results;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}
