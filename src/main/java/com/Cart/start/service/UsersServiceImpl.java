package com.Cart.start.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Cart.start.dao.UsersDao;
import com.Cart.start.model.Users;

@Service
public class UsersServiceImpl implements UsersService{
		
		private UsersDao usersDao;
	  
	    public void setUsersDao(UsersDao usersDao) {
	        this.usersDao = usersDao;
	    }
	 
	    @Override
	    @Transactional
	    public void addUser(Users p) {
	        this.usersDao.addUser(p);
	    }
	 
	    @Override
	    @Transactional
	    public void updateUser(Users p) {
	        this.usersDao.updateUser(p);
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
	    }
	 
}
