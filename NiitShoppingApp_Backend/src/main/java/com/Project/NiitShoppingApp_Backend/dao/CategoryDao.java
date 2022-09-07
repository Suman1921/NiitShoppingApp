package com.Project.NiitShoppingApp_Backend.dao;

import java.util.List;

import com.Project.NiitShoppingApp_Backend.dto.Category;

public interface CategoryDao 
{
	List<Category> list();
	Category get(int id);
	boolean add(Category category);
}
