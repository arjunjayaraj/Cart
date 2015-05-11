package com.Cart.start.model;
import javax.persistence.*;
@Entity
@Table(name="CATEGORY")
public class Category {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer categoryId;

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	
	@Column(name="name" )
	private String categoryName;

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	

}
