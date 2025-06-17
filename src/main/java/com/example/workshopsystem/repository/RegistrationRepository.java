package com.example.workshopsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.workshopsystem.model.Registration;
import com.example.workshopsystem.model.User;


@Repository
public interface RegistrationRepository extends JpaRepository<Registration,Long>
{

	List<Registration> findByUser(User user);

	

}
