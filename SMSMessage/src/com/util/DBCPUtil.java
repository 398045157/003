package com.util;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;



public class DBCPUtil {
	//�������ݿ����Ӷ���
	private static BasicDataSource dataSource = new BasicDataSource();
	//��̬�����
	static {
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/sms?characterEncoding=utf-8&&useSSL=true");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
	}
	//��ȡ���ݿ����Ӷ���
	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	//�����Ҫ�������ӳ�
	public static BasicDataSource getDataSource(){
		return dataSource;
	}
	
	
}
