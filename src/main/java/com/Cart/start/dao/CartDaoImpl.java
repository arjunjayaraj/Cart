package com.Cart.start.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.Cart.start.model.Cart;
import com.Cart.start.model.Users;

@Repository
public class CartDaoImpl implements CartDao{

	private SessionFactory sessionFactory;
	
	public final void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addToCart(Cart cart) {
		// TODO Auto-generated method stub
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(cart);
	}

	public void updateCart(Cart cart) {
		// TODO Auto-generated method stub

        Session session = this.sessionFactory.getCurrentSession();
        session.update(cart);
	}

    @SuppressWarnings("unchecked")
	public List<Cart> listCart() {
		// TODO Auto-generated method stub
		Criteria cr = this.sessionFactory.openSession().createCriteria(Users.class);
        List<Cart> cartList = cr.list();
        return cartList;
	}

	public void removeItem(Integer cartId) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Cart cart = (Cart) session.get(Cart.class, new Integer(cartId));
        if(null != cart){
            session.delete(cart);
        }
	}
	
    @SuppressWarnings("unchecked")
	public void removeAllItems(Users user) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session
				.createCriteria(Cart.class)
				.add(Restrictions.eq("user", user));
		List<Cart> cart = cr.list();
		if (null != cart) {
			for (int i = 0; i < cart.size(); i++) {
				session.delete(cart.get(i));
			}
		}
	}

	public Cart findByCartID(int cartId) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Cart cart = (Cart) session.get(Cart.class, new Integer(cartId));
		return cart;
	}
	public Cart findByProductID(int productId){
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr =session.createCriteria(Cart.class);
		cr.add(Restrictions.like("product.productId",productId));
		return (Cart) cr.uniqueResult();
	}

}
