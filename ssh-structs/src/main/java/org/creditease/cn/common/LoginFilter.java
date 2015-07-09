package org.creditease.cn.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {  
    }  
  
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,  
                         FilterChain filterChain) throws IOException, ServletException {  
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;  
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;  
        String user =  (String) httpServletRequest.getSession(true).getAttribute("username");  
        if (!isExcludePages(httpServletRequest.getRequestURI())) {  
            if (user == null) {  
                httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/login.jsp");  
                return;  
            }  
        }  
        filterChain.doFilter(servletRequest, servletResponse);  
    }  
  
    private boolean isExcludePages(String url) {  
        return url.indexOf("login.jsp") != -1  
                || url.indexOf("logout.jsp") != -1  
                || url.indexOf("login.jsp") != -1  
                || url.endsWith(".css")  
                || url.endsWith(".js")  
                || url.endsWith(".gif")  
                || url.endsWith(".jpg")  
                || url.endsWith(".png");  
    }  
  
    public void destroy() {  
    }  

}
