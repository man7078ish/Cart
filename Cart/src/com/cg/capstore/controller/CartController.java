package com.cg.capstore.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.capstore.dto.Cart;
import com.cg.capstore.dto.Order;
import com.cg.capstore.dto.OrderProduct;
import com.cg.capstore.service.CartService;



@Controller
public class CartController {

	@Autowired
	CartService service;
	/*@Autowired
	Order order;
	@Autowired
	OrderProduct op;*/
	public CartService getService() {
		return service;
	}

	public void setService(CartService service) {
		this.service = service;
	}

	@RequestMapping("getcartlist.obj")
	public ModelAndView showCartList(Model model){

		//To fetch data from database
		List<Cart> list = service.getAll();
		
		return new ModelAndView("home","list",list);	
	}
	
	@RequestMapping("order.obj")
	public ModelAndView placeOrder(@ModelAttribute("my") Cart cart){

		//To fetch data from database
		//List<Cart> list = service.getAll();
		Order order= new Order();
		
		OrderProduct op= new OrderProduct();
		order.setTotalPrice(cart.getPrice());
		op.setProduct_id(cart.getProd_Id());
		op.setOrder_id(order.getOrderId());
		order.setCouponCode("61h31ynh");
		order.setPaymentId("123d");
		order.setOrderStatus("Pending");
		order.setOrderDate("21-Mar-2018");
		cart.getQuantity();
		order.setUserId(cart.getUser_Id());
		service.order(order);
		
		return new ModelAndView("orderSuccess","orderId",order.getOrderId());	
	}

	@RequestMapping("add.obj")
	public String addToCart(@ModelAttribute("my") Cart cart){
		return "addform";
	}

	@RequestMapping("added.obj")
	public String addedToCart(@ModelAttribute("my") Cart cart){
		Cart c= service.add(cart);
		System.out.println(c);
		return "addsuccess";
	}

	@RequestMapping("delete.obj")
	public String deleteCart(@ModelAttribute("my") Cart cart){
		return "deleteform";
	}
	@RequestMapping("deleted.obj")
	public String deleteFromCart(@ModelAttribute("my") Cart cart){
		System.out.println(cart.getUser_Id());
		service.delete(cart.getUser_Id());
		return "deletesuccess";
	}

	@RequestMapping("increment")
	public String incremen(@RequestParam("cartid") String user_Id,Model model){

		Cart cart = service.getCartDetails(user_Id);
		System.out.println(cart);
		int quan=cart.getQuantity();
		int price=cart.getPrice();
		int newPrice = price/quan;
		quan=quan+1;
		price=newPrice*quan;
		System.out.println(quan);
		System.out.println(price);
		cart.setQuantity(quan);
		cart.setPrice(price);
		service.update(cart);
		List<Cart> list = service.getAll();
		System.out.println(list);
		model.addAttribute("list", list);
		return "home";
	}
	@RequestMapping("decrement")
	public String decrement(@RequestParam("cartid") String user_Id,Model model){

		Cart cart = service.getCartDetails(user_Id);
		System.out.println(cart);
		int quan=cart.getQuantity();
		if(quan>1)
		{

			int price=cart.getPrice();
			int newPrice = price/quan;
			quan=quan-1;
			price=newPrice*quan;
			System.out.println(quan);
			System.out.println(price);
			cart.setQuantity(quan);
			cart.setPrice(price);
			service.update(cart);
			List<Cart> list = service.getAll();
			System.out.println(list);
			model.addAttribute("list", list);
		}
		else
			service.delete(user_Id);
		List<Cart> list = service.getAll();
		System.out.println(list);
		model.addAttribute("list", list);
		return "home";
	}
}