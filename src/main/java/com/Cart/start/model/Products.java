package com.Cart.start.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
	
	@Column(name="name", unique=true)
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
	public void setProduct(Products product){
		this.setProductName(product.getProductName());
		this.setProductImage(product.getProductImage());
		this.setProductPrice(product.getProductPrice());
		this.setQuantity(product.getQuantity());
		System.out.println("GEnder is   " +product.getGender());
		this.setBrand(product.getBrand());
		this.setGender(product.getGender());
	}
	
	
}
