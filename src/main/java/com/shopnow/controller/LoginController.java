/**
 * 
 */
package com.shopnow.controller;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shopnow.service.EmailService;
import com.shopnow.service.LoginService;

/**
 * @author vawasthi
 *
 */
@Controller
public class LoginController {
	private static final Logger log = Logger.getLogger(LoginController.class);
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private EmailService emailService;
	
	@RequestMapping(value="/home",method=RequestMethod.GET,produces=MediaType.TEXT_HTML_VALUE)
	public ModelAndView home(ModelMap modelMap){
		log.info("home() -start ");
		
		Set <String> toList = new HashSet<String>();
		Set <String> ccList = new HashSet<String>();
		Set <String> bccList = new HashSet<String>();
		
		toList.add("vishnu.awasthi@valuelabs.com");
		toList.add("vishnu.awasthi@valuelabs.net");
		toList.add("vishnuawasthi121@gmail.com");
		
		
		emailService.sendEmail("vishnu.awasthi@valuelabs.com", "TEST-EMAIL", toList, ccList, bccList, "Hello <br/> This is an test email");
		ModelAndView modelAndView = new ModelAndView();
		log.info("home() -end ");
		return new ModelAndView("header",modelMap);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout,ModelMap modelMap) {
		log.info("login() - start");
		if (error != null) {
			modelMap.put("error", "Invalid username and password!");
		}
		if (logout != null) {
			modelMap.put("msg","You've been logged out successfully.");
		}
		log.info("login() - end");
		return new ModelAndView("login", modelMap);
	}
	
	@RequestMapping(value="/403")
	public ModelAndView accessDenied(ModelMap modelMap){
		log.info("accessDenied() - start");
		modelMap.put("AccessDenied ", "Sorry,You don't have previliges to access this content");
		log.info("accessDenied() - end");
		return new ModelAndView("403", modelMap);
	}
}
