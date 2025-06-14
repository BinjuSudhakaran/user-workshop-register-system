package com.example.workshopsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.workshopsystem.model.Workshop;
import com.example.workshopsystem.service.WorkshopService;

@RestController
@RequestMapping("/workshop")
public class WorkshopController
{
	
		@Autowired
		private WorkshopService workshopService;
		
		@PostMapping
		public Workshop addWorkshop(@RequestBody Workshop workshop)
		{
			return workshopService.addWorkshop(workshop);
			
		}
		@GetMapping
		public List<Workshop> viewWorkshop()
		{
			return workshopService.viewWorkshop();	
		}	

}


