package com.example.workshopsystem.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.workshopsystem.dto.UserDto;
import com.example.workshopsystem.dto.UsersDto;
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

	public List<UsersDto> viewAllUsers()
	{
		List<User> user= userRepository.findAll();
		return user.stream().map(u->new UsersDto(u.getUserId(),u.getName(),u.getEmail(),u.getPassword(),
				u.getRegistrations())).collect(Collectors.toList());
				
		
	}


	private User getLoggedInUser() 
    {
    	
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println(email);
        return userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
    }
	

	public List<UserDto> viewRegistration() 
	{
		User user=getLoggedInUser() ;
		List<Registration> registration=registrationRepository.findByUser(user);
		if(registration.isEmpty())
		{
			throw new RuntimeException("not found");
		}
		
		
		return registration.stream().map(r->new UserDto(r.getRegistraionId(),
				r.getWorkshop().getWorkshopId(),
				r.getWorkshop().getWorkshopName())).collect(Collectors.toList());
	}




	public ResponseEntity<?> attendWorkshop(long workshopId) 
	{
		User user=getLoggedInUser() ;
		long userId=user.getUserId();
		Registration registered=registrationRepository.findByWorkshopWorkshopIdAndUserUserId(workshopId,userId);
		
		if(registered==null)
		{
			throw new RuntimeException("not registered");
		}
		
		registered.setIsattended(true);
		registrationRepository.save(registered);				
		return ResponseEntity.ok("Attendance Marked");
	}
	

	
}
