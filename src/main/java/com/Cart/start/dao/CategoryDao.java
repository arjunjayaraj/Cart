package com.Cart.start.dao;

import java.util.List;

import com.Cart.start.model.Category;

public interface CategoryDao {
	public Category findBycategoryName(String categoryName);
	public List<Category> searchByCategoryName(String categoryName);
	public void addCategory(Category category);
    public void updateCategory(Category category);
    public List<Category> listCategory();
    public void removeCategory(Category category);

}
