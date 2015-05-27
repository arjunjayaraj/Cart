package com.Cart.start.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="CART")
public class Cart {
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Integer cartId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EMAIL", nullable = false)
	private Users user;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PRODUCT", nullable = false)
	private Products product;

	@Column(name="QTY")
	private int qty;
	
	@Column(name="AVAIL")
	private boolean avail;

	public final Integer getCartId() {
		return cartId;
	}

	public final void setCartId(Integer cartId) {
		this.cartId = cartId;
	}
	
	public final Users getUser() {
		return user;
	}

	public final void setUser(Users user) {
		this.user = user;
	}

	public final Products getProduct() {
		return product;
	}

	public final void setProduct(Products product) {
		this.product = product;
	}

	public final int getQty() {
		return qty;
	}

	public final void setQty(int qty) {
		this.qty = qty;
	}

	public final boolean isAvail() {
		return avail;
	}

	public final void setAvail(boolean avail) {
		this.avail = avail;
	}
}
