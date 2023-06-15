package com.customer.services;

import java.util.List;

import com.customer.model.Customer;


public interface ICustomerService {


	public List<Customer> getAllCustomers(); // get

	public Customer getCustomer(String username);

	public Customer saveCustomer(Customer Customer);

	public String updateCustomer(Customer Customer);

	public String removeCustomer(Customer Customer);

	



}
