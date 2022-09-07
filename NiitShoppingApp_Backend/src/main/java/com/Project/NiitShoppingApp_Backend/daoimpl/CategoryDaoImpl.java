package com.Project.NiitShoppingApp_Backend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Project.NiitShoppingApp_Backend.dao.CategoryDao;
import com.Project.NiitShoppingApp_Backend.dto.Category;

@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao
{
	@Autowired
	private SessionFactory sessionFactory;
	
	private static List<Category> categories = new ArrayList<Category>();
	
	static
	{
		Category category = new Category();
		
		category.setCategoryId(1);
		category.setCategoryName("Television");
		category.setCategoryDescription("This is Television Category.");
		
		categories.add(category);
		
		
		category = new Category();
		
		category.setCategoryId(2);
		category.setCategoryName("Mobile");
		category.setCategoryDescription("This is Mobile Category.");
		
		categories.add(category);
		
		
		category = new Category();
		
		category.setCategoryId(3);
		category.setCategoryName("Laptop");
		category.setCategoryDescription("This is Laptop Category.");
		
		categories.add(category);
		
		
		category = new Category();
		
		category.setCategoryId(4);
		category.setCategoryName("T-Shirt");
		category.setCategoryDescription("This is T-Shirt Category.");
		
		categories.add(category);
	}
	
	
	
	public List<Category> list()
	{
		return categories;
	}
	
	
	public Category get(int id)
	{
		for(Category category : categories)
		{
			if(category.getCategoryId() == id) return category;
		}
		
		return null;
	}
	
	
	@Transactional
	public boolean add(Category category) 
	{
		try
		{
			sessionFactory.getCurrentSession().persist(category);
			return true;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
		
		
	}

}
