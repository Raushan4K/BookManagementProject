package com.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.model.Customer;
import com.customer.model.User;

public interface ICustomer extends JpaRepository<Customer, String> {

	public Customer findByUser(User user);
}
