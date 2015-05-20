package com.Cart.start.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.Cart.start.model.Products;


@Repository("productDao")
public class ProductDaoImpl implements ProductDao{

	
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
	@Override
	public Products findByProductName(String productName){
		session =sessionFactory.getCurrentSession();
		Criteria cr =session.createCriteria(Products.class);
		cr.add(Restrictions.like("productName",productName));
		return ((Products) cr.uniqueResult());
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Products> searchByProductName(String productName){
		session =sessionFactory.getCurrentSession();
		Criteria cr =session.createCriteria(Products.class);
		String productname ="%" + productName +"%";
		cr.add(Restrictions.like("productName",productname));
		return cr.list();
	}
	
	@Override
	public void addProduct(Products product){
		session =sessionFactory.getCurrentSession();
		session.persist(product);
		
	}
	@Override
	public void updateProduct(Products product){
		session =sessionFactory.getCurrentSession();
		session.update(product);
		
		
	}
	@Override
	@SuppressWarnings("unchecked")
	public List<Products> listProducts(){
		session=sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(Products.class);
    	return cr.list();
    }
	@Override
	public void removeProduct(Products product){
		session =sessionFactory.getCurrentSession();
		session.delete(product);
			
	}
	


	
}
