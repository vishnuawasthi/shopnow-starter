package com.shopnow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HibernateFilterExampleController {
	
	
	
	
	@RequestMapping(value = "/hiberanteFilter", method = RequestMethod.GET)
	public ModelAndView hiberanteFilter() {
		System.out.println("hiberanteFilter() -start");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("hibernateFilter");
		System.out.println("hiberanteFilter() -end");
		return modelAndView;
	}
	//jspTagExample
	
	
	@RequestMapping(value = "/jspTagExample", method = RequestMethod.GET)
	public ModelAndView jspTagExample() {
		System.out.println("jspTagExample() -start");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("jspTagExample");
		System.out.println("jspTagExample() -end");
		return modelAndView;
	}
}
