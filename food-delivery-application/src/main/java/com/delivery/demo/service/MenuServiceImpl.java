package com.delivery.demo.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delivery.demo.entity.CartProducts;
import com.delivery.demo.entity.FoodMenu;
import com.delivery.demo.repository.MenuRespository;

/**
 * Menuserviceimpl class is implements the menu service
 * @author Nagendra Babu
 *
 */
@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	MenuRespository menuRespository;

	@Override
	public List<FoodMenu> getMenuItems(String code) {
		return menuRespository.findByRestaurantCode(code);
	}

	@Override
	public int getPrice(CartProducts cartProduct) {
		FoodMenu foodMenu = menuRespository.getPrice(cartProduct.getRestaurant_code(), cartProduct.getFood_name());
		return Objects.nonNull(foodMenu)? foodMenu.getPrice() * cartProduct.getQuantity() :0;
	}

}
