package com.delivery.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.delivery.demo.entity.FoodMenu;

public interface MenuRespository extends JpaRepository<FoodMenu, String>{
	
	@Query(value = "select * from Food_menu where restaurant_code =?1", nativeQuery = true)
	List<FoodMenu> findByRestaurantCode(String code);

	@Query(value = "select * from Food_menu where restaurant_code =?1 and food_name =?2 ", nativeQuery = true)
	FoodMenu getPrice(String code, String name);
	
}
