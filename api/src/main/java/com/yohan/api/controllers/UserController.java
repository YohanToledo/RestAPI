package com.yohan.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yohan.api.dto.UserDTO;
import com.yohan.api.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public Page<UserDTO> findAll(Pageable pageable){
		return service.findAll(pageable);
	}
	
	@PutMapping(value = "/save")
	public UserDTO saveUser(@RequestBody UserDTO userDto) {
		service.saveUser(userDto);
		return userDto;	
	}
	
	
}
