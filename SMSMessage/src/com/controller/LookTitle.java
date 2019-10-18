package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/LookTitle")
public class LookTitle extends HttpServlet{
     @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         // req.setCharacterEncoding("utf-8");
    	 
    	 String content = req.getParameter("content");

		 HttpSession session = req.getSession();
		 //向session中添加用户对象
		 session.setAttribute("content", content);	
	     resp.sendRedirect("send.jsp");
	 
    }
}
