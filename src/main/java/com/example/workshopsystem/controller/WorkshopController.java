package com.example.workshopsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.workshopsystem.dto.WorkshopDto;
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
		
		/*@GetMapping("/searchWorkshop")
		public ResponseEntity<?> searchWorkshop(@PathVariable String name)
		{
			try
			{
				List<WorkshopDto> workshop=workshopService.searchWorkshop(name);
				return ResponseEntity.ok(workshop);
				
				
			}
			catch(Exception e)
			{
				return ResponseEntity.status(404).body(e.getMessage());
			}
		}*/

}


