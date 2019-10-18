package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.MessageDao;
import com.dao.imp.MessageImp;
@WebServlet("/QuitSend")
public class QuitSend extends HttpServlet{
       @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // req.setCharacterEncoding("utf-8");   	   
    	 String content = req.getParameter("content");
    	 System.out.println(content);
    	 MessageDao messageDao = new MessageImp();
    	 messageDao.updateStatus(content);
         HttpSession session = req.getSession();
         
         session.removeAttribute("content");
         resp.sendRedirect("main.jsp");
    }
}
