package com.example.workshopsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.workshopsystem.model.AuthRequest;
import com.example.workshopsystem.model.User;
import com.example.workshopsystem.service.CustomUserDetailService;
import com.example.workshopsystem.service.UserService;
import com.example.workshopsystem.util.JWTUtil;

@RestController
@RequestMapping("/api/auth")
public class AuthController 
{
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	private JWTUtil jwtUtil;
	
	@Autowired
	UserService userService;
	
	@Autowired
	CustomUserDetailService customUserDetailService;
	
	/*@PostMapping("/register")
	public User addUser(@RequestBody User user)
	{
		return userService.addUser(user);
		
	}*/
	
	@PostMapping("/login")
	public ResponseEntity<?> generateToken(@RequestBody AuthRequest authRequest) 
	{
		try
		{
			Authentication auth=authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(),authRequest.getPassword()));
				
			Object principal = auth.getPrincipal();
           
            User user = (User) principal;
            String token = jwtUtil.generateToken(user.getUserId());
            
            return ResponseEntity.ok(token);
		}
		
		catch (BadCredentialsException e) 
		{
            return ResponseEntity.badRequest().body("email or password is incorrect");
        }
		
	}

}
