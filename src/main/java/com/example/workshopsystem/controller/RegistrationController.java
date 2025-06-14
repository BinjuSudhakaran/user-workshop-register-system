package com.example.workshopsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.workshopsystem.model.Registration;
import com.example.workshopsystem.repository.UserRepository;
import com.example.workshopsystem.service.RegistrationService;

@RestController
@RequestMapping("/register")
public class RegistrationController
{
	@Autowired
	private RegistrationService registrationService;
		
	@PostMapping
	public ResponseEntity<Object> registerForWorkshop(@RequestParam long userId,@RequestParam long workshopId)
	{
		
		try
		{
		Registration registration=registrationService.registerForWorkshop(userId,workshopId);
		return ResponseEntity.ok(registration);
		}
		catch (RuntimeException e)
	    {
	        return ResponseEntity.badRequest().body(e.getMessage());
	    } 
		
	}
	

}
