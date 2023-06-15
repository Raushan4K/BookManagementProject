
package com.cart.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cart.dto.Books;
import com.cart.dto.Customer;
import com.cart.external.service.OrderService;
import com.cart.model.Cart;
import com.cart.model.Order;
import com.cart.repository.CartRepository;
import com.cart.repository.OrderRepository;

@Service
public class CartServiceImpl implements CartServices {

	@Autowired
	CartRepository cartRepo;
	@Autowired
	OrderService orderService;
	@Autowired
	OrderRepository orderRepo;

	@Override
	public String addItem(Customer customer, Books book) {

		return null;
	}

	@Override
	public List<Cart> getAllItems(Books book) {

		return null;
	}

	@Override
	public Set<Cart> getByUserName(Customer customer) {

		return null;
	}

	@Override
	public String orderPlace(String username) {
		List<Long> bookIds = new ArrayList<>();
		String order2 = null;
		Cart cart;
		try {
			cart = cartRepo.findByUsername(username);
			List<Order> order = cart.getOrder();
			for (Order orde : order) {
				bookIds.add(orde.getId());
			}
			order2 = orderService.placeOrder(username, bookIds);

			try {
				String cartId = cart.getCartId();
				orderRepo.deleteByCart(cartId);
			} catch (Exception e) {
				System.err.println("deleted");
				return order2;
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return order2;
	}

}
