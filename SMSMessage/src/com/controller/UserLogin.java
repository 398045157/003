package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.descriptor.web.LoginConfig;

import com.bean.User;
import com.dao.UserDao;
import com.dao.imp.UserImp;

@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet{
     @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         // req.setCharacterEncoding("utf-8");
          String message = "";
          
          
          //��������
          String account = req.getParameter("account");
          String password = req.getParameter("password");
          String ck = req.getParameter("ck");
          
          
          //��ס����---------------------------------------------
          Cookie cookie = new Cookie("ck", password);
          //���ѡ�˼�ס����
          if (ck != null && ck.equals("yes")) {
			cookie.setMaxAge(60*60*24*7);
		}else {//ûѡ
			cookie.setMaxAge(0);
		}
          //���cookie
          resp.addCookie(cookie);
          resp.setContentType("text/json;charset=utf-8");
          
          
          
          if (account == null || account.equals("") || password == null || password.equals("")) {
			message = "�˺Ż����벻��Ϊ�գ�";
			req.setAttribute("msg", message);
			req.getRequestDispatcher("login.jsp").forward(req, resp);
			return;
		  }
          //����dao�ӿ�   �����ݿ⴫���û���
          UserDao userDao = new UserImp();
          User user = userDao.findUserByUsername(account);
        
          //��֤�Ƿ��½�ɹ�
          if (user == null) {
			message ="��ǰ�û�������";
			req.setAttribute("msg", message);
			req.getRequestDispatcher("login.jsp").forward(req, resp);
			return;
		}else {
			if (!user.getPassword().equals(password)) {
				message = "�������";
				req.setAttribute("msg", message);
				req.getRequestDispatcher("login.jsp").forward(req, resp);
				return;
			}
			//��ȡsession����
			  String aaa = user.getAccount();
			  String bbb = user.getUsername();
			 HttpSession session = req.getSession();
			 //��session������û�����
			 session.setAttribute("currentUser", aaa);
			 session.setAttribute("username", bbb);
		     resp.sendRedirect("main.jsp");
		}
         
          
    }
}
