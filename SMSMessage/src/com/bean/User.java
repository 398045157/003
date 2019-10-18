package com.bean;

public class User {
	private int   id; 
	private String username;      
	private String account;       
	private String password;      
	private String email;            
	private int status;         
	private String createtime;      
	private String last_login_time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getLast_login_time() {
		return last_login_time;
	}
	public void setLast_login_time(String last_login_time) {
		this.last_login_time = last_login_time;
	}
	public User() {

	}
	public User(int id, String username, String account, String password, String email, int status, String createtime,
			String last_login_time) {
		super();
		this.id = id;
		this.username = username;
		this.account = account;
		this.password = password;
		this.email = email;
		this.status = status;
		this.createtime = createtime;
		this.last_login_time = last_login_time;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", account=" + account + ", password=" + password
				+ ", email=" + email + ", status=" + status + ", createtime=" + createtime + ", last_login_time="
				+ last_login_time + "]";
	} 
	
	
}
