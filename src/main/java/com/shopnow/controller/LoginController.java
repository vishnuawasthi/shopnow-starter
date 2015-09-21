/**
 * 
 */
package com.shopnow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shopnow.service.LoginService;

/**
 * @author vawasthi
 *
 */
@Controller
public class LoginController {

	@Autowired
	//private LoginJpaRepository loginRepository;
	
	private LoginService loginService;
	
	
	@RequestMapping(value="/home",method=RequestMethod.GET,produces=MediaType.TEXT_HTML_VALUE)
	public ModelAndView home(ModelMap modelMap){
		System.out.println("home() -start ");
		System.out.println("home() -end ");
		return new ModelAndView("header",modelMap);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout,ModelMap modelMap) {
		if (error != null) {
			modelMap.put("error", "Invalid username and password!");
		}
		if (logout != null) {
			modelMap.put("msg","You've been logged out successfully.");
		}
		return new ModelAndView("login", modelMap);
	}
	
	@RequestMapping(value="/403")
	public ModelAndView accessDenied(ModelMap modelMap){
		modelMap.put("AccessDenied ", "Sorry,You don't have previliges to access this content");
		return new ModelAndView("403", modelMap);
	}
}
