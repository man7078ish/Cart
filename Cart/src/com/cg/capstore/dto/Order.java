package com.cg.capstore.dto;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;


	@Entity
	
	@Table(name="order_details")
	
	public class Order {

	    @Column(name="user_id")
	    private String userId;
	    
	    @Column(name="payment_id")
	    private String paymentId;
	    
	    @Column(name="coupon_code")
	    private String couponCode;
	    
	    public String getCouponCode() {
	        return couponCode;
	    }

	    public void setCouponCode(String couponCode) {
	        this.couponCode = couponCode;
	    }

	    @Id
	   // @GeneratedValue(strategy=GenerationType.AUTO)
	    @Column(name="order_id")
	    private String orderId;
	    
	    @Column(name="order_status")
	    private String orderStatus;
	    
	    @Column(name="order_date")
	    private String orderDate;
	    
	    @Column(name="total_price")
	    private double totalPrice;

	    public String getUserId() {
	        return userId;
	    }

	    public void setUserId(String userId) {
	        this.userId = userId;
	    }

	    public String getPaymentId() {
	        return paymentId;
	    }

	    public void setPaymentId(String paymentId) {
	        this.paymentId = paymentId;
	    }

	    public String getOrderId() {
	        return orderId;
	    }

	    public void setOrderId(String orderId) {
	        this.orderId = orderId;
	    }

	    public String getOrderStatus() {
	        return orderStatus;
	    }

	    public void setOrderStatus(String orderStatus) {
	        this.orderStatus = orderStatus;
	    }

	    public String getOrderDate() {
	        return orderDate;
	    }

	    public void setOrderDate(String orderDate) {
	        this.orderDate = orderDate;
	    }

	    public double getTotalPrice() {
	        return totalPrice;
	    }

	    public void setTotalPrice(double totalPrice) {
	        this.totalPrice = totalPrice;
	    }

	    

	    public Order(String userId, String paymentId, String couponCode,
	            String orderId, String orderStatus, String orderDate,
	            double totalPrice) {
	        super();
	        this.userId = userId;
	        this.paymentId = paymentId;
	        this.couponCode = couponCode;
	        this.orderId = orderId;
	        this.orderStatus = orderStatus;
	        this.orderDate = orderDate;
	        this.totalPrice = totalPrice;
	    }

	    public Order() {
	        super();
	    }
	    
	    
	    @PrePersist
	    private void ensureId(){
	        this.setOrderId(UUID.randomUUID().toString());
	    }
	}



