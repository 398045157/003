package com.dao.imp;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.bean.User;
import com.dao.UserDao;
import com.util.DBCPUtil;

public class UserImp implements UserDao{

	@Override
	public User findUserByUsername(String account) {
		QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());
		String sql = "select * from user where account = ?";
		User user = null;
		try {
			user = qr.query(sql, new BeanHandler<User>(User.class), account);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public int saveUser(String username, String account, String password, String email, String createtime) {
		QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());
		String sql = "insert into user(username,account,password,email,createtime) values (?,?,?,?,?)";
		int num = 0;
		try {
			num = qr.update(sql,username,account,password,email,createtime);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public List<User> findAllUser() {
		QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());
	    String sql = "select username,account from user ";
	    List<User> userList = null;
	    try {
			userList = qr.query(sql, new BeanListHandler<User>(User.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public User findUserById(String account) {
		QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());
		String sql = "select * from user where account = ?";
		User user = null;
		try {
			user = qr.query(sql, new BeanHandler<User>(User.class), account);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User findUsernameById(String username) {
		QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());
		String sql = "select id from user where username = ?";
		User user = null;
		try {
			user = qr.query(sql, new BeanHandler<User>(User.class), username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}



}
