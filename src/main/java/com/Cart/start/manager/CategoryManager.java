package com.Cart.start.manager;

import java.util.List;

import org.hibernate.HibernateException;

import com.Cart.start.dao.CategoryDAO;
import com.Cart.start.model.Category;

public class CategoryManager {
	private static CategoryDAO categoryDAO;

	public CategoryManager() {
		categoryDAO = new CategoryDAO();
	}

	public void save(Category entity) {
		try{
			categoryDAO.openCurrentSessionwithTransaction();
			categoryDAO.save(entity);
		}
		catch(HibernateException e){
			System.out.println(e);
		}
		finally{
			categoryDAO.closeCurrentSessionwithTransaction();
		}
		
	}

	public void update(Category entity) {
		try{
			categoryDAO.openCurrentSessionwithTransaction();
			categoryDAO.update(entity);
		}
		catch(HibernateException e){
			System.out.println(e);
		}
		finally{
			categoryDAO.closeCurrentSessionwithTransaction();
		}
		
	}

	public Category findCategoryById(int categoryId) {
		Category category = null;
		try{
			categoryDAO.openCurrentSession();
			category=categoryDAO.findCategoryById(categoryId);
		}
		catch(HibernateException e){
			System.out.println(e);
		}
		finally{
			categoryDAO.closeCurrentSessionwithTransaction();
		}
		return category;
	}

	public void delete(int categoryId) {
		Category category=null;
		try{
			categoryDAO.openCurrentSessionwithTransaction();
		    category = categoryDAO.findCategoryById(categoryId);
		    categoryDAO.delete(category);
		}
		catch(HibernateException e){
			System.out.println(e);
		}
		finally{
			categoryDAO.closeCurrentSessionwithTransaction();
		}
	}

	public List<Category> findAll() {
		List<Category> category = null;
		try{
			categoryDAO.openCurrentSession();
		  category = categoryDAO.findAll();
		}
		catch(HibernateException e){
			System.out.println(e);
		}
		finally{
			categoryDAO.closeCurrentSessionwithTransaction();
		}
		return category;
	}

	public void deleteAll() {
		try{
			categoryDAO.openCurrentSessionwithTransaction();
			categoryDAO.deleteAll();
		}
		catch(HibernateException e){
			System.out.println(e);
		}
		finally{
			categoryDAO.closeCurrentSessionwithTransaction();
		}
	}


	
	public CategoryDAO categoryDAO() {
		return categoryDAO;
	}
}
