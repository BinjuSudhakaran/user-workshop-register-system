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

import com.example.workshopsystem.model.User;
import com.example.workshopsystem.model.Workshop;
import com.example.workshopsystem.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController 
{
	@Autowired
	private UserService userService;
	
	@PostMapping
	public User addUser(@RequestBody User user)
	{
		return userService.addUser(user);
		
	}
	@GetMapping
	public List<User> viewUser()
	{
		return userService.viewUser();
		
	}
	/*@GetMapping("/viewWorkshops/{userId}")
	public List<Workshop> viewWorkshops(@PathVariable long userId )
	{	
			return userService.viewWorkshops(userId);		
		
	}*/
	
	
	
	@GetMapping("/viewWorkshops/{userId}")
	public ResponseEntity<?> viewWorkshops(@PathVariable long userId) {
	    try {
	        List<Workshop> workshops = userService.viewWorkshops(userId);
	        return ResponseEntity.ok(workshops);
	    } 
	    catch (RuntimeException e)
	    {
	        return ResponseEntity.badRequest().body(e.getMessage());
	    } 
		
	}
	

}