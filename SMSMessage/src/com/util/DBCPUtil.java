package com.util;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;



public class DBCPUtil {
	//创建数据库连接对象
	private static BasicDataSource dataSource = new BasicDataSource();
	//静态代码块
	static {
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/sms?characterEncoding=utf-8&&useSSL=true");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
	}
	//获取数据库连接对象
	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	//外界需要访问连接池
	public static BasicDataSource getDataSource(){
		return dataSource;
	}
	
	
}
