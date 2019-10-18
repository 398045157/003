package com.bean;

public class Message {
	private int id;         
	private int  from_id;    
	private int  to_id;     
	private String subject;   
	private String content;   
	private String createtime; 
	private int  status;    
	private String attachment;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFrom_id() {
		return from_id;
	}
	public void setFrom_id(int from_id) {
		this.from_id = from_id;
	}
	public int getTo_id() {
		return to_id;
	}
	public void setTo_id(int to_id) {
		this.to_id = to_id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getAttachment() {
		return attachment;
	}
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	public Message() {

	}
	public Message(int id, int from_id, int to_id, String subject, String content, String createtime, int status,
			String attachment) {
		super();
		this.id = id;
		this.from_id = from_id;
		this.to_id = to_id;
		this.subject = subject;
		this.content = content;
		this.createtime = createtime;
		this.status = status;
		this.attachment = attachment;
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", from_id=" + from_id + ", to_id=" + to_id + ", subject=" + subject + ", content="
				+ content + ", createtime=" + createtime + ", status=" + status + ", attachment=" + attachment + "]";
	}

}
