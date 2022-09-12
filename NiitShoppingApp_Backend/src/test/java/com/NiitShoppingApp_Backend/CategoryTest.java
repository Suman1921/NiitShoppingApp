package com.NiitShoppingApp_Backend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Project.NiitShoppingApp_Backend.dao.CategoryDao;
import com.Project.NiitShoppingApp_Backend.dto.Category;

public class CategoryTest 
{
	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDao categoryDao;
	
	private Category category;
	
	
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.Project.NiitShoppingApp_Backend");
		context.refresh();
		categoryDao = (CategoryDao)context.getBean("categoryDao");
	}
	
	/*
	@Test
	public void testAddCategory()
	{
		category = new Category();
		
		category.setCategoryName("Bluetooth Speaker");
		category.setCategoryDescription("This is some description for Bluetooth Speaker.");
		category.setActive(true);
		
		assertEquals("Successfully added category inside table!", true, categoryDao.add(category));
		
	}
	*/
	
	/*
	@Test
	public void testUpdateCategory()
	{
		category = categoryDao.get(1);
		category.setCategoryName("Telivision");
		
		assertEquals("Successfully updated category inside table!", true, categoryDao.update(category));
		
	}
	*/
	
	/*
	@Test
	public void testDeleteCategory()
	{
		category = categoryDao.get(1);
		
		
		assertEquals("Successfully updated category inside table!", true, categoryDao.delete(category));
		
	}
	*/
	
	@Test
	public void testFetchCategory()
	{
		
		assertEquals("Successfully Feched category inside table!", 3 , categoryDao.list().size());
	}
}
