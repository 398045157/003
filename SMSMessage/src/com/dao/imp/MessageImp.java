package com.dao.imp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;

import com.bean.Message;
import com.bean.PageResult;
import com.bean.User;
import com.dao.MessageDao;
import com.util.DBCPUtil;

public class MessageImp implements MessageDao{

	@Override
	public int saveUser(int from_id, int to_id,String subject, String content, String createtime,int status ) {
		QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());
		String sql = "insert into message(from_id ,to_id,subject,content,createtime,status) values (?,?,?,?,?,?)";
		int num = 0;
		try {
			num = qr.update(sql,from_id,to_id,subject,content,createtime,status);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public List<Message> findMessageById(int to_id) {
		QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());
	    String sql = "select content from message where to_id =? ";
	    List<Message> contentList = null;
	    try {
	    	contentList = qr.query(sql, new BeanListHandler<Message>(Message.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return contentList;
	}
	
	@Override
	public PageResult findByPage(int currentPage, int pageSize,int to_id) {
		QueryRunner queryRunner=new QueryRunner(DBCPUtil.getDataSource());
		//计算一共有多少行数据
		String sql1="select count(*) totalSize from message";
		Map<String,Object> map=new HashMap<String,Object>();
			try {
				 map=queryRunner.query(sql1,new MapHandler());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			//获取当前页面数据列表
			String sql2="select * from message where to_id = ?  limit ?,?";   //第一个？起始行号 第二个？：pageSize
			//currentPage 1 0,pageSize 5
			//  2    (current-1)*pageSize
			List<Message> typeList=new ArrayList<Message>();
		        try {
					typeList=queryRunner.query(sql2, new BeanListHandler<Message>(Message.class),to_id,(currentPage-1)*pageSize,pageSize);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
		        PageResult pageResult =new PageResult(currentPage,Integer.parseInt(map.get("totalSize").toString()),pageSize,typeList);
		return pageResult;
	}

	@Override
	public int deleteMessageById(String id) {
		QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());
		String sql = "delete from message where id = ?";
		int num = 0;
		try {
			num = qr.update(sql, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public int updateStatus(String content) {
		QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());
		String sql = "update message set status = 2 where content = ?";
		int num = 0;
		try {
			num = qr.update(sql,content);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public Message findSubjectById(String subject) {
		QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());
		String sql = "select id from message where content = ?";
		Message user = null;
		try {
			user = qr.query(sql, new BeanHandler<Message>(Message.class), subject);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}




}
