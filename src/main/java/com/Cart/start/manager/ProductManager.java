package com.Cart.start.manager;

import java.util.List;

import org.hibernate.HibernateException;

import com.Cart.start.dao.ProductDAO;
import com.Cart.start.model.Products;

public class ProductManager {
	private static ProductDAO productDAO;

	public ProductManager() {
		productDAO = new ProductDAO();
	}

	
	public void persist(Products entity) {
		try{
			productDAO.openCurrentSessionwithTransaction();
			productDAO.save(entity);
		}
		catch(HibernateException e){
			System.out.println(e);
		}
		finally{
			productDAO.closeCurrentSessionwithTransaction();
		}
		
		
	}

	public void update(Products entity) {
		try{
			productDAO.openCurrentSessionwithTransaction();
			productDAO.update(entity);
		}
		catch(HibernateException e){
			System.out.println(e);
		}
		finally{
			productDAO.closeCurrentSessionwithTransaction();
		}
	}

	public Products findProductById(int productId) {
		Products product = null;
		try{
			productDAO.openCurrentSession();
			product=productDAO().findProductById(productId);
		}
		catch(HibernateException e){
			System.out.println(e);
		}
		finally{
			productDAO.closeCurrentSessionwithTransaction();
		}
		return product;
	}

	public void delete(int productId) {
		Products product;
		try{
			productDAO.openCurrentSessionwithTransaction();
		    product = productDAO.findProductById(productId);
			productDAO.delete(product);
	    }
		catch(HibernateException e){
			System.out.println(e);
		}
		finally{
			productDAO.closeCurrentSessionwithTransaction();
		}
	}

	public List<Products> findAll() {
		List<Products> product = null;
		try{
			productDAO.openCurrentSession();
			 product = productDAO.findAll();
		}
		catch(HibernateException e){
			System.out.println(e);
		}
		finally{
			productDAO.closeCurrentSessionwithTransaction();
		}
		return product;
	}

	public void deleteAll() {
		try{
			productDAO.openCurrentSessionwithTransaction();
			productDAO.deleteAll();
		}
		catch(HibernateException e){
			System.out.println(e);
		}
		finally{
			productDAO.closeCurrentSessionwithTransaction();
		}
	}

	public ProductDAO productDAO() {
		return productDAO;
	}
}
