package com.customer.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.customer.model.User;
import com.customer.repository.IUserRepo;

public class UserServiceImp implements UserService {

	@Autowired
	private IUserRepo userRepo;

	@Override
	public List<User> getAllUser() {

		List<User> users = new ArrayList<User>();
		users.addAll(userRepo.findAll());

		return users;
	}

	@Override
	public User getUser(String username) {
	
		return null;
	}

}
