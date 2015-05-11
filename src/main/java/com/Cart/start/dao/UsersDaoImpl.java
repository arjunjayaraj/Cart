package com.Cart.start.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Cart.start.model.Users;

@Repository("usersDao")
public class UsersDaoImpl implements UsersDao {
	
	@Autowired
	SessionFactory sessionFactory;
   
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
 
	public Users findByUserName(String email) {
		
		Criteria cr = this.sessionFactory.openSession().createCriteria(
				Users.class).add(Restrictions.eq("email", email));
		Users user = (Users) cr.uniqueResult();
		return user;
	}
	
    public void addUser(Users user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(user);
    }
    public void updateUser(Users user) {
    	
        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);
    }
 
    @SuppressWarnings("unchecked")
    public List<Users> listUsers() {
    	
    	Criteria cr = this.sessionFactory.openSession().createCriteria(Users.class);
        List<Users> usersList = cr.list();
        return usersList;
    }
 
    public void removeUser(String username) {
        Session session = this.sessionFactory.getCurrentSession();
        Users user = (Users) session.load(Users.class, new String(username));
        if(null != user){
            session.delete(user);
        }
    }
}