package com.example.workshopsystem.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
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
	
	
	
	
	
	@Autowired
    private PasswordEncoder passwordEncoder;

    
	public User addUser(User user) {
	    String encodedPassword = passwordEncoder.encode(user.getPassword());
	    User newUser = new User(user.getName(), user.getEmail(), encodedPassword, user.getRole());
	    return userRepository.save(newUser);
	}

	
	

	public List<User> viewUser()
	{
		
		return userRepository.findAll();
	}

	public List<UserDto> viewRegistration(long userId) throws Exception
	{
		User user=userRepository.findById(userId).orElseThrow(()->new RuntimeException("user not found"));
		
		List<Registration> registration=registrationRepository.findByUser(user);
		if(registration.isEmpty())
		{
			throw new RuntimeException("not found");
		}
		
		
		return registration.stream().map(r->new UserDto(r.getRegistraionId(),
				r.getWorkshop().getWorkshopId(),
				r.getWorkshop().getWorkshopName())).collect(Collectors.toList());
	}

	public ResponseEntity<?> attendWorkshop(long workshopId,long userId) throws Exception
	{
		Registration registered=registrationRepository.findByWorkshopWorkshopIdAndUserUserId(workshopId,userId);
		
		if(registered==null)
		{
			throw new RuntimeException("not registered");
		}
		
		registered.setIsattended(true);
		registrationRepository.save(registered);				
		return ResponseEntity.ok("Attendance Marked");

	}




	public List<User> viewAllUsers()
	{
		return userRepository.findAll();
	}

	
}
