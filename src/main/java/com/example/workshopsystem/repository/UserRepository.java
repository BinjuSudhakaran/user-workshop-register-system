package com.example.workshopsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.workshopsystem.model.User;
@Repository
public interface UserRepository extends JpaRepository<User,Long>
{

}
