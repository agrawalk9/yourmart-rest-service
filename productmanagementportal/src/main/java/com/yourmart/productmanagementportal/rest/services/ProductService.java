package com.yourmart.productmanagementportal.rest.services;

import java.util.List;

import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yourmart.productmanagementportal.facade.ProductFacade;
import com.yourmart.productmanagementportal.model.Product;

@RestController
@CrossOrigin
@RequestMapping("/products")
public class ProductService {

	@Autowired
	private ProductFacade productFacade;

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
	public Response addProduct(@RequestBody Product product) {
		LOGGER.info("date== "+product.getCreationDate());
		product = productFacade.addSellerFacade(product);
		return Response.status(201).entity(product).build();
	}
	
	@PutMapping(value = "/updateStatus", consumes = "application/json", produces = "application/json")
	public Response updateProductStatus(@RequestBody Product product) {
		LOGGER.info("code:   "+product.getCode());
		LOGGER.info("code status:   "+product.getStatus());
		productFacade.updateProductStatusFacade(product);
		return Response.status(201).entity(product).build();
	}

	@PutMapping(value = "/update", consumes = "application/json", produces = "application/json")
	public Response updateProduct(@RequestBody Product product) {
		productFacade.updateProductFacade(product);
		return Response.status(201).entity(product).build();
	}

	@GetMapping(value = "/seller/{sellerId}", produces = "application/json")
	public List<Product> getProducts(@PathVariable("sellerId") long sellerId) {
		LOGGER.info("sellerId=" + sellerId);
		return productFacade.getSellerProductsFacade(sellerId);
	}

	@GetMapping(value = "/{productCode}", produces = "application/json")
	public Product getProduct(@PathVariable("productCode") long productCode) {
		LOGGER.info("productCode=" + productCode);
		return productFacade.getProductFacade(productCode);
	}

	@GetMapping(produces = "application/json")
	public List<Product> getAllProducts() {
		//List<Product> list=productFacade.products();
		return productFacade.getAllProducts();
	}
}
