package com.Cart.start.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Cart.start.dao.UserRoleDao;
import com.Cart.start.dao.UsersDao;
import com.Cart.start.model.UserRole;
import com.Cart.start.model.Users;

@Service
public class UsersServiceImpl implements UsersService{
		
		private UsersDao usersDao;
		private UserRoleDao userRoleDao;
	  
		public void setUserRoleDao(UserRoleDao userRoleDao) {
			this.userRoleDao = userRoleDao;
		}

		public void setUsersDao(UsersDao usersDao) {
	        this.usersDao = usersDao;
	    }
	 
	    @Override
	    @Transactional
	    public void addUser(Users user) {
	        this.usersDao.addUser(user);
	        UserRole userrole = new UserRole();
	        userrole.setRole("ROLE_USER");
	        userrole.setUser(user);
	        this.userRoleDao.addRole(userrole);
	    }
	    @Override
	    @Transactional
	    public void updateUser(Users user) {
	        this.usersDao.updateUser(user);
	    }
	    
	    @Override
	    @Transactional
	    public List<Users> listUsers() {
	        return this.usersDao.listUsers();
	    }
	 
	    @Override
	    @Transactional
	    public Users findByUserName(String username) {
	        return this.usersDao.findByUserName(username);
	    }
	 
	    @Override
	    @Transactional
	    public void removeUser(String username) {
	        this.usersDao.removeUser(username);
	        this.userRoleDao.removeAllRoles(username);
	    }
	 
}
