package com.shopnow.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.shopnow.form.RegistrationForm;

@Controller
public class UserController {
	
	private static final Logger log = Logger.getLogger(UserController.class);
	
	
	@RequestMapping(value="/registration")
	public ModelAndView registration(ModelMap modelMap){
		log.info("registration() - start");
		log.info("registration() - end");
		return new ModelAndView("registration", modelMap);
	}
	
	
	@RequestMapping(value="/doRegistration" ,method=RequestMethod.POST)
	public ModelAndView doRegistration(@RequestBody RegistrationForm registrationForm,ModelMap modelMap){
		log.info("doRegistration() - start");
		
		
		System.out.println("registrationForm  :  "+registrationForm.getFirstName());
		System.out.println("registrationForm  :  "+registrationForm.getTermsAndConditions());
		
		log.info("doRegistration() - end");
		return new ModelAndView("registration", modelMap);
	}
	
	
}
