package com.example.workshopsystem.dto;

public class WorkshopDto
{
	private long workshopId;
	private String workshopname;
	public WorkshopDto(long workshopId, String workshopname) {
		super();
		this.workshopId = workshopId;
		this.workshopname = workshopname;
	}
	public long getWorkshopId() {
		return workshopId;
	}
	public void setWorkshopId(long workshopId) {
		this.workshopId = workshopId;
	}
	public String getWorkshopname() {
		return workshopname;
	}
	public void setWorkshopname(String workshopname) {
		this.workshopname = workshopname;
	}
	

}
