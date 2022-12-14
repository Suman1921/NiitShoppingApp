package com.Project.NiitShoppingApp_Frontend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Project.NiitShoppingApp_Backend.dao.ProductDao;
import com.Project.NiitShoppingApp_Backend.dto.Product;

@Controller
@RequestMapping("/json/data")
public class JsonDataController 
{
	@Autowired
	private ProductDao productDao;
	
	@RequestMapping("/all/products")
	@ResponseBody
	public List<Product> getAllProducts()
	{
		return productDao.listActiveProducts();
	}
	
	@RequestMapping("/admin/all/products")
	@ResponseBody
	public List<Product> getAllProductsForAdmin()
	{
		return productDao.list();
	}
	
	
	@RequestMapping("/category/{id}/products")
	@ResponseBody
	public List<Product> getAllCategoryProducts(@PathVariable int id)
	{
		return productDao.listActiveProductsByCategory(id);
	}
	

}
