package com.customer.dto;

import java.util.List;

import javax.persistence.criteria.Order;

public class Cart {

	private String cartId;

	private List<Order> order;
	private String username;

}
