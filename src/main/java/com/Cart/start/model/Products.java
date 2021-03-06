package com.Cart.start.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import enums.Gender;

@Entity
@Table(name = "PRODUCTS")
public class Products {


	@Id
	@GeneratedValue
	@Column(name="ID")
	private int productId;
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	@Column(name="name")
	private String productName;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	@Column(name="img")
	private String productImage;

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
//	@Column(name="img")
//	private byte[] productImage;
//	public byte[] getProductImage() {
//		return productImage;
//	}
//
//	public void setProductImage(byte[] productImage) {
//		this.productImage = productImage;
//	}

	@Column(name="price")
	private double productPrice;

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	@Column(name="brand")
	private String brand;
	
	private Integer quantity;

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Column(name="gender")
	private Gender gender;

	
	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	private Category category;

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	private Set<Cart> cart = new HashSet<Cart>(0);
	
	public void setProduct(Products product){
		this.setProductName(product.getProductName());
		this.setProductImage(product.getProductImage());
		this.setProductPrice(product.getProductPrice());
		this.setQuantity(product.getQuantity());
		this.setBrand(product.getBrand());
		this.setGender(product.getGender());
	}
	
	
}
