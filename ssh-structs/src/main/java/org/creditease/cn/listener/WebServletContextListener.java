package org.creditease.cn.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.creditease.cn.utils.ContextUtils;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class WebServletContextListener implements ServletContextListener {
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		// TODO Auto-generated method stub
		ContextUtils.setApplicationContext(WebApplicationContextUtils
				.getWebApplicationContext(event.getServletContext()));
		ContextUtils.setContextPath(event.getServletContext().getContextPath());
		ContextUtils.setRootPath(event.getServletContext().getRealPath("/"));
	}
}
