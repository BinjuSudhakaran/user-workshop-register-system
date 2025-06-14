package com.example.workshopsystem.dto;

public class RegistrationDto
{
	private long registrationId;
	
	private long userId;
	private String userName;
	
	private long workshopId;
	private String workshopName;
	
	public RegistrationDto(long registrationId, long userId, String userName, long workshopId, String workshopName) {
		super();
		this.registrationId = registrationId;
		this.userId = userId;
		this.userName = userName;
		this.workshopId = workshopId;
		this.workshopName = workshopName;
	}
	public long getRegistrationId() {
		return registrationId;
	}
	public void setRegistrationId(long registrationId) {
		this.registrationId = registrationId;
	}
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
	public long getWorkshopId() {
		return workshopId;
	}
	public void setWorkshopId(long workshopId) {
		this.workshopId = workshopId;
	}
	public String getWorkshopName() {
		return workshopName;
	}
	public void setWorkshopName(String workshopName) {
		this.workshopName = workshopName;
	}

}
