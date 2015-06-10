package com.Cart.start.service;

import java.util.List;

import com.Cart.start.model.Filter;
import com.Cart.start.model.Products;



public interface ProductService {
	
	public Products findByProductName(String productName);
	public Products findById(int productID);
	public List<Products> searchByProductName(String productName);
	public List<Products> searchByGenderAndProductName(String productName, String genderName);
	public void addProduct(Products product);
    public void updateProduct(Products product);
    public List<Products> listProducts();
    public void removeProduct(int productId);
    public List<String>brands();
    public List<String>categoryList();
    public List<Products> filterList(Filter filter);
	

}
