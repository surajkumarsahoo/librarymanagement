package com.mindtree.librarymanagementsystem.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class LibraryDto {

	private int libraryId;
	private String libraryName;
	private String libraryAddress;
	@JsonIgnoreProperties("libraries")
	private Set<UserDto> users;

	public LibraryDto() {
	}

	public LibraryDto(int libraryId, String libraryName, String libraryAddress, Set<UserDto> users) {
		this.libraryId = libraryId;
		this.libraryName = libraryName;
		this.libraryAddress = libraryAddress;
		this.users = users;
	}

	public int getLibraryId() {
		return libraryId;
	}

	public void setLibraryId(int libraryId) {
		this.libraryId = libraryId;
	}

	public String getLibraryName() {
		return libraryName;
	}

	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}

	public String getLibraryAddress() {
		return libraryAddress;
	}

	public void setLibraryAddress(String libraryAddress) {
		this.libraryAddress = libraryAddress;
	}

	public Set<UserDto> getUsers() {
		return users;
	}

	public void setUsers(Set<UserDto> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "LibraryDto [libraryId=" + libraryId + ", libraryName=" + libraryName + ", libraryAddress="
				+ libraryAddress + ", users=" + users + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + libraryId;
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
		LibraryDto other = (LibraryDto) obj;
		if (libraryId != other.libraryId)
			return false;
		return true;
	}

}
