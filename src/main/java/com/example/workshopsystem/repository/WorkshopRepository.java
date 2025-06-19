package com.example.workshopsystem.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.workshopsystem.dto.WorkshopDto;
import com.example.workshopsystem.model.Workshop;
@Repository
public interface WorkshopRepository extends JpaRepository<Workshop,Long>
{

	//List<WorkshopDto> findByworkshopnameContainingIgnoreCase(String name);

}
