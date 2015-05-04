package com.Cart.start.manager;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;

import com.Cart.start.dao.UsersDAO;
import com.Cart.start.model.UserRole;
import com.Cart.start.model.Users;

public class UsersManager{

		private UsersDAO usersDAO;

		public UsersManager() {
			usersDAO = new UsersDAO();
		}

		public void saveUser(Users entity) {

			try{
				usersDAO.openCurrentSessionwithTransaction();
				usersDAO.save(entity);
				UserRole user = new UserRole();
				user.setUser(entity);
				user.setRole("ROLE_ADMIN");
				usersDAO.getCurrentSession().save(user);
				
			}
			catch(HibernateException e){
				e.printStackTrace();
				System.out.println("**********************"+e+"***************"+entity);
				usersDAO.getCurrentTransaction().rollback();
			}
			finally{
				usersDAO.closeCurrentSessionwithTransaction();
			}
		}

		public void update(Users entity) {
			try{
				usersDAO.openCurrentSessionwithTransaction();
				usersDAO.update(entity);
			}
			catch(HibernateException e){
				System.out.println(e);
			}
			finally{
				usersDAO.closeCurrentSessionwithTransaction();
			}
		}

		public Users findById(String id) {
			Users Users=null;
			try{
				usersDAO.openCurrentSessionwithTransaction();
				Users = usersDAO.findById(id);
			}
			catch(HibernateException e){
				System.out.println(e);
			}
			finally{
				usersDAO.closeCurrentSessionwithTransaction();
			}
			return Users;
		}
		public Boolean isPresent(String email){
			Users users=null;
			Boolean flag=false;
			List emailList=null;
			try{
				usersDAO.openCurrentSessionwithTransaction();
				
				Criteria criteria = usersDAO.getCurrentSession().createCriteria(Users.class);
							criteria.add(Restrictions.eq("email", email));
							emailList=criteria.list();
							if(emailList!=null){
								flag=true;
							}
				

			
				if(users==null){
					flag=false;
				}
}
			catch(HibernateException e){
				e.printStackTrace();
				usersDAO.getCurrentTransaction().rollback();
			}
			finally{
				usersDAO.closeCurrentSessionwithTransaction();
			}
			return flag;
		}
		

		public void delete(String id) {
			Users Users;
			try{
				usersDAO.openCurrentSessionwithTransaction();
				Users = usersDAO.findById(id);
				usersDAO.delete(Users);
			}
			
			catch(HibernateException e){
				System.out.println(e);
			}
			finally{
				usersDAO.closeCurrentSessionwithTransaction();
			}
		}

		public List<Users> findAll() {
			List<Users> Users=null;
			try{
				usersDAO.openCurrentSession();
				Users = usersDAO.findAll();
			}
			catch(HibernateException e){
				System.out.println(e);
			}
			finally{
				usersDAO.closeCurrentSessionwithTransaction();
			}
			return Users;
		}

		public void deleteAll() {
			try{
				usersDAO.openCurrentSessionwithTransaction();
				usersDAO.deleteAll();
			}
			catch(HibernateException e){
				System.out.println(e);
			}
			finally{
				usersDAO.closeCurrentSessionwithTransaction();
			}
		}

		public UsersDAO UsersDAO() {
			return usersDAO;
		}
}
