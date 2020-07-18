package com.delivery.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delivery.demo.entity.Restaurants;
import com.delivery.demo.repository.RestaurantRepository;

/**
 * RestaurantServiceImpl class is implementation of RestaurantService
 * @author Lenovo
 *
 */
@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	RestaurantRepository restaurantRepository;
	
	@Override
	public List<Restaurants> getAllRestaurants() {
		return restaurantRepository.findAll();
	}

}
