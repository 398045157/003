package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.MessageDao;
import com.dao.imp.MessageImp;
@WebServlet("/MessageDelete")
public class MessageDelete extends HttpServlet{
     @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          //  req.setCharacterEncoding("utf-8");
            
            String id = req.getParameter("id");
            System.out.println(id);
            MessageDao messageDao = new MessageImp();
         
            messageDao.deleteMessageById(id);
            String message = "";
            message="ɾ���ɹ�!!";
			req.setAttribute("msg", message);
			req.getRequestDispatcher("main.jsp").forward(req, resp);
			//resp.sendRedirect("main.jsp");
    }
}
