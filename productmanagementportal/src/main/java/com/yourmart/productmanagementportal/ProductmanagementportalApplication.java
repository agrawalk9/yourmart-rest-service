package com.yourmart.productmanagementportal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;

import com.yourmart.productmanagementportal.service.TimerService;

@SpringBootApplication
@EnableDiscoveryClient
public class ProductmanagementportalApplication {

	
	private final static Logger LOGGER = LoggerFactory.getLogger(ProductmanagementportalApplication.class);
	public static void main(String[] args) {
		ApplicationContext appContext=SpringApplication.run(ProductmanagementportalApplication.class, args);
		LOGGER.info("===================================");
		TimerService timeService=appContext.getBean(TimerService.class);
		//timeService.timer();
	}

}
