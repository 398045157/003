package com.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.bean.Message;
import com.bean.User;
import com.dao.MessageDao;
import com.dao.UserDao;
import com.dao.imp.MessageImp;
import com.dao.imp.UserImp;
@WebServlet("/SendInfo")
public class SendInfo extends HttpServlet{
         @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        	// req.setCharacterEncoding("utf-8");
        	// resp.setContentType("text/json;charset=utf-8");
             UserDao userDao = new UserImp();
        	 //MessageDao messageDao = new MessageImp();
        	  List<User> list = userDao.findAllUser();
	          resp.getWriter().append(JSON.toJSONString(list));	
             
            /* String message = "";
             String subject =req.getParameter("subject");
             String content =req.getParameter("content");
             //接收人账号
             String js =req.getParameter("select");     
             //发送人账号
             String fs = req.getParameter("fj");
     		 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
			 String createtime=sdf.format(new Date());

             User fromId =userDao.findUserById(fs);
             User toId = userDao.findUserById(js);
             int a1 = fromId.getId();
             int a2 = toId.getId();
			  if (subject!=null && !subject.equals("")&& content != null && !content.equals("")) {

				  int size = messageDao.saveUser(a1, a2, subject, content, createtime);
        	 if (size<=0) {
		        	message="发送失败!";
					req.setAttribute("msg", message);
					req.getRequestDispatcher("send.jsp").forward(req, resp);
			}else {
				message = "保存成功";
				resp.sendRedirect("main.jsp");
				return;
			}
         }	else if (subject == null || subject.equals("")) {
				String bt = "无标题";
				subject=bt;
			}else if (content == null || content.equals("")) {
				message="请输入发送内容！!";
				req.setAttribute("msg", message);
				req.getRequestDispatcher("send.jsp").forward(req, resp);
			}*/
			    
			  
			   
			
     
            
             
        }
}
