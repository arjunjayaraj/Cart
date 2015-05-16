package com.Cart.start.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.Cart.start.model.Category;

@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao{
	

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
	public Category findBycategoryName(String categoryName){
		session =sessionFactory.getCurrentSession();
		Criteria cr =session.createCriteria(Category.class);
		cr.add(Restrictions.like("categoryName",categoryName));
		Category category=(Category) cr.uniqueResult();
		return category;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Category> searchByCategoryName(String categoryName){
		session =sessionFactory.getCurrentSession();
		Criteria cr =session.createCriteria(Category.class);
		cr.add(Restrictions.like("categoryName","%" +categoryName +"%"));
		List<Category> category=(List<Category>) cr.list();
		return category;
		
	}
	
	@Override
	public void addCategory(Category category){
		
		session =sessionFactory.getCurrentSession();
		session.persist(category);
		
	}
    
	@Override
	public void updateCategory(Category category){
		session =sessionFactory.getCurrentSession();
		session.update(category);
	}
    
	@SuppressWarnings("unchecked")
	@Override
	public List<Category> listCategory(){
		session =sessionFactory.getCurrentSession();
		Criteria cr =session.createCriteria(Category.class);
		List<Category> category=(List<Category>) cr.list();
		return category;
		
    }
	
	@Override
    public void removeCategory(Category category){
		session.delete(category);
	}	
}
