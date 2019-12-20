package com.mindtree.librarymanagementsystem.service.serviceimpl;

import java.util.HashSet;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.librarymanagementsystem.dto.LibraryDto;
import com.mindtree.librarymanagementsystem.dto.UserDto;
import com.mindtree.librarymanagementsystem.entity.Library;
import com.mindtree.librarymanagementsystem.entity.User;
import com.mindtree.librarymanagementsystem.repository.LibraryRepository;
import com.mindtree.librarymanagementsystem.repository.UserRepository;
import com.mindtree.librarymanagementsystem.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	LibraryRepository libraryRepository;
	@Autowired
	UserRepository userRepository;
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public boolean insertAUserWithLibraries(UserDto userDto) {

		boolean isInserted = false;
		Set<Library> libraries=new HashSet<Library>();
		User user = convertDtoToEntity(userDto);
		
		for (LibraryDto libraryDto : userDto.getLibraries()) {
			Library library=convertDtoToEntity(libraryDto);
			libraryRepository.save(library);
			libraries.add(library);	
		}
		user.setLibraries(libraries);
		userRepository.saveAndFlush(user);
		isInserted = true;

		return isInserted;
	}

	private UserDto convertEntityToDto(User user) {
		return modelMapper.map(user, UserDto.class);
	}

	private User convertDtoToEntity(UserDto user) {
		return modelMapper.map(user, User.class);
	}

	private LibraryDto convertEntityToDto(Library library) {
		return modelMapper.map(library, LibraryDto.class);
	}

	private Library convertDtoToEntity(LibraryDto libraryDto) {
		return modelMapper.map(libraryDto, Library.class);
	}
}
