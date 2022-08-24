package com.Project.NiitShoppingApp_Frontend.Controller;

import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController 
{
	@RequestMapping(value = {"/" , "/index"})
	public ModelAndView index()
	{
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("message" , "This is my Ecommerce Project.");
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
