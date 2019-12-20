package com.mindtree.librarymanagementsystem.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class UserDto {

	private int userId;
	private String userName;
	private String userAddress;
	@JsonIgnoreProperties("users")
	private Set<LibraryDto> libraries;

	public UserDto() {
	}

	public UserDto(int userId, String userName, String userAddress, Set<LibraryDto> libraries) {
		this.userId = userId;
		this.userName = userName;
		this.userAddress = userAddress;
		this.libraries = libraries;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public Set<LibraryDto> getLibraries() {
		return libraries;
	}

	public void setLibraries(Set<LibraryDto> libraries) {
		this.libraries = libraries;
	}

	@Override
	public String toString() {
		return "UserDto [userId=" + userId + ", userName=" + userName + ", userAddress=" + userAddress + ", libraries="
				+ libraries + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + userId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDto other = (UserDto) obj;
		if (userId != other.userId)
			return false;
		return true;
	}

}
