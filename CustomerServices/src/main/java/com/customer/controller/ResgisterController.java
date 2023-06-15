package com.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.external.CartService;
import com.customer.model.Books;
import com.customer.model.Customer;
import com.customer.model.User;
import com.customer.repository.IUserRepo;
import com.customer.services.ICustomerService;

@RestController
@RequestMapping("/customer")
public class ResgisterController {
	@Autowired
	private ICustomerService cs;
	@Autowired
	private IUserRepo userRepo;
	@Autowired
	private CartService cartServices;

	@GetMapping("/show")
	public List<Customer> showRegister() {
		List<Customer> list = cs.getAllCustomers();

		return list;
	}

	@PostMapping("/register")
	public ResponseEntity<Customer> customerRegistration(@RequestBody Customer customer) {
		User user = customer.getUser();
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		user.setCustomer(customer);

		Customer saveCustomer = cs.saveCustomer(customer);

		return ResponseEntity.status(HttpStatus.CREATED).body(saveCustomer);
	}

	@GetMapping("/addToCart/{bookId}")
	public Books BaddToCart(@PathVariable String bookId) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication(); // User user =
		userRepo.findByUsername(auth.getName());
		Books books = cartServices.addToCart(auth.getName(), bookId);
		System.out.println(books);
		return books;
	}

}
