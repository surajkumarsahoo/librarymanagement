package com.mindtree.librarymanagementsystem.service;

import org.springframework.stereotype.Service;

import com.mindtree.librarymanagementsystem.dto.UserDto;

@Service
public interface UserService {

	/**
	 * @param user
	 * @return
	 */
	boolean insertAUserWithLibraries(UserDto user);

}
