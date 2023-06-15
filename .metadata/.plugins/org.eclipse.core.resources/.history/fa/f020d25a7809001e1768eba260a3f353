package com.customer.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.customer.model.Books;

@Service
@FeignClient(name = "CART-SERVICE")
public interface CartService {
	@GetMapping("/cart/addToCart/{username}/bookId/{bookId}")
	public Books addToCart(@PathVariable(name = "username") String username,
			@PathVariable(name = "bookId") String bookId);

}
