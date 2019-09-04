package com.yourmart.productmanagementportal.dto;

import com.yourmart.productmanagementportal.enums.EnumConstants.UserStatusEnums;

public class UserDto {

	private long id;
	private String password;
	private UserStatusEnums status;
	private String role;
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public UserStatusEnums getStatus() {
		return status;
	}
	public void setStatus(UserStatusEnums status) {
		this.status = status;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
