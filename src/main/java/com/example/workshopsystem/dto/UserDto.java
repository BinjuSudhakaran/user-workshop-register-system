package com.example.workshopsystem.dto;

public class UserDto
{
	
	private long registrationId;
	private long workshopId;
	private String workName;
	public long getRegistrationId() {
		return registrationId;
	}
	public void setRegistrationId(long registrationId) {
		this.registrationId = registrationId;
	}
	public long getWorkshopId() {
		return workshopId;
	}
	public void setWorkshopId(long workshopId) {
		this.workshopId = workshopId;
	}
	public String getWorkName() {
		return workName;
	}
	public void setWorkName(String workName) {
		this.workName = workName;
	}
	public UserDto(long registrationId, long workshopId, String workName) {
		super();
		this.registrationId = registrationId;
		this.workshopId = workshopId;
		this.workName = workName;
	}
	
}