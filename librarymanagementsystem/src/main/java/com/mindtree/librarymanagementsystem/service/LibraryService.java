package com.mindtree.librarymanagementsystem.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.mindtree.librarymanagementsystem.dto.LibraryDto;
import com.mindtree.librarymanagementsystem.entity.Library;

@Service
public interface LibraryService {

	/**
	 * @param library
	 * @return
	 */
	boolean insertALibraryWithUsers(LibraryDto library);

	/**
	 * @return
	 */
	Set<LibraryDto> getAllDetails();

	
}
