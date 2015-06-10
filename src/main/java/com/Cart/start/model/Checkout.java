package com.Cart.start.model;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Checkout {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Integer checkoutId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EMAIL", nullable = false)
	private Users user;

}
