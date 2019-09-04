package com.yourmart.productmanagementportal.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yourmart.productmanagementportal.facade.ProductFacade;
import com.yourmart.productmanagementportal.model.Product;
import com.yourmart.productmanagementportal.service.ProductService;

@Service
public class ProductFacadeImpl implements ProductFacade {

	@Autowired
	private ProductService productService;
	
	@Override
	public Product addSellerFacade(Product product) {
		return productService.addProductService(product);
	}

	@Override
	public List<Product> getSellerProductsFacade(long sellerId) {
		return productService.getProductsService(sellerId);
	}

	@Override
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	@Override
	public Product getProductFacade(long productCode) {
		return productService.getProduct(productCode);
	}

	@Override
	public void updateProductFacade(Product product) {
		productService.updateProduct(product);
	}

	@Override
	public void updateProductStatusFacade(Product product) {
		productService.updateStatus(product);
	}


}
