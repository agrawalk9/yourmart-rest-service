package com.yourmart.productmanagementportal.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;


@Entity
public class Role {

	@Id
	private long roleId;
	
	private String role;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="user_role_mapping", 
	        joinColumns = {@JoinColumn(name="role_id")},
	        inverseJoinColumns = {@JoinColumn(name="user_id")})
	private Set<User> users;

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
}
