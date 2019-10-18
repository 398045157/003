package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.bean.Message;
import com.bean.PageResult;
import com.bean.User;
import com.dao.MessageDao;
import com.dao.UserDao;
import com.dao.imp.MessageImp;
import com.dao.imp.UserImp;
@WebServlet("/MainInfo")
public class MainInfo extends HttpServlet{
  @Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      // req.setCharacterEncoding("utf-8");
     //  resp.setContentType("utf-8");
        HttpSession session = req.getSession();
       String username = (String) session.getAttribute("username");
        UserDao userDao = new UserImp();
        User user = userDao.findUsernameById(username);
        int to_id= user.getId();
 		String currentPage = req.getParameter("currentPage");
 		String pageSize = req.getParameter("pageSize");
 		//����dao
 		PageResult pageResult = new MessageImp().findByPage( Integer.parseInt(currentPage), Integer.parseInt(pageSize),to_id);
 		//����json����
 		resp.setCharacterEncoding("utf-8");
 		PrintWriter pw = resp.getWriter();
 		pw.println(JSON.toJSONString(pageResult));
 		pw.flush();
 		pw.close();
           
/*      //���ñ����ʽ
	     req.setCharacterEncoding("utf-8");
	     //���յ�ǰҳ
	     String page = req.getParameter("page");
	     //����ÿҳ��ʾ����������
	     String limit = req.getParameter("limit");

	     //����dao�ӿ�
	     PageResult pg = new MessageImp().findByPage(Integer.parseInt(page), Integer.parseInt(limit));
      pg.setCode("0");
	     pg.setMessage("ִ�гɹ�");
       
	     Map<String, Object> map = new HashMap<String,Object>();
	     map.put("status",0);
	     map.put("code", 0);
	     map.put("message","ִ�гɹ�");
	     map.put("total",pg.getTotalSize());
	     map.put("data",pg.getDataList());
      //����json����
	     resp.setCharacterEncoding("utf-8");
      PrintWriter pw = resp.getWriter();
      pw.println(JSON.toJSON(pg));
      pw.flush();
      pw.close();*/
      


}
}