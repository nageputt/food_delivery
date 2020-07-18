package com.delivery.demo.service;

import java.util.List;

import com.delivery.demo.entity.CartProducts;
import com.delivery.demo.entity.FoodMenu;

/**
 * Menuservice class is to implement the logic of menu
 * @author Nagendra Babu
 *
 */
public interface MenuService {

	/**
	 * getMenuItems method is used to get food menu based on restaurant code
	 * @param code
	 * @return list
	 */
	List<FoodMenu> getMenuItems(String code);

	/**
	 * getPrice method is to get the price for the cart item
	 * @param cartProduct
	 * @return
	 */
	int getPrice(CartProducts cartProduct);

}
