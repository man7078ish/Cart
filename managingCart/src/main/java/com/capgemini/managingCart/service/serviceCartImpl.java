package com.capgemini.managingCart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.managingCart.beans.Cart;
import com.capgemini.managingCart.beans.Order;
import com.capgemini.managingCart.repo.ICartRepo;

@Service
@Transactional
public class serviceCartImpl implements ICartService{
	@Autowired
ICartRepo dao;
	@Override
	public List<Cart> getAll() {
		return dao.getAll();
	}

	@Override
	public List<Cart> delete(String user_Id) {
		
		return dao.delete(user_Id);
	}

	@Override
	public Cart add(Cart cart) {
		// TODO Auto-generated method stub
		return dao.add(cart);
	}

	@Override
	public Cart getCartDetails(String user_Id) {
		// TODO Auto-generated method stub
		return dao.getCartDetails(user_Id);
	}

	@Override
	public String update(Cart cart) {
		// TODO Auto-generated method stub
		return dao.update(cart);
	}

	@Override
	public void order(Order order) {
		dao.order(order);
		
	}

	@Override
	public double total(List<String> prodId) {
		return dao.total(prodId);
	}

	@Override
	public double subtotal(List<String> prodId) {
		return dao.subtotal(prodId);
	}
}
