package com.example.workshopsystem.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="workshop")
public class Workshop 
{
	@Id
	private long workshopId;
	private String workshopName;
	
	@OneToMany(mappedBy = "workshop",cascade=CascadeType.ALL)
	private List<Registration> registrations;
	
	public List<Registration> getRegistrations() {
		return registrations;
	}
	public void setRegistrations(List<Registration> registrations) {
		this.registrations = registrations;
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
