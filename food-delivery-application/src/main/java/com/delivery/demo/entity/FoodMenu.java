package com.delivery.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumns;

@Entity
public class FoodMenu {
	
	
	@Id
	private String food_name;
	
	@Column(name = "restaurant_code") 
	private String restaurant_code;
	
	private int price;

	public String getFood_name() {
		return food_name;
	}

	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}

	public String getRestaurant_code() {
		return restaurant_code;
	}

	public void setRestaurant_code(String restaurant_code) {
		this.restaurant_code = restaurant_code;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "FoodMenu [food_name=" + food_name + ", restaurant_code=" + restaurant_code + ", price=" + price + "]";
	}
	
	

	
	
	
	

}
