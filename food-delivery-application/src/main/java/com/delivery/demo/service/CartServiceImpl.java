package com.delivery.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delivery.demo.entity.CartProducts;
import com.delivery.demo.entity.OrderList;
import com.delivery.demo.repository.CartRepository;

/**
 * cartServiceImpl to implementation of cartService class
 * @author Nagendra Babu
 *
 */
@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	CartRepository cartRepository;

	@Override
	public List<CartProducts> getCartByUserName(String username) {
		return cartRepository.findCartProductsByUserName(username);
	}

	@Override
	public List<OrderList> getMyOrders(String username) {
		return cartRepository.getMyOrders(username);
	}

	@Override
	public void addToCart(CartProducts cartProduct) {
		cartRepository.save(cartProduct);
	}

	@Override
	public void placeOrder(List<CartProducts> cartProductsList) {
		cartRepository.saveAll(cartProductsList);
		
	}

}
