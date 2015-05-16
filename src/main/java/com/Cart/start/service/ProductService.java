package com.Cart.start.service;

import java.util.List;

import com.Cart.start.model.Products;



public interface ProductService {
	
	public Products findByProductName(String productName);
	public List<Products> searchByProductName(String productName);
	public void addProduct(Products product);
    public void updateProduct(Products product);
    public List<Products> listProducts();
    public void removeProduct(String productName);
	

}
