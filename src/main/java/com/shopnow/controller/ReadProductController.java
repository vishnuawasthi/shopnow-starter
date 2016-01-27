package com.shopnow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ReadProductController {

	@RequestMapping(value="/listproducts")
	public ModelAndView show(){
		return new ModelAndView("listproducts");
	}
	
	
	@RequestMapping(value="/angualarjsEx1")
	public ModelAndView angualarjsEx1(){
		return new ModelAndView("angualarjsEx1");
	}
	//autocomplete.jsp
	
	@RequestMapping(value="/autocomplete")
	public ModelAndView autocomplete(@RequestParam (value="countryName" ,required=false) String countryName) {
		System.out.println("countryName:::::::::::::   "+countryName);
		
		
	
		
		return new ModelAndView("autocomplete");
	}
	
}
