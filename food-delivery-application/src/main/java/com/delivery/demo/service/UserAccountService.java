package com.delivery.demo.service;

import com.delivery.demo.entity.UserAccount;

/**
 * userAccountService class to used for user account logic
 * @author Nagendra Babu
 *
 */
public interface UserAccountService {

	/**
	 * getUserDetails method to get user details based on username
	 * @param username
	 * @return useraccount
	 */
	UserAccount getUserDetails(String username);

}
