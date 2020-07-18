package com.delivery.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.delivery.demo.entity.Restaurants;

public interface RestaurantRepository extends JpaRepository<Restaurants, String> {

}
