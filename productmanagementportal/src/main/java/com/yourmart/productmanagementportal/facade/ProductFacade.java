package com.yourmart.productmanagementportal.facade;

import java.util.List;

import com.yourmart.productmanagementportal.model.Product;

public interface ProductFacade {

	Product addSellerFacade(Product product);

	List<Product> getSellerProductsFacade(long sellerId);

	List<Product> getAllProducts();

	Product getProductFacade(long productCode);

	void updateProductFacade(Product product);

	void updateProductStatusFacade(Product product);

}