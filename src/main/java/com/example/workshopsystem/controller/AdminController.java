package com.example.workshopsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.workshopsystem.dto.AdminDto;
import com.example.workshopsystem.dto.RegistrationDto;
import com.example.workshopsystem.dto.UserDto;
import com.example.workshopsystem.model.User;
import com.example.workshopsystem.service.AdminService;
import com.example.workshopsystem.service.UserService;

@RestController
@RequestMapping("/api/admin")
public class AdminController
{
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private UserService userService;
	
	
	
	@PostMapping("/registerUser")
	public User addUser(@RequestBody User user)
	{
		return userService.addUser(user);
		
	}
	@GetMapping("/viewUsers")
	public List<User> viewAllUserss()
	{
		return userService.viewAllUsers();
		
	}
	
	
	@GetMapping("/viewRegistration")
	public List<RegistrationDto> viewAllRegistrations()
	{
		return adminService.viewAllRegistrations();
		
	}
	@GetMapping("/viewUsers/{workshopId}")
	public List<AdminDto> viewUsers(@PathVariable long workshopId)
	{
		return adminService.viewUsers(workshopId);
	}

}
