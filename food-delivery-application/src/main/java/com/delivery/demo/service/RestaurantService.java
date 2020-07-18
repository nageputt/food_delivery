package com.delivery.demo.service;

import java.util.List;

import com.delivery.demo.entity.Restaurants;

/**
 * RestaurantService is to implement the logics of restaurant
 * @author Lenovo
 *
 */
public interface RestaurantService {

	/**
	 * getAllRestaurants methd is get all the Restaurants
	 * @return list
	 */
	List<Restaurants> getAllRestaurants();

}
