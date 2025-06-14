package com.example.workshopsystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;

//import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="registration")
public class Registration 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long registraionId;
	
	
	@ManyToOne
    @JoinColumn(name = "user_id")
	
	@JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "workshop_id")
   
    @JsonIgnore
    private Workshop workshop;

	public long getRegistraionId() {
		return registraionId;
	}

	public void setRegistraionId(long registraionId) {
		this.registraionId = registraionId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Workshop getWorkshop() {
		return workshop;
	}

	public void setWorkshop(Workshop workshop) {
		this.workshop = workshop;
	}


}
