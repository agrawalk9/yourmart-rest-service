package com.yourmart.productmanagementportal.rest.services;

import java.util.List;

import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.yourmart.productmanagementportal.dto.UserDto;
import com.yourmart.productmanagementportal.enums.EnumConstants.UserStatusEnums;
import com.yourmart.productmanagementportal.facade.UserFacade;
import com.yourmart.productmanagementportal.model.ReCaptchaResponse;
import com.yourmart.productmanagementportal.model.User;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserService {

	@Autowired
	private UserFacade userFacade;
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@PostMapping(value="/register",consumes = "application/json", produces = "application/json")
	public Response addEmployee(@RequestBody User user) {
		user=userFacade.addSellerFacade(user);
		return Response.status(201).entity(user).build();
	}
	
	@PutMapping(value="/update",consumes = "application/json", produces = "application/json")
	public Response updateEmployee(@RequestBody User user) {
		int i=userFacade.updateSellerFacade(user);
		return Response.status(201).entity(i).build();
	}
	
	@GetMapping(value="/authentication", produces = "application/json")
	public String check(@RequestParam(name="id") long id,@RequestParam(name="password") String password,@RequestParam(name="g-captcha-response") String captchaResponse) {
		LOGGER.info("id= "+id);
		LOGGER.info("password= "+password);
		LOGGER.info("captchaResponse= "+captchaResponse);
		UserDto userPojo=userFacade.userAuthenticationFacade(id);
		RestTemplate restTemplate=new RestTemplate();
		String url="https://www.google.com/recaptcha/api/siteverify";
		String params="?secret=6LcLDLYUAAAAACg1HXk8_i2pPmgV-DGcNEgL2jSY&response="+captchaResponse;
		ReCaptchaResponse recaptchaResponse=restTemplate.exchange(url+params,HttpMethod.POST,null,ReCaptchaResponse.class).getBody();
		if(recaptchaResponse.isSuccess()) {
			if(password.equals(userPojo.getPassword())) {
				return userPojo.getStatus().toString()+"-"+userPojo.getRole();
			}
			else {
				return UserStatusEnums.WRONG_PASSWORD.toString();
			}
		}
		return "NOT_A_HUMAN";
		//LOGGER.info("status="+userPojo.getStatus());
	}
	
	@GetMapping(value="/sellers",produces="application/json")
	public List<User> getAllSellers() {
		return userFacade.sellerListFacade();
	}
	
}
