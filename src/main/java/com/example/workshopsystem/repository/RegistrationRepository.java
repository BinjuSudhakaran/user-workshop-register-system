package com.example.workshopsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.example.workshopsystem.model.Registration;
import com.example.workshopsystem.model.User;


@Repository
public interface RegistrationRepository extends JpaRepository<Registration,Long>
{

	List<Registration> findByUser(User user);

	//boolean existsByWorkshopIdAndUserId(Long workshopId, Long userId);

	//Registration existsByWorkshopWorkshopIdAndUserUserId(Long workshopId, Long userId);
	//boolean existsByworkshopIdAnduserId(long workshopId, long userId);

	Registration findByWorkshopWorkshopIdAndUserUserId(long workshopId, long userId);
	
	
	//@Query("update Registration r set r.isattended=true where r.registrationId=registrationId and r.userId=userId");

	//ResponseEntity<?> markAttendance(long registrationId, long userId);

	

}
