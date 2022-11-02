package com.Project.NiitShoppingApp_Frontend.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import com.Project.NiitShoppingApp_Backend.dao.UserDao;
import com.Project.NiitShoppingApp_Backend.dto.Address;
import com.Project.NiitShoppingApp_Backend.dto.Cart;
import com.Project.NiitShoppingApp_Backend.dto.User;
import com.Project.NiitShoppingApp_Frontend.model.RegisterModel;

@Component("registerHandler")
public class RegisterHandler 
{
	@Autowired
	private UserDao userDao;
	
	
	public RegisterModel init()
	{
		return new RegisterModel();
	}
	
	public void addUser(RegisterModel registerModel , User user)
	{
		registerModel.setUser(user);
	}
	
	public void addBilling(RegisterModel registerModel , Address billing)
	{
		registerModel.setBilling(billing);
	}
	
	public String validateUser(User user, MessageContext error)
	{
		String transitionValue = "success";
		
		if(!(user.getPassword().equals(user.getConfirmPassword())))
		{
			error.addMessage(new MessageBuilder()
					.error().
					source("confirmPassword")
					.defaultText("Password does not match the confirm password.")
					.build());
			transitionValue = "failure";
			
		}
		
		if(userDao.getByEmail(user.getEmail())!=null)
		{
			error.addMessage(new MessageBuilder()
					.error().
					source("email")
					.defaultText("This email id already exists.")
					.build());
			transitionValue = "failure";
			
		}
		return transitionValue;
		
	}
	
	
	
	
	
	public String saveAll(RegisterModel model)
	{
		String transitionValue = "success";
		
		User user = model.getUser();
		
		if(user.getRole().equals("USER"))
		{
			Cart cart = new Cart();
			cart.setUser(user);
			user.setCart(cart);
		}
		
		userDao.addUser(user);
		
		Address billing = model.getBilling();
		billing.setUserId(user.getId());
		billing.setBilling(true);
		
		userDao.addAddress(billing);
		
		return transitionValue;
		
	}
	
	
	

}
