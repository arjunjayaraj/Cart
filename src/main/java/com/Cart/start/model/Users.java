package com.Cart.start.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class Users {

	@Id
	@Column(name = "EMAIL", unique = true, nullable = false, length = 45)
	private String email;

	@Column(name = "F_NAME", nullable = false, length = 60)
	private String fName;
	
	@Column(name = "L_NAME")
	private String lName;


	@Column(name = "PASSWD", nullable = false, length = 60)
	private String password;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
	private Set<UserRole> userRole = new HashSet<UserRole>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private Set<Cart> cart = new HashSet<Cart>(0);
	
	public final String getEmail() {
		return email;
	}
	public final void setEmail(String email) {
		this.email = email;
	}

	public final String getfName() {
		return fName;
	}
	public final void setfName(String fName) {
		this.fName = fName;
	}
	
	public final String getlName() {
		return lName;
	}
	public final void setlName(String lName) {
		this.lName = lName;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Set<UserRole> getUserRole() {
		return userRole;
	}
	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}
	
	public final Set<Cart> getCart() {
		return cart;
	}
	public final void setCart(Set<Cart> cart) {
		this.cart = cart;
	}
}
