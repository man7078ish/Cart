package com.capgemini.managingCart.service;

import java.util.List;

import com.capgemini.managingCart.beans.Cart;
import com.capgemini.managingCart.beans.Order;


public interface ICartService {

	public List<Cart> getAll();
	public Cart getCartDetails(String user_Id);
	public List<Cart> delete(String user_Id);
	public Cart add(Cart cart);
	public String update(Cart cart);
	public void order(Order order);
	public double total(List<String> prodId);
	public double subtotal(List<String> prodId);
}
