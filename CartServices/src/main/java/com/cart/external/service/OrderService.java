package com.cart.external.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ORDERED-SERVICE")
public interface OrderService {
	@PostMapping("/order/placeOrder/{username}")
	public String placeOrder(@PathVariable String username, @RequestBody List<Long> bookIds);
}
