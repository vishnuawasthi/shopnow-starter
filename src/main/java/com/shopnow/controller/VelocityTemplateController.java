package com.shopnow.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.velocity.VelocityEngineUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shopnow.dto.PersonDTO;

@Controller
public class VelocityTemplateController {

  
  @Autowired
  private VelocityEngine velocityEngine;
  
  @RequestMapping(value = "/")
  public ModelAndView showTempate() {
	ModelAndView modelAndView = new ModelAndView();
	PersonDTO personDTO = new PersonDTO();
	personDTO.setId(12000L);
	personDTO.setFirstName("Edward");
	personDTO.setLastName("Snowden");
	personDTO.setEmail("edward.snowden@americaninc.com");
	personDTO.setMobile("+91-9876543212");
	personDTO.setImageURL("resources/images/logo.gif");
	personDTO
	    .setDescription("Edward Joseph Snowden is a computer professional, former CIA employee, and former government contractor who copied classified information from the United States National Security Agency");
	personDTO.setAddressLine1("New York City");
	personDTO.setAddressLine2("United state of America");

	modelAndView.addObject("personDTO", personDTO);
	modelAndView.setViewName("template");

	Map<String,Object> map = new HashMap<String,Object>();
	
	map.put("name", "Vishnu Awasthi");
	map.put("address", "Hyderabad");
	
	System.out.println(VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "templates/mailTemplate.vm", "UTF-8", map));
	return modelAndView;
  }
}
