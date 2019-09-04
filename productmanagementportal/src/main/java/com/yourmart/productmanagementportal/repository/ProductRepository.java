package com.yourmart.productmanagementportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yourmart.productmanagementportal.enums.EnumConstants.ProductStatusEnums;
import com.yourmart.productmanagementportal.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	@Query("SELECT p FROM Product p WHERE p.sellerId IN :sellerId")
	List<Product> findBySellerId(@Param("sellerId") long sellerId);
	
	@Query("SELECT p FROM Product p WHERE p.status IN :status OR p.status IN :status1")
	List<Product> find(@Param("status") ProductStatusEnums status,@Param("status1") ProductStatusEnums status1 );
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("UPDATE Product p SET p.status = :status , p.creationDate= :creationDate WHERE p.code = :code ")
	int setStatus(@Param("code") long code, @Param("status") ProductStatusEnums status, @Param("creationDate") String creationDate);
	
}
