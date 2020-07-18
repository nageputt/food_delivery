package com.delivery.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.delivery.demo.entity.CartProducts;
import com.delivery.demo.entity.OrderList;


public interface CartRepository extends JpaRepository<CartProducts, String>{

	List<CartProducts> findCartProductsByUserName(String username);

	@Query(value = "select cart.food_name, cart.quantity, cart.product_price, restaurant.RESTAURANT_NAME from CART_PRODUCTS  as cart\r\n" + 
			"	JOIN  RESTAURANTS as restaurant on restaurant.RESTAURANT_CODE = cart.RESTAURANT_CODE where ordered = true and user_name =?1  ", nativeQuery = true)
	List<OrderList> getMyOrders(String username);
	
}
