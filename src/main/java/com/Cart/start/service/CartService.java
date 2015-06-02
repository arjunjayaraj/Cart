package com.Cart.start.service;

import java.util.List;

import com.Cart.start.model.Cart;
import com.Cart.start.model.Category;

public interface CartService {

	public void addToCart(String productName, String email);
	public List<Cart> listAllByUser(String email);
	public void deleteItem(int CartID);
	public void deleteAllItem(String email);
	public void updateQty(int qty);
	public Cart findByProductID(int productId);
}
