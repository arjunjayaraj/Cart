package com.Cart.start.dao;

import java.util.List;

import com.Cart.start.model.UserRole;
import com.Cart.start.model.Users;

import enums.Roles;

public interface UserRoleDao {
	
	public List<Users> findByRole(Roles role);
	public void addRole(UserRole userrole);
    public List<UserRole> listUserRoles();
    public void removeUserRole(Users user, Roles role);
    public void removeAllRoles(Users user);
}
