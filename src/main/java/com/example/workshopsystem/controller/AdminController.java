package com.example.workshopsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.workshopsystem.dto.RegistrationDto;
import com.example.workshopsystem.service.AdminService;

@RestController
@RequestMapping("admin/viewAllRegistrations")
public class AdminController
{
	@Autowired
	private AdminService adminService;
	@GetMapping
	public List<RegistrationDto> viewAllRegistrations()
	{
		return adminService.viewAllRegistrations();
		
	}

}
