package com.Cart.start.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.Cart.start.model.Category;
import com.Cart.start.model.Products;

public class CategoryDAO {
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

    public void save(Category entity) {
		
		getCurrentSession().save(entity);
	}

	public void update(Category entity) {
		
		getCurrentSession().update(entity);
	}

	public Category findCategoryById(int categoryId) {
		Category  category=(Category) getCurrentSession().get(Category.class, categoryId);
		return category;
	}

	public void delete(Category entity) {
		
		getCurrentSession().delete(entity);
	}
	
	@SuppressWarnings("unchecked")
	public List<Category> findAll() {
		
		Criteria cr = getCurrentSession().createCriteria(Category.class);
		List<Category> category = (List<Category>) cr.list();
		return category;
	}

	public void deleteAll() {
		
		List<Category> entityList = findAll();
		for (Category entity : entityList) {

			delete(entity);

		}
	}
	
	
}
