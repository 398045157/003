package com.dao;

import java.util.List;

import com.bean.User;

public interface UserDao {

	//查询当前用户是否存在   输入用户名  返回用户名对象
	User findUserByUsername(String account);
	//保存用户信息
	int saveUser(String username,String account,String password,String email,String createtime);
	//查询所有用户
	List<User> findAllUser();
    //根据账号查ID
	User findUserById(String account);
    //根据username查ID
	User findUsernameById(String username);
}
