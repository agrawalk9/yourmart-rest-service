package com.yourmart.productmanagementportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.yourmart.productmanagementportal.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

	@Query("SELECT r FROM Role r WHERE r.role = :role")
	Role findRoleByName(@Param("role") String role);
	
}
