package com.shopnow.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
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
	
	
	@RequestMapping(value="/validation")
	public ModelAndView springValidation(ModelMap modelMap ){
		modelMap.put("registrationForm", new RegistrationForm());
		return new ModelAndView("validationView");
	}
	
	@RequestMapping(value="/doValidation",method=RequestMethod.POST)
	public ModelAndView   doSpringValidation( @Validated @ModelAttribute("registrationForm ")  RegistrationForm registrationForm,
			BindingResult result,WebRequest webRequest ){
		System.out.println("doSpringValidation() - start");
		
		System.out.println("****************************************");
		System.out.println("registrationForm ::::::" +registrationForm.getFirstName());
		System.out.println("registrationForm ::::::" +registrationForm.getLastName());
		System.out.println("-----------------------------------------");
		
		for ( ObjectError error  : result.getAllErrors())
		{
			System.out.println(error.getDefaultMessage());
		}
		ModelAndView modelAndView = new ModelAndView();
		if(result.hasErrors()){
			System.out.println("doSpringValidation() - errors");
			modelAndView.addObject("registrationForm",registrationForm);
			modelAndView.setViewName("validationView");
			return modelAndView;
		}
		System.out.println("doSpringValidation() - end");
		modelAndView.addObject("registrationForm", new RegistrationForm());
		return  modelAndView;
	}
	
	
}
