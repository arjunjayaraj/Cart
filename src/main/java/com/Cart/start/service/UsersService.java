package com.Cart.start.service;

import java.util.List;

import com.Cart.start.model.Users;

import enums.Roles;

 
public interface UsersService {
 
	Users findByUserName(String username);
	public void addUser(Users user);
	public void addRole(String email, Roles role);
    public void updateUser(Users user);
    public List<Users> listUsers();
    public void removeUser(String username);
    
}