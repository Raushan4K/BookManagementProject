package com.cart.external.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cart.dto.Books;

@FeignClient(name = "BOOK-SERVICE")
public interface BookService {
	@GetMapping("/book/getBookById/{bookId}")
	public Books getBookById(@PathVariable(name = "bookId") Long bookId);
	
	


}
