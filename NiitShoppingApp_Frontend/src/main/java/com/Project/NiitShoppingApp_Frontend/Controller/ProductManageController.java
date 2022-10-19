package com.Project.NiitShoppingApp_Frontend.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.Project.NiitShoppingApp_Backend.dao.CategoryDao;
import com.Project.NiitShoppingApp_Backend.dao.ProductDao;
import com.Project.NiitShoppingApp_Backend.dto.Category;
import com.Project.NiitShoppingApp_Backend.dto.Product;
import com.Project.NiitShoppingApp_Frontend.Util.FileUploadUtility;
import com.Project.NiitShoppingApp_Frontend.Validator.ProductValidator;

@Controller
@RequestMapping("/manage")
public class ProductManageController 
{
	
	private static final Logger logger = LoggerFactory.getLogger(ProductManageController.class);
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private ProductDao productDao;
	
	
	
	@RequestMapping(value = "/products" , method = RequestMethod.GET)
	public ModelAndView showManageProducts(@RequestParam(name="operation" , required=false) String operation)
	{
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("userClickManageProducts" , true);
		mv.addObject("title" , "Manage Products");
		
		Product nProduct = new Product();
		
		//set few fields..
		
		nProduct.setSupplier_id(1);
		nProduct.setIs_active(true);
		
		mv.addObject("product" , nProduct);
		
		if(operation != null)
		{
			if(operation.equals("product"))
			{
				mv.addObject("message" , "Product Submitted Successfully.");
			}
			else if(operation.equals("category"))
			{
				mv.addObject("message" , "Category Submitted Successfully.");
			}
		}
		
		
		return mv;
	}
	
	@RequestMapping(value = "/{id}/product")
	public ModelAndView showEditProduct(@PathVariable int id)
	{
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("userClickManageProducts" , true);
		mv.addObject("title" , "Manage Products");
		
		Product nProduct = productDao.get(id);
		
		mv.addObject("product" , nProduct);
		
		return mv;
		
		
		
	}
	
	
	
	
	
	@RequestMapping(value = "/submit/product" , method = RequestMethod.POST)
	public String handelProductSubmission(@Valid @ModelAttribute("product") Product mProduct , BindingResult results , Model model , HttpServletRequest request)
	{
		
		if(mProduct.getId() == 0)
		{
			new ProductValidator().validate(mProduct, results);
		}
		else
		{
			if(!mProduct.getFile().getOriginalFilename().equals(""))
			{
				new ProductValidator().validate(mProduct, results);
			}
		}
		
		if(results.hasErrors())
		{
			model.addAttribute("userClickManageProducts" , true);
			model.addAttribute("title" , "Manage Products");
			
			return "index";
		}
		
		logger.info(mProduct.toString());
		
		if(mProduct.getId() == 0)
		{
			productDao.add(mProduct);
		}
		else
		{
			productDao.update(mProduct);
		}
		
		
		if(!mProduct.getFile().getOriginalFilename().equals(""))
		{
			FileUploadUtility.uploadFile(request , mProduct.getFile(), mProduct.getCode());
		}
		
		
		
		return "redirect:/manage/products?operation=product";
	}
	
	

	@RequestMapping(value = "/product/{id}/activation" , method = RequestMethod.GET)
	@ResponseBody
	public String handelProductActivation(@PathVariable int id)
	{
		Product product = productDao.get(id);
		boolean isActive = product.isIs_active();
		
		product.setIs_active(!product.isIs_active());
		
		productDao.update(product);
		
		return (isActive)?
				"You have Successfully deactivated the product with id "+ product.getId()
				: "You have Successfully active the product with id "+ product.getId();
		
		
	}
	
	@RequestMapping(value = "/category" , method = RequestMethod.POST)
	public String handelCategorySubmission(@ModelAttribute Category category)
	{
		categoryDao.add(category);
		
		return "redirect:/manage/products?operation=category";
	}
	
	@ModelAttribute("categories")
	public List<Category> getCategories()
	{
		return categoryDao.list();
	}
	
	@ModelAttribute("category")
	public Category getCategory()
	{
		return new Category();
	}
	

}
