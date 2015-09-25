package com.shopnow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ReadProductController {

	@RequestMapping(value="listproducts")
	public ModelAndView show(){
		return new ModelAndView("listproducts");
	}
	
}
