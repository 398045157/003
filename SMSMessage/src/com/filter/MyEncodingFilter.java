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
 * 字符集过滤器
 */
@WebFilter(urlPatterns = "/*",initParams = @WebInitParam(name = "encoding",value = "utf-8"))
public class MyEncodingFilter implements Filter{
      String encoding = "utf-8";
	//只在初始化当前类时执行一次
	        @Override
        public void init(FilterConfig filterConfig) throws ServletException {
          encoding =   filterConfig.getInitParameter("encoding");
        	Filter.super.init(filterConfig);
        }
	
	
	
	
	  //每次请求都会执行
	     @Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
	    	
	    	 
	    	 //更改字符集
	        response.setCharacterEncoding(encoding);
            request.setCharacterEncoding(encoding);
		    //放行 继续执行其他过滤器或者servlet
            chain.doFilter(request, response);
            
            
            
	}

}
