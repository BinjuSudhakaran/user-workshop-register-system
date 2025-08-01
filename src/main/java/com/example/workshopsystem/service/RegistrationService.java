package com.example.workshopsystem.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
	
	
	private User getLoggedInUser() 
    {
    	
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println(email);
        return userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
    }
	
	
	public Registration registerForWorkshop(long workshopId) throws RuntimeException
	{
		
		
		User user=getLoggedInUser() ;
		Workshop workshop=workshopRepository.findById(workshopId).orElseThrow(()->new RuntimeException("worksop not found"));
		
		List<Registration> existingRegistrations = registrationRepository.findByUser(user);

	        if (existingRegistrations.size() >= 5) 
	        	
	        {
	            throw new RuntimeException("A user can only register for 5 workshops.");
	        }

	        boolean alreadyRegistered = existingRegistrations.stream().anyMatch(r -> r.getWorkshop().getWorkshopId() == workshopId);
	       
	        if (alreadyRegistered)
	        {
	            throw new RuntimeException("User is already registered for this workshop.");
	        }

		Registration registration=new Registration();
		registration.setWorkshop(workshop);
		registration.setUser(user);
		
		return registrationRepository.save(registration);
	}
	
	
	
	public void deleteRegistration(long registrationId)
	{
		User user=getLoggedInUser() ;
		
	    Registration registration = registrationRepository.findById(registrationId)
	        .orElseThrow(() -> new RuntimeException("Registration not found with ID: " + registrationId));
	    
	    if(user.getUserId()==registration.getUser().getUserId())
	    {
	    	registrationRepository.delete(registration);
		}
	    else
	    {
	    	throw new RuntimeException("Not Authorized");
	    }
	}
	    
	    


}
