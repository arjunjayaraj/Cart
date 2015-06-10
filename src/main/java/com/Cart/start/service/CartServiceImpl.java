package com.Cart.start.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.hibernate.hql.internal.ast.tree.IsNotNullLogicOperatorNode;
import org.hibernate.jpa.criteria.predicate.IsEmptyPredicate;
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
		Cart cart1 = this.cartDao.findUsersProductByID(product.getProductId(), user);
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
		Users user = this.userDao.findByUserName(email);
		Set<Cart> sC= user.getCart();
		List<Cart> cartList = new ArrayList<Cart>();
		if(!sC.isEmpty()){
			cartList.addAll(sC);
		}
		return cartList;
	}

	@Transactional
	public void deleteItem(int cartId) {
		this.cartDao.removeItem(cartId);
		
	}

	@Transactional
	public void deleteAllItem(String email) {
	Users user = this.userDao.findByUserName(email);
	this.cartDao.removeAllItems(user);
		
	}

	@Transactional
	public void updateQty(Integer qty,Integer cartId){
		Cart cart = this.cartDao.findByCartID(cartId);
		cart.setQty(qty);
		this.cartDao.updateCart(cart);
		
	}
	@Transactional
	public List<Cart> findByProductID(int productId){
		return this.cartDao.findByProductID(productId);
	}

}
