package com.Cart.start.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Cart.start.dao.ProductDao;
import com.Cart.start.model.Category;
import com.Cart.start.model.Products;
@Service
public class ProductServiceImpl implements ProductService {
	

//	
	@Autowired(required = true)
	@Qualifier(value = "categoryService")
	CategoryService categoryService;
	
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	ProductDao productDao;
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	@Override
	 @Transactional
	public Products findByProductName(String productName){
			return this.productDao.findByProductName(productName);
	}
	@Override
	 @Transactional
	public List<Products> searchByProductName(String productName){
		return this.productDao.searchByProductName(productName);
	}
	@Override
	 @Transactional
	public List<Products> searchByGenderAndProductName(String productName, String genderName){
		return this.productDao.searchByGenderAndProductName(productName,genderName);
		
		
	}
	 @Override
	 @Transactional
	public void addProduct(Products product){
		 Category category = this.categoryService.findBycategoryName(product.getCategory().getCategoryName());
			if(category!=null){
			product.setCategory(category);
			}
		this.productDao.addProduct(product);
	}
	 @Override
	 @Transactional
	public void updateProduct(Products product){
		 Products entity =findByProductName(product.getProductName()); // To check entity is present
			if(entity!=null){
				entity.setProduct(product);
				if(!(product.getCategory().getCategoryName().equals(entity.getCategory().getCategoryName()))){ //To check whether category is changed or not
					Category category = this.categoryService.findBycategoryName(product.getCategory().getCategoryName());
					if(category!=null){
						entity.setCategory(category);
					}
					else{
						entity.setCategory(product.getCategory());
					}
						
				}
				this.productDao.updateProduct(entity);
			}
			else {
				System.out.println("entity not found");
			}
		 	}
	 @Override
	 @Transactional
    public List<Products> listProducts(){
    	return this.productDao.listProducts();
	}
	
	 @Override
	 @Transactional
    public void removeProduct(String productName){
		 Products entity =findByProductName(productName);
			if(entity!=null){
				entity.setCategory(null);
				this.productDao.removeProduct(entity);
			}
			else {
				System.out.println("entity not found");
			}
    	
    }
	

}
