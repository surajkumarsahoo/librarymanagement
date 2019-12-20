package com.mindtree.librarymanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.librarymanagementsystem.dto.UserDto;
import com.mindtree.librarymanagementsystem.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/insertuserwithlibraries")
	public String insert(@RequestBody UserDto userDto ) {

		
		
		boolean isInserted = false;
		isInserted = userService.insertAUserWithLibraries(userDto);
		return "User with libraries data inserted status: " + isInserted;
		}
	
}
