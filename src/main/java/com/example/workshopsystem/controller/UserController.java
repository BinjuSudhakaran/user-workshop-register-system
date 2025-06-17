package com.example.workshopsystem.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.workshopsystem.dto.UserDto;
import com.example.workshopsystem.model.User;
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
	
	@GetMapping("/viewWorkshops/{userId}")
	public List<UserDto> viewRegistration(@PathVariable Long userId)
	{
		try {
			return userService.viewRegistration(userId);
			
		} 
		catch (Exception e)
		{
			
			e.printStackTrace();
		}
		return null;
	}
	
}