package com.delivery.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CartProducts{
	@Id
	@GeneratedValue
	private int id;
	
	private String userName;
	
	private String restaurant_code;
	
	private String food_name;
	
	private double productPrice;
	
	private int quantity;
	
	private boolean ordered;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRestaurant_code() {
		return restaurant_code;
	}

	public void setRestaurant_code(String restaurant_code) {
		this.restaurant_code = restaurant_code;
	}

	public String getFood_name() {
		return food_name;
	}

	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean isOrdered() {
		return ordered;
	}

	public void setOrdered(boolean ordered) {
		this.ordered = ordered;
	}

	public CartProducts(int id, String userName, String restaurant_code, String food_name, double productPrice,
			int quantity, boolean ordered) {
		super();
		this.id = id;
		this.userName = userName;
		this.restaurant_code = restaurant_code;
		this.food_name = food_name;
		this.productPrice = productPrice;
		this.quantity = quantity;
		this.ordered = ordered;
	}

	public CartProducts() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

	
	
	
}	