package com.capgemini.managingCart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.managingCart.beans.Cart;
import com.capgemini.managingCart.beans.Order;
import com.capgemini.managingCart.beans.Product;
import com.capgemini.managingCart.service.ICartService;

@RestController
public class HomeController {
	@Autowired
	ICartService service;

	public ICartService getService() {
		return service;
	}

	public void setService(ICartService service) {
		this.service = service;
	}
	@RequestMapping(value="/addProduct",method=RequestMethod.POST,produces="application/json")
	public Cart addProduct(@RequestBody Cart cart)
	{
		cart=service.add(cart);
		return cart;
	}
	
	@RequestMapping(value="/getDetails",method=RequestMethod.POST,produces="application/json")
	public List<Cart> getDetails(@RequestBody List<Cart> cart)
	{
		cart=service.getAll();
		return cart;
	}
	
	@RequestMapping(value="/getCartDetail",method=RequestMethod.POST,produces="application/json")
	public Cart getCartDetail(@RequestBody String cartDetail)
	{
		Cart cart=service.getCartDetails(cartDetail);
		return cart;
	}
	
	@RequestMapping(value="/deleteProduct",method=RequestMethod.POST,produces="application/json")
	public List<Cart> deleteProduct(@RequestBody String user_Id)
	{
		List<Cart> cart=service.delete(user_Id);
		return cart;
	}
	
	@RequestMapping(value="/updateProduct",method=RequestMethod.POST,produces="application/json")
	public String updateProduct(@RequestBody Cart cart)
	{
		 String user_Id=service.update(cart);
		return user_Id;
	}
	
	@RequestMapping(value="/orderProduct",method=RequestMethod.POST,produces="application/json")
	public void order(@RequestBody Order order)
	{
		 service.order(order);
		
	}
	@RequestMapping(value="/total",method=RequestMethod.POST,produces="application/json")
	public void total(@RequestBody List<String> prodId)
	{
		 service.total(prodId);
		
	}
	@RequestMapping(value="/subTotal",method=RequestMethod.POST,produces="application/json")
	public void subTotal(@RequestBody List<String> prodId)
	{
		 service.subtotal(prodId);
		
	}
}
