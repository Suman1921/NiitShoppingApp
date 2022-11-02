package com.Project.NiitShoppingApp_Backend.dao;

import java.util.List;

import com.Project.NiitShoppingApp_Backend.dto.Address;
import com.Project.NiitShoppingApp_Backend.dto.Cart;
import com.Project.NiitShoppingApp_Backend.dto.User;

public interface UserDao 
{
	//add user..
	boolean addUser(User user);
	User getByEmail(String email);
	
	//add address..
	boolean addAddress(Address address);
	
	//add cart..
	boolean addCart(Cart cart);
	
	Address getBillingAddress(User user);
	List<Address> listShippingAddress(User user);
	
	//update cart..
	boolean updateCart(Cart cart);

}
