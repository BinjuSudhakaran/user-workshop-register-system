package com.example.workshopsystem.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.workshopsystem.dto.RegistrationDto;
import com.example.workshopsystem.model.Registration;
import com.example.workshopsystem.repository.RegistrationRepository;

@Service
public class AdminService 
{
	@Autowired
	private RegistrationRepository registrationRepository;

	public List<RegistrationDto> viewAllRegistrations() 
	{
		
		List<Registration> registrations = registrationRepository.findAll();
		
		return registrations.stream().map(reg -> new RegistrationDto(reg.getRegistraionId(),
				reg.getUser().getUserId(),
                reg.getUser().getUserName(),
                reg.getWorkshop().getWorkshopId(),
                reg.getWorkshop().getWorkshopName()
               
        )).collect(Collectors.toList());
	}

}
