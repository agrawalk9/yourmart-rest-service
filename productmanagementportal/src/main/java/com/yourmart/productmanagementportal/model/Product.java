package com.yourmart.productmanagementportal.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.yourmart.productmanagementportal.enums.EnumConstants.ProductStatusEnums;

@Entity
public class Product {

	@Id
	private long code;
	private String primaryImagePath;
	private String name;
	private String description;
	private ProductStatusEnums status;
	private String categories;
	private Double mrp;
	private Double ssp;
	private Double ymp;
	private long sellerId;
	private String creationDate;
	
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public long getCode() {
		return code;
	}
	public void setCode(long code) {
		this.code = code;
	}
	public String getPrimaryImagePath() {
		return primaryImagePath;
	}
	public void setPrimaryImagePath(String primaryImagePath) {
		this.primaryImagePath = primaryImagePath;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ProductStatusEnums getStatus() {
		return status;
	}
	public void setStatus(ProductStatusEnums status) {
		this.status = status;
	}
	public String getCategories() {
		return categories;
	}
	public void setCategories(String categories) {
		this.categories = categories;
	}
	public Double getMrp() {
		return mrp;
	}
	public void setMrp(Double mrp) {
		this.mrp = mrp;
	}
	public Double getSsp() {
		return ssp;
	}
	public void setSsp(Double ssp) {
		this.ssp = ssp;
	}
	public Double getYmp() {
		return ymp;
	}
	public void setYmp(Double ymp) {
		this.ymp = ymp;
	}
	public long getSellerId() {
		return sellerId;
	}
	public void setSellerId(long sellerId) {
		this.sellerId = sellerId;
	}
	
}
