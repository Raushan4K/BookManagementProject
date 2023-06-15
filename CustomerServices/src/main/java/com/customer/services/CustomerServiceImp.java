package com.customer.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.model.Customer;
import com.customer.repository.ICustomer;

@Service
public class CustomerServiceImp implements ICustomerService {

	@Autowired
	ICustomer customerRepo;

	@Override
	public Customer saveCustomer(Customer customer) {

		String cust1 = UUID.randomUUID().toString();
		customer.setCustId(cust1);

		return customerRepo.save(customer);
	}

	@Override

	public List<Customer> getAllCustomers() {

		return customerRepo.findAll();
	}

	@Override
	public Customer getCustomer(String username) {

		Customer customer = customerRepo.findById(username).get();

		return customer;
	}

	@Override
	public String updateCustomer(Customer customer) {

		saveCustomer(customer);

		return "Data Updated Successfully!";
	}

	@Override
	public String removeCustomer(Customer customer) {

		customerRepo.delete(customer);

		return "Customer Data Deleted Successfully!";
	}

}
