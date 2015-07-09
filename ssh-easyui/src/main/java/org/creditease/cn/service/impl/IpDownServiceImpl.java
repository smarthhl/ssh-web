package org.creditease.cn.service.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.creditease.cn.common.Result;
import org.creditease.cn.dao.IIpDownDAO;
import org.creditease.cn.model.BIUser;
import org.creditease.cn.model.IpDown;
import org.creditease.cn.service.IIpDownService;
import org.springframework.stereotype.Component;


/**
 * 
 * @Title: UserServiceImpl
 * @Description:
 * @Copyright:Copyright (c) 2014
 * @Date:2015-3-19
 * @author:xiezhongyong
 */
@Component
public class IpDownServiceImpl implements IIpDownService {
	@Resource
	private IIpDownDAO userDAO;

	@Override
	public List<IpDown> getIpList(IpDown ip) {
		// TODO Auto-generated method stub
		try {
			String hqlStr = null;
			List<Object> params = new ArrayList<Object>();
			if (ip == null) {
				hqlStr = "from IpDown";
			} else {
				StringBuilder sb = new StringBuilder("from BIUser where 1=1");
				hqlStr = getHqlStr(sb, ip);
				getParams(params, ip);
			}
			List<IpDown> results = userDAO.executeQuery(hqlStr, params);
			return results;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Result saveIp(IpDown ip) {
		Result result = null;
		try {
			userDAO.save(ip);
			List<IpDown> ips=getIpList(null);
			long count=0;
			if(!ips.isEmpty()&&ips.size()!=0){
				count=ips.size();
			}
			result = new Result(1, ""+count, count);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result = new Result(0, e.getMessage(), null);
		}
		return result;
	}

	private String getHqlStr(StringBuilder sb, IpDown user) throws Exception {
		Field[] fields = IpDown.class.getDeclaredFields();
		for (Field field : fields) {
			String name = field.getName();
			if (!"serialVersionUID".equalsIgnoreCase(name)) {
				field.setAccessible(true);
				if (field.get(user) != null) {
					sb.append(" and ").append(name).append("=? ");
				}
			}
		}
		return sb.toString();
	}
	
	private void getParams(List<Object> params, IpDown user) throws Exception {
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
}
