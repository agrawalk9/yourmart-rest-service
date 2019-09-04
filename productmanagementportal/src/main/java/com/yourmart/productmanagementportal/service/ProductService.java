package com.yourmart.productmanagementportal.service;

import java.util.List;

import com.yourmart.productmanagementportal.model.Product;

public interface ProductService {

	Product addProductService(Product product);

	List<Product> getProductsService(long sellerId);

	List<Product> getAllProducts();

	Product getProduct(long productCode);

	void updateProduct(Product product);

	void updateStatus(Product product);

}