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
import com.dao.MessageDao;
import com.dao.UserDao;
import com.dao.imp.MessageImp;
import com.dao.imp.UserImp;
@WebServlet("/SendContent")
public class SendContent extends HttpServlet{
   @Override
   protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    // req.setCharacterEncoding("utf-8");
  	    // resp.setContentType("text/json;charset=utf-8");
         UserDao userDao = new UserImp();
  	     MessageDao messageDao = new MessageImp();
  	
       
       String message = "";
       String subject =req.getParameter("subject");
       String content =req.getParameter("content");
       //�������˺�
       String js =req.getParameter("select");     
       //�������˺�
       String fs =req.getParameter("fj");
       
       
       
	   SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
	   String createtime=sdf.format(new Date());
       //������ID
       User fromId =userDao.findUserById(fs);
       //������ID
       User toId = userDao.findUserById(js);
       //��Ϣ״̬
       int status = 1;
       //������
       int from_id = fromId.getId();
       //������
       int to_id = toId.getId();
		  if (subject!=null && !subject.equals("")&& content != null && !content.equals("")) {

			  int size = messageDao.saveUser(from_id, to_id, subject, content, createtime,status);
  	      if (size<=0) {
	        	message="����ʧ��!";
				req.setAttribute("msg", message);
				req.getRequestDispatcher("send.jsp").forward(req, resp);
		}else {
			message = "����ɹ�";
			resp.sendRedirect("main.jsp");
			return;
		}
   }	else if (subject == null || subject.equals("")) {
			String bt = "�ޱ���";
			subject=bt;
		}else if (content == null || content.equals("")) {
			message="�����뷢�����ݣ�!";
			req.setAttribute("msg", message);
			req.getRequestDispatcher("send.jsp").forward(req, resp);
		}
		  
		  
		  
		  
}
}
