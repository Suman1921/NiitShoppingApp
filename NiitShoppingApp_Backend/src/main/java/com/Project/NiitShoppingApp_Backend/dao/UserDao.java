package com.Project.NiitShoppingApp_Backend.dao;

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
	
	//update cart..
	boolean updateCart(Cart cart);

}
