package com.shopnow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shopnow.dto.JpaSampleDTO;
import com.shopnow.service.JpaSampleSearchService;


@Controller
public class JpaSampleSearchController {

	
	@Autowired
	private JpaSampleSearchService jpaSampleSearchService;
	
	@RequestMapping(value = "/jpaSearch", method = RequestMethod.GET)
	public ModelAndView jpaSearchFilter(@RequestParam(value="firstName",required=false)String firstName,@RequestParam(value="lastName",required=false)String lastName) {
		System.out.println("jpaSearchFilter() -start");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("jpaSearchFilter");
		
		List<JpaSampleDTO> dtoList = jpaSampleSearchService.findByFirstName(firstName);
		
		modelAndView.addObject("dtoList", dtoList);
		System.out.println("jpaSearchFilter() -end");
		return modelAndView;
	}
	
}
