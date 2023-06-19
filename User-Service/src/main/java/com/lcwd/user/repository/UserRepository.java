package com.lcwd.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lcwd.user.entities.User;

public interface UserRepository extends JpaRepository<User, String>{

	public User findByUserId(String userId); 
	
	public boolean existsById(String userId);
	
	public Boolean existsByNameIgnoreCase(String name); 
	
}
