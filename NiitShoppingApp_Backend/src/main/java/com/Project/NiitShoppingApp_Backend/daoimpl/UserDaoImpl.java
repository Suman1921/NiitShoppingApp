package com.Project.NiitShoppingApp_Backend.daoimpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Project.NiitShoppingApp_Backend.dao.UserDao;
import com.Project.NiitShoppingApp_Backend.dto.Address;
import com.Project.NiitShoppingApp_Backend.dto.Cart;
import com.Project.NiitShoppingApp_Backend.dto.User;

@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao 
{
	@Autowired
	private SessionFactory sessionFactory;

	public boolean addUser(User user) 
	{
		try 
		{
			sessionFactory.getCurrentSession().persist(user); 
			return true;
		}
		catch(Exception e )
		{
			e.printStackTrace();

		}
		return false;
	}

	public boolean addAddress(Address address) 
	{
		try 
		{
			sessionFactory.getCurrentSession().persist(address); 
			return true;
		}
		catch(Exception e )
		{
			e.printStackTrace();

		}
		return false;
	}

	public boolean addCart(Cart cart) 
	{
		try 
		{
			sessionFactory.getCurrentSession().persist(cart); 
			return true;
		}
		catch(Exception e )
		{
			e.printStackTrace();

		}
		return false;
	}

	public User getByEmail(String email) 
	{
		String selectQuery = "FROM User WHERE email = :email";
		
		try 
		{
			return sessionFactory.getCurrentSession()
					.createQuery(selectQuery, User.class)
					.setParameter("email", email)
					.getSingleResult();
			
			
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return null;
		}
	}

	public boolean updateCart(Cart cart) 
	{
		try 
		{
			sessionFactory.getCurrentSession().update(cart); 
			return true;
		}
		catch(Exception e )
		{
			e.printStackTrace();

		}
		return false;
	}

}
