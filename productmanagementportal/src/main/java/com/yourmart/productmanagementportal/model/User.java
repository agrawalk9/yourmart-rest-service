package com.yourmart.productmanagementportal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yourmart.productmanagementportal.enums.EnumConstants.UserStatusEnums;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userId;
	private String companyName;
	private String ownerName;
	private String address;
	private String email;
	private String phoneNo;
	private String GSTNo;
	private String password;
	private String roleName;
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	private UserStatusEnums status;
	@OneToOne
	@JoinTable(name = "user_role_mapping", joinColumns = {@JoinColumn(name="user_id")},
	        inverseJoinColumns = {@JoinColumn(name="role_id")})
	private Role role;
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getGSTNo() {
		return GSTNo;
	}
	public void setGSTNo(String gSTNo) {
		GSTNo = gSTNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserStatusEnums getStatus() {
		return status;
	}
	public void setStatus(UserStatusEnums status) {
		this.status = status;
	}
	@JsonIgnore
	public Role getRole() {
		return role;
	}
	@JsonProperty
	public void setRole(Role role) {
		this.role = role;
	}
}
