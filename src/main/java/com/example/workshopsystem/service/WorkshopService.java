package com.example.workshopsystem.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.workshopsystem.dto.WorkshopDto;
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
	/*public List<WorkshopDto> searchWorkshop(String name)
	{
		
		return workshopRepository.findByworkshopnameContainingIgnoreCase(name)
				.stream()
				.map(w->(new WorkshopDto(
						w.getWorkshopId(),
						w.getWorkshopname()))).collect(Collectors.toList());
	}*/

}
