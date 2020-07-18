package com.delivery.demo.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.delivery.demo.entity.CartProducts;
import com.delivery.demo.entity.FoodMenu;
import com.delivery.demo.entity.OrderList;
import com.delivery.demo.entity.Restaurants;
import com.delivery.demo.entity.UserAccount;
import com.delivery.demo.model.RestaurantModel;
import com.delivery.demo.service.CartService;
import com.delivery.demo.service.MenuService;
import com.delivery.demo.service.RestaurantService;
import com.delivery.demo.service.UserAccountService;

/**
 * FoodDeliveryController is api to implement the logic to order food
 * 
 * @author Nagendra Babu Puttigampala
 * 
 * @since 2020
 *
 */

@Controller
public class FoodDeliveryController {
	
	@Autowired
	UserAccountService userAccountService;
	
	@Autowired
	RestaurantService restaurantService; 
	
	@Autowired
	MenuService menuService;
	
	@Autowired
	CartService cartService;

	@RequestMapping("/createUser")
	@ResponseBody
	public Boolean createUser(@RequestBody UserAccount user) {
		UserAccount userData = userAccountService.getUserDetails(user.getUsername());
		return Objects.isNull(userData.getUsername()) ?  true : false;
	}
	
	
	@RequestMapping(path = "/login" , produces = {"application/json"})
	@ResponseBody
	public Boolean login(@RequestBody UserAccount user) {
		RestaurantModel restaurantModel = new RestaurantModel();
		UserAccount userData = userAccountService.getUserDetails(user.getUsername());
		return (Objects.nonNull(userData.getUsername()) && userData.getPassword().equals(user.getPassword()))?true:false;
	}
	
	
	@RequestMapping(path = "/getRestaurants" , produces = {"application/json"})
	@ResponseBody
	public RestaurantModel getRestaurants() {
		RestaurantModel restaurantModel = new RestaurantModel();
			List<Restaurants> restaurantList = restaurantService.getAllRestaurants();
			restaurantModel.setRestaurants(restaurantList);
		return restaurantModel;
	}
	
	
	@GetMapping(path = "/openMenu")
	@ResponseBody
	public  List<FoodMenu> openMenu(@RequestBody FoodMenu foodMenu) {
		return menuService.getMenuItems(foodMenu.getRestaurant_code());
	}
	
	
	@PostMapping(path = "/addToCart")
	@ResponseBody
	public  void addToCart(@RequestBody CartProducts cartProduct) {
		cartProduct.setProductPrice(menuService.getPrice(cartProduct));
		cartProduct.setOrdered(false);
		cartService.addToCart(cartProduct);
	}
	
	
	@RequestMapping(path= "/mycart", method=RequestMethod.GET)
	@ResponseBody
	public List<CartProducts> getAllCartProducts(@RequestBody UserAccount userAccount){
		return cartService.getCartByUserName(userAccount.getUsername());
	}
	
	@PostMapping(path= "/placeOrder")
	@ResponseBody
	public void placeOrder(@RequestBody UserAccount userAccount){
		List<CartProducts> cartProductsList =cartService.getCartByUserName(userAccount.getUsername());
		cartProductsList = cartProductsList.stream().map(entity -> {
					entity.setOrdered(true);
					return entity;
				}).collect(Collectors.toList());
		if(!CollectionUtils.isEmpty(cartProductsList)) {
			cartService.placeOrder(cartProductsList);
		}
	}
	
	@GetMapping(path= "/myOrders")
	@ResponseBody
	public List<OrderList> myOrders(@RequestBody UserAccount userAccount){
		return cartService.getMyOrders(userAccount.getUsername());
		
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
	    return new WebMvcConfigurer() {
	        @Override
	        public void addCorsMappings(CorsRegistry registry) {
	            registry.addMapping("/**")
	                    .allowedOrigins("*")
	                    .allowedMethods("GET", "PUT", "POST", "PATCH", "DELETE", "OPTIONS");
	        }
	    };
	}

}
