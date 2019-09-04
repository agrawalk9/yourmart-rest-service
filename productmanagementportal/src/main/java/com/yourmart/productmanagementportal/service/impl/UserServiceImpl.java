package com.yourmart.productmanagementportal.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yourmart.productmanagementportal.dto.UserDto;
import com.yourmart.productmanagementportal.enums.EnumConstants.UserStatusEnums;
import com.yourmart.productmanagementportal.model.Role;
import com.yourmart.productmanagementportal.model.User;
import com.yourmart.productmanagementportal.repository.RoleRepository;
import com.yourmart.productmanagementportal.repository.UserRepository;
import com.yourmart.productmanagementportal.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	
	@Override
	public User addUser(User user) {
		Role role=roleRepository.findRoleByName(user.getRoleName());
		role.getUsers().add(user);
		user=userRepository.save(user);
		return user;
	}

	@Override
	public UserDto userAuthenticationService(long userId) {
		Optional<User> optionalUser=userRepository.findById(userId);
		LOGGER.info("password==="+optionalUser.get().getPassword());
		LOGGER.info("doStuff took input ------------- {}"+userId );
		UserDto userPojo=new UserDto();
		if(!optionalUser.isPresent()) {
			userPojo.setId(userId);
			userPojo.setPassword("null");
			userPojo.setStatus(UserStatusEnums.NOT_REGISTERED);
			userPojo.setRole("null");
		}
		else {
			userPojo.setId(optionalUser.get().getUserId());
			userPojo.setPassword(optionalUser.get().getPassword());
			userPojo.setStatus(optionalUser.get().getStatus());
			userPojo.setRole(optionalUser.get().getRoleName());
		}
		return userPojo;
	}

	@Override
	public List<User> getAllSellers() {
		final Predicate<User> userRolePredicate=user->user.getRoleName().equals("SELLER");
		List<User> list=userRepository.findAll().stream().filter(userRolePredicate).collect(Collectors.toList());
//		String role="SELLER";
//		List<User> list=userRepository.getAllSellers(role);
		
		return list;
	}

	@Override
	public int updateStatus(User user) {
		try {
			return userRepository.setStatus(user.getUserId(),user.getStatus());
		}
		catch(Exception ex) {
			LOGGER.error("Exception : "+ex);
			return 0;
		}
	}

}
