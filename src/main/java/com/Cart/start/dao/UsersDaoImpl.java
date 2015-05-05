package com.Cart.start.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Cart.start.model.UserRole;
import com.Cart.start.model.Users;

@Repository("usersDao")
public class UsersDaoImpl implements UsersDao {
	
	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	public Users findByUserName(String email) {
		session = sessionFactory.openSession();
		tx = session.getTransaction();
		session.beginTransaction();
		Users user = (Users) session.load(Users.class, new String(email));
		tx.commit();
		return user;
	}
   
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
 
    @Override
    public void addUser(Users u) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(u);
        UserRole ur = new UserRole();
        ur.setRole("ROLE_ADMIN");
        ur.setUser(u);
        session.persist(ur);
    }
 
    @Override
    public void updateUser(Users u) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(u);
    }
 
    @SuppressWarnings("unchecked")
    @Override
    public List<Users> listUsers() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Users> usersList = session.createQuery("from USERS").list();
        return usersList;
    }
 
 
    @Override
    public void removeUser(String username) {
        Session session = this.sessionFactory.getCurrentSession();
        Users u = (Users) session.load(Users.class, new Integer(username));
        if(null != u){
            session.delete(u);
        }
    }
}