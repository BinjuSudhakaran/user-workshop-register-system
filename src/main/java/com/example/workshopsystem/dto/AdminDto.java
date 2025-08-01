package com.example.workshopsystem.dto;

public class AdminDto 
{
	long userId;
	String userName;
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
	public AdminDto(long userId, String userName) {
		super();
		this.userId = userId;
		this.userName = userName;
	}
	

}
