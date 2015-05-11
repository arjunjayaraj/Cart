package com.Cart.start.dao;

import java.util.List;

import com.Cart.start.model.UserRole;
import com.Cart.start.model.Users;

public interface UserRoleDao {
	
	public List<Users> findByRole(String role);
	public void addRole(UserRole userrole);
    public List<UserRole> listUserRoles();
    public void removeUserRole(Users user, String role);
    public void removeAllRoles(String user);
}
