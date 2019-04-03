package com.cg.capstore.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.capstore.dto.Cart;
import com.cg.capstore.dto.Order;


@Repository
public class CartDaoImpl implements CartDao {

	@PersistenceContext
	EntityManager entitymanager;
	
	public EntityManager getEntitymanager() {
		return entitymanager;
	}

	public void setEntitymanager(EntityManager entitymanager) {
		this.entitymanager = entitymanager;
	}
	
	@Override
	public List<Cart> getAll() {
		System.out.println("In Dao class method....");
		String str = "select cart1 from Cart cart1";
		TypedQuery<Cart> query = entitymanager.createQuery(str,Cart.class);
		return query.getResultList();
	}

	@Override
	public List<Cart> delete(String user_Id) {
		// TODO Auto-generated method stub
		Cart cart = getCartDetails(user_Id);
		entitymanager.remove(cart);
		return getAll();
	}

	@Override
	public Cart add(Cart cart) {
		// TODO Auto-generated method stub
		entitymanager.persist(cart);
		entitymanager.flush();
		return cart;
	}
	@Override
	public Cart getCartDetails(String user_Id) {
		// TODO Auto-generated method stub
		Cart cart = entitymanager.find(Cart.class, user_Id);
		return cart;

	}

	@Override
	public String update(Cart cart) {
		// TODO Auto-generated method stub
		entitymanager.merge(cart);
		return cart.getUser_Id();
	}

	@Override
	public void order(Order order) {
		entitymanager.persist(order);
		entitymanager.flush();
		System.out.println("in dao order");
	}

}
