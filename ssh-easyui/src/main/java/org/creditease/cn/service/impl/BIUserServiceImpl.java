package org.creditease.cn.service.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.creditease.cn.common.Result;
import org.creditease.cn.dao.IBIUserDAO;
import org.creditease.cn.model.BIAppKey;
import org.creditease.cn.model.BIUser;
import org.creditease.cn.service.IBIUserService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.strongmvc.model.User;
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
public class BIUserServiceImpl implements IBIUserService {
	@Resource
	private IBIUserDAO userDAO;

	private GenericDAOHibernate<BIUser, String> urDAO;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		urDAO = new GenericDAOHibernate<BIUser, String>(sessionFactory,
				BIUser.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Result getUserByEmail(BIUser user) {
		// TODO Auto-generated method stub
		Result result = null;
		try {
			String hqlStr = "from BIUser as a where a.email=:email";
			Map<String, Object> args = new HashMap<String, Object>();
			args.put("email", user.getEmail());
			List<BIUser> results = userDAO.executeQuery(hqlStr, args);
			if (results == null || results.size() == 0) {
				result = new Result(0, "邮箱不存在", null);
			} else {
				result = new Result(1, "成功", results.get(0));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Result getUserByName(BIUser user) {
		// TODO Auto-generated method stub
		Result result = null;
		try {
			String hqlStr = "from BIUser as a where a.user_name=:userName";
			Map<String, Object> args = new HashMap<String, Object>();
			args.put("userName", user.getUser_name());
			List<BIUser> results = userDAO.executeQuery(hqlStr, args);
			if (results == null || results.size() == 0) {
				result = new Result(0, "用户名不存在", null);
			} else {
				result = new Result(1, "成功", results.get(0));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Result userLogin(BIUser user) {
		// TODO Auto-generated method stub
		Result result = null;
		if(user.getEmail().isEmpty()){
			result = new Result(2, "账号不能为空", null);
			return result;
		}
		if(user.getPswd().isEmpty()){
			result = new Result(2, "请输入密码", null);
			return result;
		}
		try {
			String hqlStr = "from BIUser as a where a.email=:email and a.pswd=:pswd";
			Map<String, Object> args = new HashMap<String, Object>();
			args.put("email", user.getEmail());
			args.put("pswd", user.getPswd());
			List<BIUser> results = userDAO.executeQuery(hqlStr, args);
			if (results == null || results.size() == 0) {
				result = new Result(0, "账号或密码不正确", null);
			} else {
				result = new Result(1, "成功", results.get(0));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Result userUpdate(BIUser user) {
		// TODO Auto-generated method stub
		Result result = null;
		try {
			BIUser oldUserInfo = userDAO.getById(BIUser.class,
					user.getUser_id());
			checkUser(oldUserInfo, user);
			userDAO.update(oldUserInfo);
			oldUserInfo.setUpdate_time(new Date());
			result = new Result(1, "保存成功", oldUserInfo);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result = new Result(0, e.getMessage(), null);
		}
		return result;
	}

	@Override
	public Result userRegister(BIUser user) {
		// TODO Auto-generated method stub
		Result result = null;
		try {
			userDAO.save(user);
			result = new Result(1, "注册成功", user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result = new Result(0, e.getMessage(), null);
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BIUser> getUserList(BIUser user) {
		// TODO Auto-generated method stub
		try {
			String hqlStr = null;
			List<Object> params = new ArrayList<Object>();
			if (user == null) {
				hqlStr = "from BIUser";
			} else {
				StringBuilder sb = new StringBuilder("from BIUser where 1=1");
				hqlStr = getHqlStr(sb, user);
				getParams(params, user);
			}
			List<BIUser> results = userDAO.executeQuery(hqlStr, params);
			return results;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Page<BIUser> getUserList(Page<BIUser> page, BIUser user) {
		// TODO Auto-generated method stub
		try {
			String hqlStr = null;
			List<Object> params = new ArrayList<Object>();
			if (user==null) {
				hqlStr = "from BIUser";
			} else {
				StringBuilder sb = new StringBuilder("from BIUser where 1=1 ");
				hqlStr = getHqlStr(sb, user);
				getParams(params, user);
			}
			urDAO.find(page, hqlStr, params.toArray());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return page;
	}

	private void checkUser(BIUser oldUser, BIUser newUser) throws Exception {
		Field[] fields = BIUser.class.getDeclaredFields();
		for (Field field : fields) {
			String name = field.getName();
			if (!"serialVersionUID".equalsIgnoreCase(name)) {
				field.setAccessible(true);
				if (field.get(newUser) != null) {
					field.set(oldUser, field.get(newUser));
				}
			}
		}
	}

	private String getHqlStr(StringBuilder sb, BIUser user) throws Exception {
		Field[] fields = BIUser.class.getDeclaredFields();
		for (Field field : fields) {
			String name = field.getName();
			//sb.append("and");
			if (!"serialVersionUID".equalsIgnoreCase(name)) {
				field.setAccessible(true);
				if (field.get(user) != null) {
					sb.append(" and ").append(name).append("=? ");
				}
			}
		}
		System.out.println("AAAAAAAAAAAAAAAAAAAAAAA::::"+sb.toString());
		return sb.toString();
	}

	private void getParams(List<Object> params, BIUser user) throws Exception {
		Field[] fields = BIUser.class.getDeclaredFields();
		for (Field field : fields) {
			String name = field.getName();
			if (!"serialVersionUID".equalsIgnoreCase(name)) {
				field.setAccessible(true);
				if (field.get(user) != null) {
					params.add(field.get(user));
				}
			}
		}
	}

	@Override
	/**
	 * 保存User
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public Result saveUser(BIUser model)throws Exception{
		Result result=Result.errorResult();
		if(model!=null){
			model.setCreate_time(new Date());
			model.setUpdate_time(new Date());
			userDAO.save(model);
		}else{
			return result;
		}
		result=Result.successResult();
		return result;
	}
	public void delete(int id) {
		userDAO.delete(userDAO.getById(User.class, id));
	}
	
	/**
	 * 
	* @Title: formatApp_key
	* @Description: TODO(格式化AppKey)
	* @param @param appKeys
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	public String formatApp_key(List<BIAppKey> appKeys) {
		if (appKeys == null || appKeys.size() == 0) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		for (BIAppKey appKey : appKeys) {
			if (!StringUtils.isBlank(appKey.getApp_key())) {
				sb.append("'").append(appKey.getApp_key()).append("'").append(",");
			}
		}
		return sb.lastIndexOf(",") >= 0 ? sb.substring(0, sb.lastIndexOf(","))
				: sb.toString();
	}
}
