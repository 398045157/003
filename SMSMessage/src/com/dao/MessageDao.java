package com.dao;

import java.util.List;

import com.bean.Message;
import com.bean.PageResult;
import com.bean.User;

public interface MessageDao {
	//保存信息
	int saveUser(int from_id, int to_id,String subject, String content, String createtime,int status);
	List<Message> findMessageById(int to_id);
	
	//分页查询  (当前页，每页显示数据条数)
	PageResult findByPage(int currentPage,int pageSize,int to_id);
    //删除消息
	int deleteMessageById(String id);
	//修改状态码
	int updateStatus(String content);
	 //根据标题查ID
     Message findSubjectById(String subject);
}
