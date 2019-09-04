package com.yourmart.productmanagementportal.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yourmart.productmanagementportal.dto.SellerDto;
import com.yourmart.productmanagementportal.dto.UserDto;
import com.yourmart.productmanagementportal.facade.UserFacade;
import com.yourmart.productmanagementportal.model.User;
import com.yourmart.productmanagementportal.service.UserService;

@Service
public class UserFacadeImpl implements UserFacade {

	@Autowired
	private UserService userService;
	
	@Override
	public User addSellerFacade(User user) {
		return userService.addUser(user);
	}

	@Override
	public UserDto userAuthenticationFacade(long userId) {
		return userService.userAuthenticationService(userId);
	}

	@Override
	public List<User> sellerListFacade() {
		return userService.getAllSellers();
	}

	@Override
	public int updateSellerFacade(User user) {
		return userService.updateStatus(user);
	}

}
