package com.mindtree.librarymanagementsystem.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.librarymanagementsystem.dto.LibraryDto;
import com.mindtree.librarymanagementsystem.entity.Library;
import com.mindtree.librarymanagementsystem.service.LibraryService;

@RestController
public class LibraryController {

	@Autowired
	private LibraryService libraryservice;
	
	
	@PostMapping("/insertlibrarywithusers")
	public String insert(@RequestBody LibraryDto libraryDto) {

		boolean isInserted = false;
		isInserted = libraryservice.insertALibraryWithUsers(libraryDto);
		return "library with users data inserted status: " + isInserted;
	}
	@GetMapping("/getAll")
	public Set<LibraryDto> getAllLibrariesWithUsers()
	{
		Set<LibraryDto> libraries=libraryservice.getAllDetails();
		return libraries;
		
	}
	
}
