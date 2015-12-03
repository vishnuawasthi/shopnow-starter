package com.shopnow.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.shopnow.form.RegistrationForm;

@Controller
public class UserController {
	
	private static final Logger log = Logger.getLogger(UserController.class);
	
	/*@Autowired
	private RabbitTemplate rabbitTemplate;*/

	
	@RequestMapping(value="/registration")
	public ModelAndView registration(ModelMap modelMap){
		log.info("registration() - start");
		
		//rabbitTemplate.convertAndSend("shopnow-exchange", "shopnow-queue", "Shownow-Test");
		//shopnow-queue
		
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
		return new ModelAndView("test");
	}
	
	@RequestMapping(value="/doValidation",method=RequestMethod.POST)
	public ModelAndView   doValidation( @Valid @ModelAttribute("registrationForm")  RegistrationForm registrationForm,
			BindingResult result){
		System.out.println("doSpringValidation() - start");
		ModelAndView modelAndView = new ModelAndView();
		if(result.hasErrors()){
			System.out.println("doSpringValidation() - errors");
			modelAndView.addObject("registrationForm",registrationForm);
			modelAndView.setViewName("test");
			return modelAndView;
		}
		System.out.println("doSpringValidation() - end");
		modelAndView.addObject("registrationForm", new RegistrationForm());
		return  modelAndView;
	}
	
	
	@RequestMapping(value="/member")
	public ModelAndView showMember(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("memberForm", new RegistrationForm() );
		modelAndView.setViewName("member");
		return modelAndView;
	}
	
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public ModelAndView doMember(@Valid  @ModelAttribute("memberForm")RegistrationForm memberForm,BindingResult result ){
		ModelAndView modelAndView = new ModelAndView();
		if(result.hasErrors()){
			System.out.println("Errorsssssssssss::::::::::::");
			modelAndView.addObject("memberForm",memberForm );
			modelAndView.setViewName("member");
			return modelAndView;
		}
		modelAndView.addObject("memberForm", new RegistrationForm() );
		modelAndView.setViewName("member");
		return modelAndView;
	}
	
	
}
