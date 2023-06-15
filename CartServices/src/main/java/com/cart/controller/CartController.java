package com.cart.controller;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.aop.AopInvocationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cart.dto.Books;
import com.cart.external.service.BookService;
import com.cart.model.Cart;
import com.cart.model.Order;
import com.cart.repository.CartRepository;
import com.cart.repository.OrderRepository;
import com.cart.services.CartServices;

@RestController
@RequestMapping("/cart")
public class CartController {
	@Autowired
	BookService bookService;
	@Autowired
	CartRepository cartRepo;
	@Autowired
	OrderRepository orderRepo;

	@Autowired
	CartServices cartService;

	@GetMapping("/addToCart/{username}/bookId/{bookId}")
	@Transactional
	public Books addToCart(@PathVariable(name = "username") String username,

			@PathVariable(name = "bookId") Long bookId) {
		Books book = null;
		List<Order> orders;
		Cart cart;
		book = bookService.getBookById(bookId);
		try {
			cart = cartRepo.findByUsername(username);
			Order order = new Order();
			order.setId(bookId);
			order.setAuthor(book.getAuthor());
			order.setTitle(book.getTitle());

			cart.setUsername(username);

			orders = new ArrayList<>();
			// List<Order> order2 = cart.getOrder();
			order.setCart(cart);
			orders.add(order);
			cart.setOrder(orders);

		} catch (Exception e) {
			Order order = new Order();
			order.setId(bookId);
			order.setAuthor(book.getAuthor());
			order.setTitle(book.getTitle());

			cart = new Cart();
			cart.setUsername(username);

			orders = new ArrayList<>();
			// List<Order> order2 = cart.getOrder();
			order.setCart(cart);
			orders.add(order);
			cart.setOrder(orders);

			System.out.println(book);
			e.printStackTrace();
		}
		cartRepo.save(cart);
		System.out.println(book);
		return book;
	}

	/*
	 * @GetMapping("/deleteFromCart/{bookId}") public ResponseEntity<?>
	 * deleteOrderByBookId(@PathVariable("bookId") Long bookId) { boolean
	 * deleteByBookId = false; try { deleteByBookId =
	 * orderRepo.deleteByBookId(bookId); deleteByBookId = true; return
	 * ResponseEntity.status(HttpStatus.OK).body(deleteByBookId); } catch
	 * (AopInvocationException e) { throw new
	 * RuntimeException("No any Order Available In your Cart with This Book Id"); //
	 * e.printStackTrace(); } catch (Exception e) { return
	 * ResponseEntity.status(HttpStatus.OK).body(deleteByBookId); }
	 * 
	 * }
	 */

	@GetMapping("placeOrder/{username}")
	public String placeOrder(@PathVariable String username) {
		System.err.println("Order is placed");
		String orderPlace = cartService.orderPlace(username);
		return orderPlace;

	}

}
