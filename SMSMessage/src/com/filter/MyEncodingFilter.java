package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
/*
 * �ַ���������
 */
@WebFilter(urlPatterns = "/*",initParams = @WebInitParam(name = "encoding",value = "utf-8"))
public class MyEncodingFilter implements Filter{
      String encoding = "utf-8";
	//ֻ�ڳ�ʼ����ǰ��ʱִ��һ��
	        @Override
        public void init(FilterConfig filterConfig) throws ServletException {
          encoding =   filterConfig.getInitParameter("encoding");
        	Filter.super.init(filterConfig);
        }
	
	
	
	
	  //ÿ�����󶼻�ִ��
	     @Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
	    	
	    	 
	    	 //�����ַ���
	        response.setCharacterEncoding(encoding);
            request.setCharacterEncoding(encoding);
		    //���� ����ִ����������������servlet
            chain.doFilter(request, response);
            
            
            
	}

}
