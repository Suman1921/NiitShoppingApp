package com.Project.NiitShoppingApp_Backend.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="NiitShoppingApp_Cart")
public class Cart implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne
	private User user;
	

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	private double grandTotal;
	private int cartlines;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public double getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}
	public int getCartlines() {
		return cartlines;
	}
	public void setCartlines(int cartlines) {
		this.cartlines = cartlines;
	}
	
	public Cart() {
		super();
	}
	
	@Override
	public String toString() {
		return "Cart [id=" + id + ", user=" + user + ", grandTotal=" + grandTotal + ", cartlines=" + cartlines + "]";
	}
	public Cart(int id, User user, double grandTotal, int cartlines) {
		super();
		this.id = id;
		this.user = user;
		this.grandTotal = grandTotal;
		this.cartlines = cartlines;
	}
	
	
	

}
