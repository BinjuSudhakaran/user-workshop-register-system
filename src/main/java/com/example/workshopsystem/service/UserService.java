package com.example.workshopsystem.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.workshopsystem.model.User;
import com.example.workshopsystem.model.Workshop;
import com.example.workshopsystem.repository.UserRepository;


@Service
public class UserService
{
	
	@Autowired
	private UserRepository userRepository;

	public User addUser(User user) 
	{
		return userRepository.save(user);
	}

	public List<User> viewUser()
	{
		
		return userRepository.findAll();
	}

	public List<Workshop> viewWorkshops(long userId)
	{
		User user=userRepository.findById(userId).orElseThrow(()->new RuntimeException("User not found"));
		
		return user.getRegistrations().stream().map(r -> r.getWorkshop()).collect(Collectors.toList());
	}

}
