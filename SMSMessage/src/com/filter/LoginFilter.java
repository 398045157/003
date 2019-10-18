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
 * ��½������
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
            //ǿת
        	HttpServletRequest req = (HttpServletRequest) request;
        	HttpServletResponse resp = (HttpServletResponse) response;
        	//��ȡ�����ַ   /login.html  /loginSuccess.html /toLogin
          	StringBuffer url = req.getRequestURL();// http://localhost:8081/servletFilterListener/login.html
        	/*
        	 * String uri = req.getRequestURI();
        	String contextPath = req.getServletContext().getContextPath();
        	//�õ�����·��  /login.html
        	 uri.substring(contextPath.length(), uri.length());
        	 */
          	String path = req.getServletPath();  //   /login.html
           //�жϵ�ǰurl�Ƿ���Ҫ����
             //�������Ҫ����,���� 
             if(Arrays.asList(unInclues).contains(path)) {
            	 chain.doFilter(req, response);
            	 return;
             }
        	 //�����Ҫ����,���ж��Ƿ��Ѿ���½
        	  HttpSession session = req.getSession();
        	  Object username = session.getAttribute("username");
        	 //����ѵ�¼,����
        	if (username!=null) {
				chain.doFilter(req, response);
				return;
			}
        	 //����,����,��ת����½ҳ��
        	resp.sendRedirect("login.jsp");
        }
        
        
        
        @Override
        public void destroy() {
        // TODO Auto-generated method stub
        Filter.super.destroy();
        }
        
        
        
        
}
