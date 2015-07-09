package org.creditease.cn.utils;

import java.io.File;
import java.net.URI;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

public class ContextUtils {
	private static ApplicationContext applicationContext = null;
	private static String rootPath = null;
	private static String contextPath = null;

	public final static void setApplicationContext(ApplicationContext context) {
		applicationContext = context;
	}

	/**
	 * 兼容非WebApplicaion情况下的Spring单元测试用
	 * 
	 * @return ApplicationContext
	 */
	public final static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	/**
	 * 实现了getServletContext()方法
	 * 
	 * @return WebApplicationContext
	 */
	public final static WebApplicationContext getWebApplicationContext() {
		return (applicationContext instanceof WebApplicationContext) ? (WebApplicationContext) applicationContext
				: null;
	}

	/**
	 * 获取Spring的Bean对象
	 * 
	 * @param beanName
	 *            as String
	 * @return Object
	 */
	public final static Object getBean(String beanName) {
		Object obj = null;
		if (applicationContext.containsBean(beanName)) {
			obj = applicationContext.getBean(beanName);
		}
		return obj;
	}

	public final static <T> T getBean(Class<T> clazz) {

		return applicationContext.getBean(clazz);
	}

	public final static <T> T getBean(String beanName, Class<T> clazz) {
		T t = null;
		if (applicationContext.containsBean(beanName))
			t = applicationContext.getBean(beanName, clazz);
		return t;
	}

	public final static void setRootPath(String path) {
		rootPath = path;
	}

	public final static String getRootPath() {
		return rootPath;
	}

	public final static String getRealPath(String path) {
		File webRoot = new File(rootPath);
		URI webRootUri = webRoot.toURI();
		URI uri = webRootUri.resolve(path);
		return uri.getPath();
	}

	public final static void setContextPath(String path) {
		contextPath = path;
	}

	public final static String getContextPath() {
		return contextPath;
	}
}
