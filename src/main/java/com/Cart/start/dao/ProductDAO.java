package com.Cart.start.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import com.Cart.start.model.Products;

public class ProductDAO {
	private Session currentSession;
	private Transaction currentTransaction;

	 private SessionFactory sessionFactory;
     
	 public void setSessionFactory(SessionFactory sf){
	        this.sessionFactory = sf;
	    }
	public void openCurrentSession() {

		currentSession = getSessionFactory().openSession();
	}

	public void openCurrentSessionwithTransaction() {

		currentSession = getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		
	}

	public void closeCurrentSession() {

		currentSession.close();
	}

	public void closeCurrentSessionwithTransaction() {

		currentTransaction.commit();
		currentSession.close();
	}

	public static SessionFactory getSessionFactory() {

		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration
				.buildSessionFactory(builder.build());
		return sessionFactory;
	}

	public Session getCurrentSession() {

		return currentSession;
	}

	public void setCurrentSession(Session currentSession) {

		this.currentSession = currentSession;
	}

	public Transaction getCurrentTransaction() {

		return currentTransaction;
	}

	public void setCurrentTransaction(Transaction currentTransaction) {

		this.currentTransaction = currentTransaction;
	}

	public void save(Products entity) {
		
		getCurrentSession().save(entity);
	}

	public void update(Products entity) {
		
		getCurrentSession().update(entity);
	}

	public Products findProductById(int productId) {
		
		Products product=(Products) getCurrentSession().get(Products.class, productId);
		return product;
	}

	public void delete(Products entity) {
		
		getCurrentSession().delete(entity);
	}
	
	@SuppressWarnings("unchecked")
	public List<Products> findAll() {
		
		Criteria cr = getCurrentSession().createCriteria(Products.class);
		List<Products> product = (List<Products>) cr.list();
		return product;
	}

	public void deleteAll() {
		
		List<Products> entityList = findAll();
		for (Products entity : entityList) {

			delete(entity);

		}
	}
	
}
