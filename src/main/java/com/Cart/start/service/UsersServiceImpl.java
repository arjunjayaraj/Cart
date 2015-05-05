package com.Cart.start.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Cart.start.dao.LoginDao;
import com.Cart.start.model.Users;

@Service
public class UsersServiceImpl implements UsersService{
		
		private LoginDao loginDao;
	  
	    public void setLoginDao(LoginDao loginDao) {
	        this.loginDao = loginDao;
	    }
	 
	    @Override
	    @Transactional
	    public void addUser(Users p) {
	        this.loginDao.addUser(p);
	    }
	 
	    @Override
	    @Transactional
	    public void updateUser(Users p) {
	        this.loginDao.updateUser(p);
	    }
	 
	    @Override
	    @Transactional
	    public List<Users> listUsers() {
	        return this.loginDao.listUsers();
	    }
	 
	    @Override
	    @Transactional
	    public Users findByUserName(String username) {
	        return this.loginDao.findByUserName(username);
	    }
	 
	    @Override
	    @Transactional
	    public void removeUser(String username) {
	        this.loginDao.removeUser(username);
	    }
	 
}
