package com.Cart.start.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCTS")
public class Products {
	
	@Id 
	@Column(name="P_ID")
	@GeneratedValue
	private int productId;

	@Column(name="NAME")
	private String productName;
	
	@Column(name="PRICE")
	private double price;
	
	@Column(name="IMAGE")
	private String imgage;
	
	@Column(name="QTY")
	private long quantity;
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImgage() {
		return imgage;
	}

	public void setImgage(String imgage) {
		this.imgage = imgage;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public gender getGender() {
		return gender;
	}

	public void setGender(gender gender) {
		this.gender = gender;
	}

	private enum gender {
		FEMALE, MALE
	}
	
	@Column(name="GENDER")
	private gender gender;
}
