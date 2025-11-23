package com.zubairy.crs.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Booking {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int userId;

    @ElementCollection
    private List<Long> cartItems;

    private LocalDate fromDate;
    private LocalDate toDate;

    private int days;
    private double totalAmount;
    private String paymentMode;

	public String email;
    
    public Booking() {
	}
    
    
	public Booking(Long id, int userId, List<Long> cartItems, LocalDate fromDate, LocalDate toDate, int days,
			double totalAmount, String paymentMode, String email) {
		super();
		this.id = id;
		this.userId = userId;
		this.cartItems = cartItems;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.days = days;
		this.totalAmount = totalAmount;
		this.paymentMode = paymentMode;
		this.email = email;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public List<Long> getCartItems() {
		return cartItems;
	}


	public void setCartItems(List<Long> cartItems) {
		this.cartItems = cartItems;
	}


	public LocalDate getFromDate() {
		return fromDate;
	}


	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}


	public LocalDate getToDate() {
		return toDate;
	}


	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}


	public int getDays() {
		return days;
	}


	public void setDays(int days) {
		this.days = days;
	}


	public double getTotalAmount() {
		return totalAmount;
	}


	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}


	public String getPaymentMode() {
		return paymentMode;
	}


	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	
	


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "Booking [id=" + id + ", userId=" + userId + ", cartItems=" + cartItems + ", fromDate=" + fromDate
				+ ", toDate=" + toDate + ", days=" + days + ", totalAmount=" + totalAmount + ", paymentMode="
				+ paymentMode + "]";
	}
    
    

}
