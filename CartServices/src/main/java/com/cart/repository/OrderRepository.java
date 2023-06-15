package com.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cart.model.Order;

public interface OrderRepository extends JpaRepository<Order, String> {
	@Query(value = "delete from Orders where cart_id= ?1", nativeQuery = true)
	public boolean deleteByCart(String bookId);

	@Query(value = "delete from Orders where username= ?1", nativeQuery = true)
	public boolean deleteByUsername(String username);
}
