package com.Cart.start.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCTS")
public class Products {
	
	@Id @Column(name="P_ID") @GeneratedValue
	private int pid;

	@Column(name="NAME")
	private String pName;
	
	@Column(name="PRICE")
	private double price;
	
	@Column(name="IMAGE")
	private String img;
	
	@Column(name="QTY")
	private long qty;
	
	private enum gender {
		FEMALE, MALE
	}
	
	@Column(name="GENDER")
	private gender gender;
}
