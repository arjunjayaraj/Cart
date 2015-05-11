package com.Cart.start.dao;

import java.util.List;

import com.Cart.start.model.Users;

public interface UsersDao {
	
	public Users findByUserName(String email);
	public void addUser(Users user);
    public void updateUser(Users user);
    public List<Users> listUsers();
    public void removeUser(String username);
}
