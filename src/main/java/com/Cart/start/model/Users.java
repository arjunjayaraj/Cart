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

	public final String getEmail() {
		return email;
	}

	public final void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "F_NAME", nullable = false, length = 60)
	private String fName;

	public final String getfName() {
		return fName;
	}

	public final void setfName(String fName) {
		this.fName = fName;
	}

	@Column(name = "L_NAME")
	private String lName;

	public final String getlName() {
		return lName;
	}

	public final void setlName(String lName) {
		this.lName = lName;
	}

	@Column(name = "PASSWD", nullable = false, length = 60)
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private Set<UserRole> userRole = new HashSet<UserRole>(0);

	public Set<UserRole> getUserRole() {
		return userRole;
	}

	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}
}
