package com.dao;

import java.util.List;

import com.bean.Message;
import com.bean.PageResult;
import com.bean.User;

public interface MessageDao {
	//������Ϣ
	int saveUser(int from_id, int to_id,String subject, String content, String createtime,int status);
	List<Message> findMessageById(int to_id);
	
	//��ҳ��ѯ  (��ǰҳ��ÿҳ��ʾ��������)
	PageResult findByPage(int currentPage,int pageSize,int to_id);
    //ɾ����Ϣ
	int deleteMessageById(String id);
	//�޸�״̬��
	int updateStatus(String content);
	 //���ݱ����ID
     Message findSubjectById(String subject);
}
