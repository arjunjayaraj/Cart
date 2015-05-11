package com.Cart.start.dao;

import java.util.List;

import com.Cart.start.model.Products;

public interface ProductDao {
	
	public Products findByProductName(String productName);
	public void addProduct(Products product);
    public void updateProduct(Products product);
    public List<Products> listProducts();
    public void removeProduct(String productName);
}
