package com.order.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.order.service.OrderedItemService;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/order")
public class RestController {
	@Autowired
	OrderedItemService orderService;

	@PostMapping("/placeOrder/{username}")
	public String placeOrder(@PathVariable String username, @RequestBody List<Long> bookIds) {
		System.out.println(bookIds + "username" + username);
		String placeOrder = orderService.placeOrder(username, bookIds);
		return placeOrder;
	}

}
