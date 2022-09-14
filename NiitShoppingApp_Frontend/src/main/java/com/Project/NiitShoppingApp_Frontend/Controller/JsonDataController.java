package com.Project.NiitShoppingApp_Frontend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Project.NiitShoppingApp_Backend.dao.ProductDao;

@Controller
@RequestMapping("/json/data")
public class JsonDataController 
{
	@Autowired
	private ProductDao productDao;
	
	

}
