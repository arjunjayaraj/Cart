package com.Cart.start.dao;

import com.Cart.start.model.Users;

public interface LoginDao {
	Users findByUserName(String username);
}
