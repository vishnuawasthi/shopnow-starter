package com.shopnow.controller;

import javax.servlet.http.HttpServletRequest;

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
	
	@RequestMapping(value = "/ipaddress", method = RequestMethod.GET)
	public ModelAndView readIPAddress(HttpServletRequest request,HttpServletRequest response) {
		System.out.println("readIPAddress() -start");
		
		System.out.println("Remote host    : "+request.getRemoteHost());
		System.out.println("Remote Address :"+request.getRemoteAddr());
		
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("jspTagExample");
		modelAndView.addObject("remoteHost", request.getRemoteHost());
		modelAndView.addObject("remotaddress",request.getRemoteAddr());
		System.out.println("readIPAddress() -end");
		return modelAndView;
	}
	
	
	
}
