package com.example.workshopsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.workshopsystem.model.Workshop;
import com.example.workshopsystem.repository.WorkshopRepository;

@Service
public class WorkshopService
{
	@Autowired
	private WorkshopRepository workshopRepository;
	
	public Workshop addWorkshop(Workshop workshop)
	{
	
		return workshopRepository.save(workshop);
	}
	public List<Workshop> viewWorkshop() 
	{
	
		return workshopRepository.findAll();
	}

}
