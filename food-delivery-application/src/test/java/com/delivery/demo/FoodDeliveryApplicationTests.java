package com.delivery.demo;

import static org.hamcrest.CoreMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.anything;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.delivery.demo.entity.CartProducts;
import com.delivery.demo.entity.FoodMenu;
import com.delivery.demo.entity.Restaurants;
import com.delivery.demo.entity.UserAccount;
import com.delivery.demo.repository.CartRepository;
import com.delivery.demo.repository.MenuRespository;
import com.delivery.demo.repository.RestaurantRepository;
import com.delivery.demo.repository.UserRespository;
import com.delivery.demo.service.CartServiceImpl;
import com.delivery.demo.service.MenuService;
import com.delivery.demo.service.RestaurantService;
import com.delivery.demo.service.UserAccountService;

import antlr.StringUtils;

@SpringBootTest
class FoodDeliveryApplicationTests {
	
	@Autowired
	CartServiceImpl cartServiceImpl;
	
	@Autowired
	RestaurantService restaurantService;
	
	@Autowired
	MenuService menuService;
	
	@Autowired
	UserAccountService userAccountService;
	
	@MockBean
	UserRespository userRespository;
	
	@MockBean
	RestaurantRepository restaurantRepository;
	
	@MockBean
	CartRepository cartRepository;
	
	@MockBean
	MenuRespository menuRespository;
	
	
	@Test
	public void createUser() {
		when(userRespository.findById("user")).thenReturn(getUserData("user"));
		userAccountService.getUserDetails("user");
		when(userRespository.findById("user")).thenReturn(getUserData(null));
		userAccountService.getUserDetails("user");
	}

	private Optional<UserAccount> getUserData(String key) {
		if(Objects.nonNull(key)) {
			UserAccount userAccount = new UserAccount();
			userAccount.setUsername("user");
			userAccount.setPassword("root");
			Optional userOptinal = Optional.of(userAccount);
			return userOptinal;
		}else {
			Optional userOptinal = Optional.empty();
			return userOptinal;
			
		}
	}

	@Test
	public void login() {
		when(userRespository.findById("user")).thenReturn(getUserData("user"));
		restaurantService.getAllRestaurants();
		when(userRespository.findById("user")).thenReturn(getUserData(""));
		restaurantService.getAllRestaurants();
	}
	
	@Test
	public void getMenuItems() {
		List<FoodMenu> foodList = new ArrayList<>();
		when(menuRespository.findByRestaurantCode("code")).thenReturn(foodList);
		menuService.getMenuItems("code");
	}
	@Test
	public void getPrice() {
		FoodMenu foodMenu = new FoodMenu();
		foodMenu.setPrice(10);
		foodMenu.setFood_name("name");
		foodMenu.setRestaurant_code("rr");
		when(menuRespository.getPrice("rr", "name")).thenReturn(foodMenu);
		CartProducts cartproduct = new CartProducts();
		cartproduct.setQuantity(10);
		cartproduct.setFood_name("name");
		cartproduct.setRestaurant_code("rr");
		menuService.getPrice(cartproduct);
		menuService.getPrice(new CartProducts());
		
	}
	
	@Test
	public void getCartByUserName() {
		when(cartRepository.findCartProductsByUserName("name")).thenReturn(new ArrayList<CartProducts>());
		cartServiceImpl.getCartByUserName("username");
	}
	
	@Test
	public void getMyOrders() {
		when(cartRepository.getMyOrders("nn")).thenReturn(new ArrayList<>());
		cartServiceImpl.getMyOrders("nn");
	}

	@Test
	public void addToCart() {
		cartServiceImpl.addToCart(new CartProducts());
	}
	
	@Test
	public void placeOrder() {
		cartServiceImpl.placeOrder(new ArrayList<>());
	}
	

}
