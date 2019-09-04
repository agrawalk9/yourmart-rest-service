package com.yourmart.productmanagementportal.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yourmart.productmanagementportal.enums.EnumConstants.UserStatusEnums;
import com.yourmart.productmanagementportal.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	@Query("SELECT u FROM User u WHERE u.roleName IN :role")
	List<User> getAllSellers(@Param("role") String role);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("UPDATE User u SET u.status = :status WHERE u.userId = :userId")
	int setStatus(@Param("userId") long userId, @Param("status") UserStatusEnums status);
}
