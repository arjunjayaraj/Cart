package com.Cart.start.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Cart.start.dao.UserRoleDao;
import com.Cart.start.dao.UsersDao;
import com.Cart.start.model.UserRole;
import com.Cart.start.model.Users;

import enums.Roles;

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
	 
	    @Transactional
	    public void addUser(Users user) {
	        this.usersDao.addUser(user);
	        UserRole userrole = new UserRole();
	        userrole.setRole(Roles.ROLE_USER);
	        userrole.setUser(user);
	        this.userRoleDao.addRole(userrole);
	    }
	    @Transactional
	    public void updateUser(Users user, String email) {
	        this.usersDao.updateUser(user);
	    }
	    
	    @Transactional
	    public List<Users> listUsers() {
	    	System.out.println(this.usersDao.listUsers().get(0).getUserRole());
	    	return this.usersDao.listUsers();
	    }
	 
	    @Transactional
	    public Users findByUserName(String username) {
	        return this.usersDao.findByUserName(username);
	    }
	 
	    @Transactional
	    public void removeUser(String username) {
	    	Users user = this.usersDao.findByUserName(username);
	        this.userRoleDao.removeAllRoles(user);
	        this.usersDao.removeUser(username);
	    }

		@Transactional
		@Secured ({"ROLE_ADMIN"})
		public void addRole(String email, Roles role) {
			
			Users user = this.usersDao.findByUserName(email);
			UserRole userrole = new UserRole();
		    userrole.setRole(role);
		    userrole.setUser(user);
		    this.userRoleDao.addRole(userrole);
		}
		
		@Transactional
		@Secured ({"ROLE_ADMIN"})
		public void deleteRole(String email, Roles role) {
			
			Users user = this.usersDao.findByUserName(email);
		    this.userRoleDao.removeUserRole(user, role);
		}
	 
}
