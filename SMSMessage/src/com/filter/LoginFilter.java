package com.filter;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * 登陆过滤器
 */
public class LoginFilter implements Filter{
	   String[] unInclues  = null;
        @Override
        public void init(FilterConfig filterConfig) throws ServletException {
                  String unInclude = filterConfig.getInitParameter("unInclude");
                   unInclues = unInclude.split(";");
        }
        
        
        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        	throws IOException, ServletException {
            //强转
        	HttpServletRequest req = (HttpServletRequest) request;
        	HttpServletResponse resp = (HttpServletResponse) response;
        	//获取请求地址   /login.html  /loginSuccess.html /toLogin
          	StringBuffer url = req.getRequestURL();// http://localhost:8081/servletFilterListener/login.html
        	/*
        	 * String uri = req.getRequestURI();
        	String contextPath = req.getServletContext().getContextPath();
        	//得到请求路径  /login.html
        	 uri.substring(contextPath.length(), uri.length());
        	 */
          	String path = req.getServletPath();  //   /login.html
           //判断当前url是否需要拦截
             //如果不需要拦截,放行 
             if(Arrays.asList(unInclues).contains(path)) {
            	 chain.doFilter(req, response);
            	 return;
             }
        	 //如果需要拦截,再判断是否已经登陆
        	  HttpSession session = req.getSession();
        	  Object username = session.getAttribute("username");
        	 //如果已登录,放行
        	if (username!=null) {
				chain.doFilter(req, response);
				return;
			}
        	 //否则,拦截,跳转到登陆页面
        	resp.sendRedirect("login.jsp");
        }
        
        
        
        @Override
        public void destroy() {
        // TODO Auto-generated method stub
        Filter.super.destroy();
        }
        
        
        
        
}
