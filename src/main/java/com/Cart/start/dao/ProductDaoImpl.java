package com.Cart.start.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.Cart.start.model.Category;
import com.Cart.start.model.Filter;
import com.Cart.start.model.Products;

import enums.Gender;


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
	@Override
	public Products findById(int productID){
		session =sessionFactory.getCurrentSession();
		Criteria cr =session.createCriteria(Products.class);
		cr.add(Restrictions.like("productId",productID));
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
	@SuppressWarnings("unchecked")
	public List<Products> searchByGenderAndProductName(String productName, String genderName){
		session =sessionFactory.getCurrentSession();
		Criteria cr =session.createCriteria(Products.class);
		String productname ="%" + productName +"%";
		if(!(genderName.equals("ALL")))
		{
			cr.add(Restrictions.like("gender",Gender.valueOf(genderName)));
		}
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
	
	@SuppressWarnings("unchecked")
	public List<String>brands(){
		session=sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(Products.class);
		cr.setProjection(Projections.distinct(Projections.property("brand")) );
		return cr.list();
	}
	@SuppressWarnings("unchecked")
	public List<Products> filterList(Filter filter){
		session=sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(Products.class);
		String productname ="%" + filter.getSearch() +"%";
		if(!(filter.getAgeGroup().equals("ALL")))
		{
			cr.add(Restrictions.like("gender",Gender.valueOf(filter.getAgeGroup())));
		}
		cr.add(Restrictions.like("productName",productname));
		Disjunction or = Restrictions.disjunction();
		for(String brand:filter.getBrand()){
			or.add(Restrictions.eq("brand",brand));
		}
		cr.add(or);
		Disjunction orr = Restrictions.disjunction();
		for(String category:filter.getCategory()){
			orr.add(Restrictions.eq("category.categoryName",category));
		}
		cr.add(orr);
		return cr.list();
		  
	  }
	@SuppressWarnings("unchecked")
	public List<String>categoryList(){
		session=sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(Category.class);
		cr.setProjection(Projections.distinct(Projections.property("categoryName")) );
		return cr.list();
		 
	 }
	
	
}
