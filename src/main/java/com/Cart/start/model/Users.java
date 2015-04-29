package com.Cart.start.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USERS_TABLEs")
public class Users implements Serializable {
	
	@Id @Column(name="U_NAME")
	@GeneratedValue
	private int userName;

	@Column(name="F_NAME")
	private String fName;
	
	@Column(name="L_NAME")
	private String lName;
	
	@Column(name="PASSWD")
	private String passwd;
	
	@Column(name="EMAIL")
	private String email;
	
	private enum roles {
		ROLE_USER, ROLE_ADMIN
	}
	
	@Column(name="ROLE")
	private roles role;
	
	public final int getUserName() {
		return userName;
	}

	public final void setUserName(int userName) {
		this.userName = userName;
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

	public final String getPasswd() {
		return passwd;
	}

	public final void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public final String getEmail() {
		return email;
	}

	public final void setEmail(String email) {
		this.email = email;
	}

	public final roles getRole() {
		return role;
	}

	public final void setRole(roles role) {
		this.role = role;
	}
}
