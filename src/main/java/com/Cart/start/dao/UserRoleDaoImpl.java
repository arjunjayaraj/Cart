package com.Cart.start.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Cart.start.model.UserRole;
import com.Cart.start.model.Users;

@Repository("userRoleDao")
public class UserRoleDaoImpl implements UserRoleDao {

	@Autowired
	SessionFactory sessionFactory;

	public final void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

    @SuppressWarnings("unchecked")
	public List<Users> findByRole(String role) {

		Criteria cr = sessionFactory.openSession()
				.createCriteria(UserRole.class)
				.add(Restrictions.eq("role", role))
				.setProjection(Projections.property("user"));
		List<Users> users = cr.list();
		return users;
	}

	public void addRole(UserRole userrole) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(userrole);
	}

    @SuppressWarnings("unchecked")
	public List<UserRole> listUserRoles() {
		Criteria cr = sessionFactory.openSession().createCriteria(
				UserRole.class);
		List<UserRole> userrole = cr.list();
		return userrole;

	}

    @SuppressWarnings("unchecked")
	public void removeUserRole(Users user, String role) {

		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = sessionFactory.openSession()
				.createCriteria(UserRole.class)
				.add(Restrictions.eq("user", user));
		List<UserRole> userrole = cr.list();
		if (null != userrole) {
			for (int i = 0; i < userrole.size(); i++) {
				if (userrole.get(i).getRole() == role)
					session.delete(userrole.get(i));
			}

		}
	}
    
    @SuppressWarnings("unchecked")
	public void removeAllRoles(String user) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = sessionFactory.openSession()
				.createCriteria(UserRole.class)
				.add(Restrictions.eq("user", user));
		List<UserRole> userrole = cr.list();
		if (null != userrole) {
			for (int i = 0; i < userrole.size(); i++) {
				session.delete(userrole.get(i));
			}
		}
	}

}
