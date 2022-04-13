package com.yohan.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yohan.api.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	
	User findByEmail(String email);
}
