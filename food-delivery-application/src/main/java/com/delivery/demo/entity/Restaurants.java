package com.delivery.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Restaurants {
	
	@Id
	private String restaurant_code;

	private String restaurant_name;
	
	private int restaurant_rating;
	
	private String mobile_number;
	
	private String restaurant_address;
	
	private String image;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getRestaurant_code() {
		return restaurant_code;
	}

	public void setRestaurant_code(String restaurant_code) {
		this.restaurant_code = restaurant_code;
	}

	public String getRestaurant_name() {
		return restaurant_name;
	}

	public void setRestaurant_name(String restaurant_name) {
		this.restaurant_name = restaurant_name;
	}

	public int getRestaurant_rating() {
		return restaurant_rating;
	}

	public void setRestaurant_rating(int restaurant_rating) {
		this.restaurant_rating = restaurant_rating;
	}

	public String getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}

	public String getRestaurant_address() {
		return restaurant_address;
	}

	public void setRestaurant_address(String restaurant_address) {
		this.restaurant_address = restaurant_address;
	}

	@Override
	public String toString() {
		return "Restaurants [restaurant_code=" + restaurant_code + ", restaurant_name=" + restaurant_name
				+ ", restaurant_rating=" + restaurant_rating + ", mobile_number=" + mobile_number
				+ ", restaurant_address=" + restaurant_address + "]";
	}

	
	

}
