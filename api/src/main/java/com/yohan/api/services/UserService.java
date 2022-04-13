package com.yohan.api.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.yohan.api.dto.UserDTO;
import com.yohan.api.entities.User;
import com.yohan.api.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	@Transactional
	public Page<UserDTO> findAll(Pageable pageable) {
		Page<User> result = repo.findAll(pageable);
		Page<UserDTO> page = result.map( user -> new UserDTO(user));
		return page;
	}
	
	@Transactional
	public void saveUser(UserDTO userDto) {
		
		User user = repo.findByEmail(userDto.getEmail());
		
		if(user == null) {
			user = new User();
			user.setEmail(userDto.getEmail());
			user.setName(userDto.getName());
			repo.saveAndFlush(user);
		}
		
	}
	
}
