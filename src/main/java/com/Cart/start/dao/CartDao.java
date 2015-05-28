package com.Cart.start.dao;

import java.util.List;

import com.Cart.start.model.Cart;
import com.Cart.start.model.Users;

public interface CartDao {
	
	public Cart findByCartID(int cartId);
	public void addToCart(Cart cart);
	public void updateCart(Cart cart);
    public List<Cart> listCart();
    public void removeItem(Integer cartId);
    public void removeAllItems(Users user);
}
