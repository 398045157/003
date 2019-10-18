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
          
          
          //接收数据
          String account = req.getParameter("account");
          String password = req.getParameter("password");
          String ck = req.getParameter("ck");
          
          
          //记住密码---------------------------------------------
          Cookie cookie = new Cookie("ck", password);
          //如果选了记住密码
          if (ck != null && ck.equals("yes")) {
			cookie.setMaxAge(60*60*24*7);
		}else {//没选
			cookie.setMaxAge(0);
		}
          //添加cookie
          resp.addCookie(cookie);
          resp.setContentType("text/json;charset=utf-8");
          
          
          
          if (account == null || account.equals("") || password == null || password.equals("")) {
			message = "账号或密码不能为空！";
			req.setAttribute("msg", message);
			req.getRequestDispatcher("login.jsp").forward(req, resp);
			return;
		  }
          //调用dao接口   向数据库传入用户名
          UserDao userDao = new UserImp();
          User user = userDao.findUserByUsername(account);
        
          //验证是否登陆成功
          if (user == null) {
			message ="当前用户不存在";
			req.setAttribute("msg", message);
			req.getRequestDispatcher("login.jsp").forward(req, resp);
			return;
		}else {
			if (!user.getPassword().equals(password)) {
				message = "密码错误！";
				req.setAttribute("msg", message);
				req.getRequestDispatcher("login.jsp").forward(req, resp);
				return;
			}
			//获取session对象
			  String aaa = user.getAccount();
			  String bbb = user.getUsername();
			 HttpSession session = req.getSession();
			 //向session中添加用户对象
			 session.setAttribute("currentUser", aaa);
			 session.setAttribute("username", bbb);
		     resp.sendRedirect("main.jsp");
		}
         
          
    }
}
