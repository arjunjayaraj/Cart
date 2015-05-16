package com.Cart.start.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
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
	
	@Column(name="name", unique=true )
	private String categoryName;

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
//	@OneToMany(cascade=CascadeType.ALL)
//	private Set<Products> product = new HashSet<Products>(0);
//
//	public Set<Products> getProduct() {
//		return product;
//	}
//
//	public void setProduct(Set<Products> product) {
//		this.product = product;
//	}	
	
	public void setCategory(Category category){
	
	}

}
