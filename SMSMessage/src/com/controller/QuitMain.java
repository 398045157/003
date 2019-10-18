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
@WebServlet("/QuitMain")
public class QuitMain extends HttpServlet{
  @Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 	 String usernmae = req.getParameter("username");

 	
      HttpSession session = req.getSession();     
      session.removeAttribute("username");
      resp.sendRedirect("login.jsp");
}
}
