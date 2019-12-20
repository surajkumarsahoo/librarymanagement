package com.mindtree.librarymanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.librarymanagementsystem.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
