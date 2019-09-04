package com.yourmart.productmanagementportal.service;

import java.util.List;

import com.yourmart.productmanagementportal.dto.SellerDto;
import com.yourmart.productmanagementportal.dto.UserDto;
import com.yourmart.productmanagementportal.model.User;

public interface UserService {

	User addUser(User user);

	UserDto userAuthenticationService(long userId);

	List<User> getAllSellers();

	int updateStatus(User user);

}