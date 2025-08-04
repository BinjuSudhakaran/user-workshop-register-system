package com.example.workshopsystem.dto;

import java.util.List;

import com.example.workshopsystem.model.Registration;

public class UsersDto
{
	private long userId;
	private String name;
	private String email;
	private String password;
	private List<Registration> registrationId;
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<Registration> getRegistrationId() {
		return registrationId;
	}
	public void setRegistrationId(List<Registration> registrationId) {
		this.registrationId = registrationId;
	}
	public UsersDto(long userId, String name, String email, String password, List<Registration> registrationId) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.registrationId = registrationId;
	}
	
	

}
