package com.cg.capstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.capstore.dao.CartDao;
import com.cg.capstore.dto.Cart;
import com.cg.capstore.dto.Order;

@Service
@Transactional
public class CartServiceImpl implements CartService{

	@Autowired
	CartDao dao;
	
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

	

}
