package com.cg.capstore.dto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cart")
public class Cart {

	@Id
	@Column(name="user_Id")
	private String user_Id;
	
	private String prod_Id;
	
	private int price;
	
	private int quantity;

	public String getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(String user_Id) {
		this.user_Id = user_Id;
	}

	public String getProd_Id() {
		return prod_Id;
	}

	public void setProd_Id(String prod_Id) {
		this.prod_Id = prod_Id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price2) {
		this.price = price2;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Cart(String user_Id, String prod_Id, int price, int quantity) {
		super();
		this.user_Id = user_Id;
		this.prod_Id = prod_Id;
		this.price = price;
		this.quantity = quantity;
	}

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Cart [user_Id=" + user_Id + ", prod_Id=" + prod_Id + ", price="
				+ price + ", quantity=" + quantity + "]";
	}

	
}
