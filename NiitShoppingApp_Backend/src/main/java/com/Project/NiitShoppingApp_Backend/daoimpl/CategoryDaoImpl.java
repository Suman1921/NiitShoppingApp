package com.Project.NiitShoppingApp_Backend.daoimpl;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Project.NiitShoppingApp_Backend.dao.CategoryDao;
import com.Project.NiitShoppingApp_Backend.dto.Category;

@Repository("categoryDao")
@Transactional
public class CategoryDaoImpl implements CategoryDao
{
	@Autowired
	private SessionFactory sessionFactory;
	

	public List<Category> list()
	{
		String selectActiveCategory = "FROM Category WHERE active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		
		query.setParameter("active", true);
		
		return query.getResultList();
		
		
	}
	
	
	public Category get(int id)
	{
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}
	
	
	@Transactional
	public boolean add(Category category) 
	{
		try
		{
			category.setActive(true);
			sessionFactory.getCurrentSession().persist(category);
			return true;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
		
		
	}


	public boolean update(Category category) 
	{
		try
		{
			sessionFactory.getCurrentSession().update(category);
			return true;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	}


	public boolean delete(Category category) 
	{
		category.setActive(false);
		
		try
		{
			sessionFactory.getCurrentSession().update(category);
			return true;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	}

}
