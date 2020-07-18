package com.delivery.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delivery.demo.entity.UserAccount;
import com.delivery.demo.repository.UserRespository;

@Service
public class UserAccountServiceImpl implements UserAccountService {
	
	@Autowired
	UserRespository userRespository;

	@Override
	public UserAccount getUserDetails(String username) {
		return userRespository.findById(username).orElse(new UserAccount());
	}

}
