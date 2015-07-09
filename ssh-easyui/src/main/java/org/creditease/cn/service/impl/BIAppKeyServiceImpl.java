package org.creditease.cn.service.impl;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.creditease.cn.common.Result;
import org.creditease.cn.dao.IBIAppKeyDAO;
import org.creditease.cn.model.BIAppKey;
import org.creditease.cn.service.IBIAppKeyService;
import org.creditease.cn.utils.DateUitils;
import org.creditease.cn.utils.FinalConstant;
import org.creditease.cn.utils.UUIDUtils;
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
public class BIAppKeyServiceImpl implements IBIAppKeyService {
	@Resource
	private IBIAppKeyDAO appKeyDAO;

	private GenericDAOHibernate<BIAppKey, String> akDAO;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		akDAO = new GenericDAOHibernate<BIAppKey, String>(sessionFactory,
				BIAppKey.class);
	}

	@Override
	public Result deleteAppKey(BIAppKey appKey) {
		// TODO Auto-generated method stub
		Result result = null;
		try {
			appKeyDAO.delete(appKey);
			result = new Result(1, "删除成功", appKey);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result = new Result(0, e.getMessage(), null);
		}
		return result;
	}

	@Override
	public Page<BIAppKey> getAppListByKey(Page<BIAppKey> page, BIAppKey appKey) {
		// TODO Auto-generated method stub
		try {
			String hqlStr = null;
			List<Object> params = new ArrayList<Object>();
			if (appKey == null) {
				hqlStr = "from BIAppKey";
			} else {
				StringBuilder sb = new StringBuilder("from BIAppKey where 1=1 ");
				hqlStr = getHqlStr(sb, appKey);
				getParams(params, appKey);
			}
			hqlStr = hqlStr + " order by id desc";
			akDAO.find(page, hqlStr, params.toArray());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return page;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BIAppKey> getAppListByKey(BIAppKey appKey) {
		// TODO Auto-generated method stub
		try {
			String hqlStr = null;
			List<Object> params = new ArrayList<Object>();
			if (appKey == null) {
				hqlStr = "from BIAppKey";
			} else {
				StringBuilder sb = new StringBuilder("from BIAppKey where 1=1 ");
				hqlStr = getHqlStr(sb, appKey);
				getParams(params, appKey);
			}
			List<BIAppKey> results = appKeyDAO.executeQuery(hqlStr, params);
			return results;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public JSONObject checkKeyStatus(BIAppKey appkey) throws Exception{
		
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("app_key", appkey.getApp_key());
		args.put("app_pkg_name", appkey.getApp_pkg_name());
		args.put("app_type_id", appkey.getApp_type_id());
		List<BIAppKey> list=appKeyDAO.executeQuery("from BIAppKey where app_key=:app_key and app_pkg_name=:app_pkg_name and app_type_id=:app_type_id", args);
		JSONObject js=new JSONObject();
		if(!list.isEmpty()&&list.size()!=0){
			BIAppKey app=list.get(0);
			Date sd=new Date();
			Date s=DateUitils.parseDatetime(app.getValid_to());
			if(sd.after(s)){
				js.put("key_status", FinalConstant.STA_OVERDUE);
				js.put("status_message", FinalConstant.APP_OVERDUE);
			}else{
				js.put("key_status", FinalConstant.STA_VALID);
				js.put("status_message", FinalConstant.APP_VALID);
			}
		}else{
			Map<String, Object> args1 = new HashMap<String, Object>();
			args1.put("app_pkg_name", appkey.getApp_pkg_name());
			args1.put("app_type_id", appkey.getApp_type_id());
			List<BIAppKey> list1=appKeyDAO.executeQuery("from BIAppKey where  app_pkg_name=:app_pkg_name and app_type_id=:app_type_id", args1);
			if(!list1.isEmpty()&&list1.size()!=0){
				js.put("key_status", FinalConstant.STA_INPUT);
				js.put("status_message", FinalConstant.APP_INPUT);
			}else{
				js.put("key_status", FinalConstant.STA_APPLY);
				js.put("status_message", FinalConstant.APP_APPLY);
			}
		}
		return js;
	}

	public JSONArray getAppByUser(BIAppKey user) {
		JSONArray jsonArr = new JSONArray();
		JSONObject ob1 = new JSONObject();
		ob1.put("id", "All");
		ob1.put("text", "All");
		ob1.put("selected", true);
		//((List<Object>) jsonArr).add(ob1);
		jsonArr.put(ob1);
		List<BIAppKey> lis = getAppListByKey(user);
		if (!lis.isEmpty() && lis.size() != 0) {
			for (BIAppKey type : lis) {
				JSONObject ob = new JSONObject();
				ob.put("id", type.getApp_key());
				ob.put("text", type.getApp_name());
				jsonArr.put(ob);
			}
		}
		// System.out.println(jsonArr.toJSONString());
		return jsonArr;
	}

	@Override
	public Result updateAppKey(BIAppKey appKey) {
		// TODO Auto-generated method stub
		Result result = null;
		try {
			BIAppKey oldAppKey = appKeyDAO.getById(BIAppKey.class,
					appKey.getId());
			checkUser(oldAppKey, appKey);
			appKeyDAO.update(oldAppKey);
			oldAppKey.setUpdate_time(new Date());
			result = new Result(1, "保存成功", oldAppKey);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result = new Result(0, e.getMessage(), null);
		}
		return result;
	}

	@Override
	public Result saveAppKey(BIAppKey appKey) {
		// TODO Auto-generated method stub
		Result result = null;
		try {

			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());
			Timestamp ts = DateUitils.getNowDatetimestamp(cal.getTime());
			appKey.setApp_key(UUIDUtils.getUUID());
			appKey.setCreate_time(ts);
			appKey.setUpdate_time(ts);
			appKey.setValid_from(ts);
			cal.add(Calendar.YEAR, 30);// 得到30年后的日期
			Timestamp tsAfter30 = DateUitils.getNowDatetimestamp(cal.getTime());
			appKey.setValid_to(tsAfter30);
			appKeyDAO.save(appKey);
			result = new Result(1, "保存成功", appKey);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result = new Result(0, e.getMessage(), null);
		}
		return result;
	}

	// /**
	// * 保存User
	// * @param model
	// * @return
	// * @throws Exception
	// */
	// public Result saveAppKey(BIAppKey model) throws SystemException{
	// Result result=Result.errorResult();
	// if(model!=null){
	// Calendar cal = Calendar.getInstance();
	// cal.setTime(new Date());
	// Timestamp ts = DateUitils.getNowDatetimestamp(cal.getTime());
	// if (model.getId()!=null){
	// model.setUpdate_time(ts);
	// }else{
	// model.setApp_key(UUIDUtils.getUUID());
	// model.setCreate_time(ts);
	// model.setUpdate_time(ts);
	// model.setValid_from(ts);
	// cal.add(Calendar.YEAR, 30);// 得到30年后的日期
	// Timestamp tsAfter30 = DateUitils.getNowDatetimestamp(cal.getTime());
	// model.setValid_to(tsAfter30);
	// }
	// try {
	// appKeyDAO.save(model);
	// } catch (Exception e) {
	// // TODO: handle exception
	// e.printStackTrace();
	// return result;
	// }
	//
	// }else{
	// return result;
	// }
	// result=Result.successResult();
	// return result;
	// }

	private void checkUser(BIAppKey oldAppKey, BIAppKey newAppKey)
			throws Exception {
		Field[] fields = BIAppKey.class.getDeclaredFields();
		for (Field field : fields) {
			String name = field.getName();
			if (!"serialVersionUID".equalsIgnoreCase(name)) {
				field.setAccessible(true);
				if (field.get(newAppKey) != null) {
					field.set(oldAppKey, field.get(newAppKey));
				}
			}
		}
	}

	private String getHqlStr(StringBuilder sb, BIAppKey appKey)
			throws Exception {
		Field[] fields = BIAppKey.class.getDeclaredFields();
		for (Field field : fields) {
			String name = field.getName();
			if (!"serialVersionUID".equalsIgnoreCase(name)) {
				field.setAccessible(true);
				if (field.get(appKey) != null) {
					sb.append(" and ").append(name).append("=? ");
				}
			}
		}
		return sb.toString();
	}

	private void getParams(List<Object> params, BIAppKey appKey)
			throws Exception {
		Field[] fields = BIAppKey.class.getDeclaredFields();
		for (Field field : fields) {
			String name = field.getName();
			if (!"serialVersionUID".equalsIgnoreCase(name)) {
				field.setAccessible(true);
				if (field.get(appKey) != null) {
					params.add(field.get(appKey));
				}
			}
		}
	}
}
