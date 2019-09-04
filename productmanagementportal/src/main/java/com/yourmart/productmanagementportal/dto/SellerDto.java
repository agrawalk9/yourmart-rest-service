package com.yourmart.productmanagementportal.dto;

import com.yourmart.productmanagementportal.enums.EnumConstants.UserStatusEnums;

public class SellerDto {
	
	private long userId;
	private String companyName;
	private String ownerName;
	private String address;
	private String email;
	private String phoneNo;
	private String GSTNo;
	private String roleName;
	private UserStatusEnums status;
	
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
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public UserStatusEnums getStatus() {
		return status;
	}
	public void setStatus(UserStatusEnums status) {
		this.status = status;
	}
	
}
