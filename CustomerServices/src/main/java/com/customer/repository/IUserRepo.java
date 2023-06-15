package com.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.customer.model.User;

public interface IUserRepo extends JpaRepository<User, String> {
	@Query("SELECT u FROM User u WHERE u.username = ?1")
	public User findByUsername(String username);
}
