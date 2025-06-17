package com.example.workshopsystem.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.workshopsystem.dto.UserDto;
import com.example.workshopsystem.model.Registration;
import com.example.workshopsystem.model.User;
import com.example.workshopsystem.repository.RegistrationRepository;
import com.example.workshopsystem.repository.UserRepository;



@Service
public class UserService
{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RegistrationRepository registrationRepository;
	
	public User addUser(User user) 
	{
		return userRepository.save(user);
	}

	public List<User> viewUser()
	{
		
		return userRepository.findAll();
	}

	public List<UserDto> viewRegistration(long userId) throws Exception
	{
		User user=userRepository.findById(userId).orElseThrow(()->new RuntimeException("user not found"));
		
		List<Registration> registration=registrationRepository.findByUser(user);
		
		
		return registration.stream().map(r->new UserDto(r.getRegistraionId(),
				r.getWorkshop().getWorkshopId(),
				r.getWorkshop().getWorkshopName())).collect(Collectors.toList());
	}

	
}
