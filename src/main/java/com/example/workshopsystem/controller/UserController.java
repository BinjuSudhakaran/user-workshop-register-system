package com.example.workshopsystem.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.workshopsystem.dto.UserDto;
import com.example.workshopsystem.dto.WorkshopDto;
import com.example.workshopsystem.model.User;
import com.example.workshopsystem.service.UserService;
import com.example.workshopsystem.service.WorkshopService;


@RestController
@RequestMapping("/api/user")
public class UserController 
{
	@Autowired
	private UserService userService;
	
	@Autowired
	private WorkshopService workshopService;
	
	@GetMapping
	public List<User> viewUser()
	{
		return userService.viewUser();		
	}
	
	@GetMapping("/viewWorkshops")
	public ResponseEntity<?> viewRegistration()
	{
		try
		{
			List<UserDto> dtos = userService.viewRegistration();
			return ResponseEntity.ok(dtos);
		} 
		catch (Exception e) 
		{
			return ResponseEntity.status(404).body(e.getMessage());
		}
	}

	@PutMapping("/attendWorkshop/{workshopId}")
	public ResponseEntity<?> attendworkshop(@PathVariable long workshopId)
	{
		try 
		{
			return userService.attendWorkshop(workshopId);
		
		} 
		catch (Exception e)
		{
		
			return ResponseEntity.status(404).body(e.getMessage());

		}
	}
		
}