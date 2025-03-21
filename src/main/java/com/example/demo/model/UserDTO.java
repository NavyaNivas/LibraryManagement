package com.example.demo.model;

public class UserDTO {
	
	private long userId;
	private String userName;
	private String emailId;
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public UserDTO(long userId, String userName, String emailId) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.emailId = emailId;
	}
	

}
