package com.Cart.start.dao;

import java.util.List;

import com.Cart.start.model.Users;

public interface UsersDao {
	
	Users findByUserName(String email);
	public void addUser(Users u);
    public void updateUser(Users u);
    public List<Users> listUsers();
    public void removeUser(String username);
}
