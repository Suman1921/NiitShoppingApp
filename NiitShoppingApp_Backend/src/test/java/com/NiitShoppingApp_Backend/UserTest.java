package com.NiitShoppingApp_Backend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Project.NiitShoppingApp_Backend.dao.CategoryDao;
import com.Project.NiitShoppingApp_Backend.dao.UserDao;
import com.Project.NiitShoppingApp_Backend.dto.Address;
import com.Project.NiitShoppingApp_Backend.dto.Cart;
import com.Project.NiitShoppingApp_Backend.dto.User;

public class UserTest 
{
	private static AnnotationConfigApplicationContext context;
	private static UserDao userDao;
	private User user = null;
	private Cart cart = null;
	private Address address = null;
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.Project.NiitShoppingApp_Backend");
		context.refresh();
		userDao = (UserDao)context.getBean("userDao");
	}
	
	
	@Test
	public void testAdd()
	{
		user = new User();
		user.setFirstName("Hrithik");
		user.setLastName("Roshan");
		user.setEmail("hr@gmail.com");
		user.setContactNumber("8998776655");
		user.setRole("USER");
		user.setPassword("Rs@123");
		
		//add the user
		assertEquals("Failed to add user!", true, userDao.addUser(user));
		
		
		address = new Address();
		address.setAddressLineOne("12/B Harish Chandra Street");
		address.setAddressLineTwo("Near Bhawanipur thana.");
		address.setCity("Kolkata");
		address.setState("West Bengal");
		address.setCountry("India");
		address.setPostalCode("700041");
		address.setBilling(true);
		address.setUserId(user.getId());
		
		//add the user
		assertEquals("Failed to add address!", true, userDao.addAddress(address));
		
		
		if(user.getRole().equals("USER")) 
		{
			
			cart = new Cart();
			
			cart.setUser(user);
			
			
			cart.setGrandTotal(5612.89);
			
			
			//add the cart
			assertEquals("Failed to add cart!", true, userDao.addCart(cart));
			
				
		}
		
		
		
	}
	
	
}
