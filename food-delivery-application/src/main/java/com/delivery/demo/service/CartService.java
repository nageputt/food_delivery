package com.delivery.demo.service;

import java.util.List;

import com.delivery.demo.entity.CartProducts;
import com.delivery.demo.entity.OrderList;


/**
 * cart service is to implement the cart logic
 * @author Nagendra babu Puttigampala
 *
 */
public interface CartService {
	
	/**
	 * getCartByUserName method is to get item based on user
	 * @param username
	 * @return list
	 */
	public List<CartProducts> getCartByUserName(String username);

	/**
	 * getMyOrders method is to get order related to user
	 * @param username
	 * @return list
	 */
	public List<OrderList> getMyOrders(String username);

	/**
	 * addToCart method is to add food items to the Cart
	 * @param cartProduct
	 */
	public void addToCart(CartProducts cartProduct);

	public void placeOrder(List<CartProducts> cartProductsList);

}
