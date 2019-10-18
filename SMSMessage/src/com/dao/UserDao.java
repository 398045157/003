package com.dao;

import java.util.List;

import com.bean.User;

public interface UserDao {

	//��ѯ��ǰ�û��Ƿ����   �����û���  �����û�������
	User findUserByUsername(String account);
	//�����û���Ϣ
	int saveUser(String username,String account,String password,String email,String createtime);
	//��ѯ�����û�
	List<User> findAllUser();
    //�����˺Ų�ID
	User findUserById(String account);
    //����username��ID
	User findUsernameById(String username);
}
