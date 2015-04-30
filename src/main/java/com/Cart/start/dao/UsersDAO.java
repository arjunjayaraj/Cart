package com.Cart.start.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.Cart.start.model.Users;

public class UsersDAO {
	
	private Session currentSession;
	private Transaction currentTransaction;

	public Session openCurrentSession() {

		currentSession = getSessionFactory().openSession();
		return currentSession;
	}

	public Session openCurrentSessionwithTransaction() {

		currentSession = getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		return currentSession;
	}

	public void closeCurrentSession() {

		currentSession.close();
	}

	public void closeCurrentSessionwithTransaction() {

		currentTransaction.commit();
		currentSession.close();
	}

	private static SessionFactory getSessionFactory() {

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

	public void save(Users entity) {

		getCurrentSession().save(entity);

	}

	public void update(Users entity) {

		getCurrentSession().update(entity);

	}

	public Users findById(String id) {

		Users Users = (Users) getCurrentSession().get(Users.class, id);

		return Users;

	}

	public void delete(Users entity) {

		getCurrentSession().delete(entity);

	}
	 @SuppressWarnings("unchecked")
	public List<Users> findAll() {

		Criteria cr = getCurrentSession().createCriteria(Users.class);
		List<Users> Users = (List<Users>)cr.list();

		return Users;

	}

	public void deleteAll() {

		List<Users> entityList = findAll();
		for (Users entity : entityList) {

			delete(entity);

		}

	}
}
