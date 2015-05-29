package com.Cart.start.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.Cart.start.dao.CartDao;
import com.Cart.start.dao.ProductDao;
import com.Cart.start.dao.UsersDao;
import com.Cart.start.model.Cart;
import com.Cart.start.model.Products;
import com.Cart.start.model.Users;

@Service
public class CartServiceImpl implements CartService{
	
	UsersDao userDao;

	ProductDao productDao;

	CartDao cartDao;
	
	public final void setCartDao(CartDao cartDao) {
		this.cartDao = cartDao;
	}
	
	public final void setUserDao(UsersDao userDao) {
		this.userDao = userDao;
	}

	public final void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Transactional
	public void addToCart(String productName, String email) {
		// TODO Auto-generated method stub
		Users user = this.userDao.findByUserName(email);
		Products product = this.productDao.findByProductName(productName);
		Cart cart1 = this.cartDao.findByProductID(product.getProductId());
		if(cart1!=null){
		int qty = cart1.getQty()+1;
			cart1.setQty(qty);
		}
		else{
		Cart cart = new Cart();
		cart.setProduct(product);
		cart.setUser(user);
		cart.setQty(1);
		this.cartDao.addToCart(cart);
		}
		
	}
	
	@Transactional
	public List<Cart> listAllByUser(String email) {
		// TODO Auto-generated method stub
		System.out.println(email);
		Users user = this.userDao.findByUserName(email);
		System.out.println(user);
		Set<Cart> sC= user.getCart();
		System.out.println(sC);
		List<Cart> cartList = new ArrayList<Cart>();
		cartList.addAll(sC);
		return cartList;
	}

	@Transactional
	public void deleteItem(String CartID) {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	public void deleteAllItem(String email) {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	public void updateQty(int qty) {
		// TODO Auto-generated method stub
		
	}
	@Transactional
	public Cart findByProductID(int productId){
		return this.cartDao.findByProductID(productId);
	}

}
