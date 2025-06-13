package com.example.workshopsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.workshopsystem.model.Registration;
import com.example.workshopsystem.model.User;
import com.example.workshopsystem.model.Workshop;
import com.example.workshopsystem.repository.RegistrationRepository;
import com.example.workshopsystem.repository.UserRepository;
import com.example.workshopsystem.repository.WorkshopRepository;
@Service
public class RegistrationService 
{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private WorkshopRepository workshopRepository;
	
	@Autowired
	private RegistrationRepository registrationRepository;
	

	public Registration registerForWorkshop(long userId, long workshopId) throws RuntimeException
	{
		User user=userRepository.findById(userId).orElseThrow(()->new RuntimeException("user not found"));
		
		Workshop workshop=workshopRepository.findById(workshopId).orElseThrow(()->new RuntimeException("worksop not found"));
		
		Registration registration=new Registration();
		registration.setWorkshop(workshop);
		registration.setUser(user);
		
		return registrationRepository.save(registration);
	}

}
