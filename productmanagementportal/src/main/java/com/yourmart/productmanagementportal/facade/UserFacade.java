package com.yourmart.productmanagementportal.facade;

import java.util.List;

import com.yourmart.productmanagementportal.dto.SellerDto;
import com.yourmart.productmanagementportal.dto.UserDto;
import com.yourmart.productmanagementportal.model.User;

public interface UserFacade {

	User addSellerFacade(User user);

	UserDto userAuthenticationFacade(long userId);

	List<User> sellerListFacade();

	int updateSellerFacade(User user);

}