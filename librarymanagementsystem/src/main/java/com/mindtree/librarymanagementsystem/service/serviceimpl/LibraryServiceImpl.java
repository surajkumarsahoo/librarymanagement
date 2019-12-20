package com.mindtree.librarymanagementsystem.service.serviceimpl;

import java.util.HashSet;
import java.util.List;
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
import com.mindtree.librarymanagementsystem.service.LibraryService;

@Service
public class LibraryServiceImpl implements LibraryService {

	@Autowired
	LibraryRepository libraryRepository;
	@Autowired
	UserRepository userRepository;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public boolean insertALibraryWithUsers(LibraryDto libraryDto) {

		boolean isInserted = false;
		Set<User> users = new HashSet<User>();
		Library library = convertDtoToEntity(libraryDto);
		for (UserDto userDto : libraryDto.getUsers()) {

			User user = convertDtoToEntity(userDto);
			userRepository.saveAndFlush(user);
			users.add(user);

		}
		library.setUsers(users);
		libraryRepository.saveAndFlush(library);
		isInserted = true;

		return isInserted;
	}

	@Override
	public Set<LibraryDto> getAllDetails() {

		Set<LibraryDto> libraryDtos = new HashSet<LibraryDto>();
		List<Library> libraries = libraryRepository.findAll();
		for (Library library : libraries) {
			LibraryDto libraryDto = convertEntityToDto(library);
			libraryDtos.add(libraryDto);
		}
		return libraryDtos;
	}

	private LibraryDto convertEntityToDto(Library library) {
		return modelMapper.map(library, LibraryDto.class);
	}

	private Library convertDtoToEntity(LibraryDto libraryDto) {
		return modelMapper.map(libraryDto, Library.class);
	}

	private UserDto convertEntityToDto(User user) {
		return modelMapper.map(user, UserDto.class);
	}

	private User convertDtoToEntity(UserDto user) {
		return modelMapper.map(user, User.class);
	}

}
