package com.Cart.start.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Cart.start.model.Products;


@Repository("productDao")
public class ProductDaoImpl implements ProductDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	Session session = null;

	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
	
	Transaction tx = null;
	
	public Transaction getTx() {
		return tx;
	}
	public void setTx(Transaction tx) {
		this.tx = tx;
	}
	
	public Products findByProductName(String productName){
		session = sessionFactory.openSession();
		Products product=(Products) session.load(Products.class, new String(productName));
		return product;
	}
	
	@Override
	public void addProduct(Products product){
		session =sessionFactory.getCurrentSession();
		session.persist(product);
		
	}
    
	public void updateProduct(Products product){}
    
	public List<Products> listProducts(){
    	List<Products> product=null;
		return product;
    }
    
	public void removeProduct(String productName){}
	


	
}
