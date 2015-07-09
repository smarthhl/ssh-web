package org.creditease.cn.interceptor;

import org.apache.struts2.ServletActionContext;
import org.creditease.cn.web.BaseAction;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class WebInterceptor extends AbstractInterceptor {

	/**
	 * @Fields serialVersionUID:TODO
	 */
	private static final long serialVersionUID = -3274701637596297312L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		if (invocation.getAction() instanceof BaseAction) {
			((BaseAction) invocation.getAction()).setServlet(
					ServletActionContext.getRequest(),
					ServletActionContext.getResponse());
		}
		return invocation.invoke();

	}
}
