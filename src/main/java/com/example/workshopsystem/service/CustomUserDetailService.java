package com.example.workshopsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.workshopsystem.model.User;
import com.example.workshopsystem.repository.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService
{
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) 
	{
		System.out.println(email);
		
	
		return userRepository.findByEmail(email).orElseThrow(()->new UsernameNotFoundException("Username Not Found"));
		
		
	}

	public User loadUserById(Long userId) {
		// TODO Auto-generated method stub
		return userRepository.findUserByUserId(userId);
	}
	
	

}