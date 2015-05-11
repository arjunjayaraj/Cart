package com.Cart.start.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Cart.start.dao.ProductDao;
import com.Cart.start.model.Products;
@Service
public class ProductServiceImpl implements ProductService {
	
	ProductDao productDao;
	
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	public Products findByProductName(String productName){
		Products product;
		product = this.productDao.findByProductName(productName);
		return product;
	}
	
	 @Override
	 @Transactional
	public void addProduct(Products product){
		this.productDao.addProduct(product);
	}
    
	public void updateProduct(Products product){
		this.productDao.updateProduct(product);
	}
    public List<Products> listProducts(){
    	List<Products> product;
    	product = this.productDao.listProducts();
		return product;
    }
    
    public void removeProduct(String productName){
    	this.productDao.removeProduct(productName);
    }
	

}
