package com.Project.NiitShoppingApp_Frontend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Project.NiitShoppingApp_Backend.dao.CategoryDao;
import com.Project.NiitShoppingApp_Backend.dao.ProductDao;
import com.Project.NiitShoppingApp_Backend.dto.Category;
import com.Project.NiitShoppingApp_Backend.dto.Product;
import com.Project.NiitShoppingApp_Frontend.Exception.ProductNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class PageController 
{
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private ProductDao productDao;
	
	
	@RequestMapping(value = {"/" , "/index" , "/home"})
	public ModelAndView index()
	{
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("title" , "Home");
		
		logger.info("Inside PageController index method - INFO");
		logger.debug("Inside PageController index method - DEBUG");
		
		
		mv.addObject("categories" , categoryDao.list());
		
		mv.addObject("userClickHome" , true);
		return mv;
		
	}
	
	@RequestMapping(value = {"/about"})
	public ModelAndView about()
	{
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("title" , "About Us");
		mv.addObject("userClickAbout" , true);
		return mv;
		
	}
	
	@RequestMapping(value = {"/contact"})
	public ModelAndView contact()
	{
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("title" , "Contact Us");
		mv.addObject("userClickContact" , true);
		return mv;
		
	}
	
	
	@RequestMapping(value = {"/show/all/products"})
	public ModelAndView showAllProducts()
	{
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("title" , "All Products");
		mv.addObject("categories" , categoryDao.list());
		mv.addObject("userClickAllProducts" , true);
		return mv;
		
	}
	
	
	@RequestMapping(value = {"/show/category/{id}/products"})
	public ModelAndView showCategoryProducts(@PathVariable("id") int id)
	{
		ModelAndView mv = new ModelAndView("index");
		
		Category category = null;
		
		category = categoryDao.get(id);
		
		
		mv.addObject("title" , category.getCategoryName());
		mv.addObject("categories" , categoryDao.list());
		mv.addObject("category" , category);
		mv.addObject("userClickCategoryProducts" , true);
		return mv;
		
	}
	
	@RequestMapping(value = "/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFoundException
	{
		ModelAndView mv = new ModelAndView("index");
		
		Product product = productDao.get(id);
		
		if(product == null) throw new ProductNotFoundException();
		
		//update view content...
		product.setViews(product.getViews() + 1);
		productDao.update(product);
		
		
		mv.addObject("title" , product.getName());
		mv.addObject("product" , product);
		
		mv.addObject("userClickShowProduct" , true);
		
		return mv;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	/*
	@RequestMapping(value = {"/about"})
	public ModelAndView about(@RequestParam(value ="message" , required = false) String message)
	{
		if(message == null)
		{
			message = "Hello NIIT Kolkata.";
		}
		
		
		ModelAndView mv = new ModelAndView("about");
		mv.addObject("message" , message);
		return mv;
	}
	
	
	@RequestMapping(value = {"/about/{message}"})
	public ModelAndView about(@PathVariable("message") String message)
	{
		if(message == null)
		{
			message = "Hello NIIT Kolkata.";
		}
		
		
		ModelAndView mv = new ModelAndView("about");
		mv.addObject("message" , message);
		return mv;
	}
	*/
}
