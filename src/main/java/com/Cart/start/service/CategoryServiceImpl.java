package com.Cart.start.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.Cart.start.dao.CategoryDao;
import com.Cart.start.model.Category;

public class CategoryServiceImpl implements CategoryService {
		
	@Autowired
	CategoryDao categoryDao;
	
	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
	
	@Transactional
	public Category findBycategoryName(String categoryName){
		return this.categoryDao.findBycategoryName(categoryName);
	}
	
	@Transactional
	public List<Category> searchByCategoryName(String categoryName){
		return this.categoryDao.searchByCategoryName(categoryName);
	}
	
	@Transactional
	public void addCategory(Category category){
		Category entity = this.findBycategoryName(category.getCategoryName());
		if(entity==null){
		this.categoryDao.addCategory(category);
		}
		else{
			System.out.println("category already exists");
		}
	}
    
	@Transactional
	public void updateCategory(Category category){}
    
	@Transactional
	public List<Category> listCategory(){
       	return this.categoryDao.listCategory();
	}
	
	@Transactional
    public void removeCategory(String categoryName){
		Category category = this.findBycategoryName(categoryName);
		if(category!=null){
			this.categoryDao.removeCategory(category);
		}
		else{
			System.out.println("no category object found");
		}
		
	}	
}
