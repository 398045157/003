package com.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.User;
import com.dao.UserDao;
import com.dao.imp.UserImp;
@WebServlet("/UserRegister")
public class UserRegister extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         // req.setCharacterEncoding("utf-8");
          String message = "";
          //��ȡ�û���Ϣ
          String username = req.getParameter("username");
          String account = req.getParameter("account");
          String password = req.getParameter("password");
          String password2 = req.getParameter("password2");
          String email = req.getParameter("email");
       
          SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
   	      String createtime=sdf.format(new Date());
   	      
          //��֤�û����������Ƿ�Ϊ��
          if (account != null && !account.equals("") && password != null && !password.equals("")) {
			UserDao userDao = new UserImp();
			User user = userDao.findUserByUsername(account);
			
			if (user == null) {
				int size = userDao.saveUser(username, account, password, email,createtime);
			    if (size<=0) {
					message="ע��ʧ��";
					req.setAttribute("msg", message);
					req.getRequestDispatcher("register.jsp").forward(req, resp);
					 
				}if (!password.equals(password2)) {
					message="�����������벻һ�£�";
					req.setAttribute("msg", message);
					req.getRequestDispatcher("register.jsp").forward(req, resp);
					
				}else {
					message = "����ɹ�";
					resp.sendRedirect("login.jsp");
				}
			   
			}else {
				message ="�˺��Ѵ��ڣ�";
				req.setAttribute("msg", message);
				req.getRequestDispatcher("register.jsp").forward(req, resp);
				
			}
		}else {//������п�ֵ 
			message = "�û�����������Ϊ��";
			req.setAttribute("msg", message);
			req.getRequestDispatcher("register.jsp").forward(req, resp);
		}
    }
}
