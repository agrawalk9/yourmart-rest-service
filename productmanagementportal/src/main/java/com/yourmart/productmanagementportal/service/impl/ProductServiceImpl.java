package com.yourmart.productmanagementportal.service.impl;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.yourmart.productmanagementportal.enums.EnumConstants.ProductStatusEnums;
import com.yourmart.productmanagementportal.model.Product;
import com.yourmart.productmanagementportal.repository.ProductRepository;
import com.yourmart.productmanagementportal.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public Product addProductService(Product product) {
		try {
			return productRepository.save(product);
		}
		catch(Exception ex) {
			LOGGER.error("Exception : "+ex);
			return new Product();
		}
	}

	@Override
	public List<Product> getProductsService(long sellerId) {
		return productRepository.findBySellerId(sellerId);
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product getProduct(long productCode) {
		Optional<Product> optional = productRepository.findById(productCode);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return new Product();
		}
	}

	@Override
	public void updateProduct(Product product) {
		try {
			productRepository.deleteById(product.getCode());
			productRepository.save(product);
		}
		catch(Exception ex) {
			LOGGER.error("Exception : "+ex);
		}
	}

	@Override
	public void updateStatus(Product product) {
		long code = product.getCode();
		ProductStatusEnums status = product.getStatus();
		String creationDate = product.getCreationDate();
		LOGGER.info("date:::" + creationDate);
		try {
			productRepository.setStatus(code, status, creationDate);
			if (product.getStatus().toString().equals("REJECTED")) {
				LOGGER.info("NO EXCEPTION");
				SimpleMailMessage msg = new SimpleMailMessage();
				msg.setTo("15ucs061@lnmiit.ac.in");
				msg.setSubject("Testing from Spring Boot");
				msg.setText("Product id "  + String.valueOf(product.getCode()) + " and status changed to "
				 + product.getStatus().toString() );
				javaMailSender.send(msg);
			}
		}
		catch(Exception ex) {
			LOGGER.error("Exception : "+ex);
		}
	}

	
}
