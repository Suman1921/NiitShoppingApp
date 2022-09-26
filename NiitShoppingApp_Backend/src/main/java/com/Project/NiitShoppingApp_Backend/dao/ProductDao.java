package com.Project.NiitShoppingApp_Backend.dao;

import java.util.List;

import com.Project.NiitShoppingApp_Backend.dto.Category;
import com.Project.NiitShoppingApp_Backend.dto.Product;

public interface ProductDao 
{
	Product get(int productId);
	List<Product> list();
	boolean add(Product product);
	boolean update(Product product);
	boolean delete(Product product);
	
	//buisness method...
	
	List<Product> listActiveProducts();
	List<Product> listActiveProductsByCategory(int categoryId);
	List<Product> getLatestActiveProducts(int count);
	

}
