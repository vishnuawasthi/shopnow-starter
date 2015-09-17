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
import org.springframework.web.servlet.ModelAndView;

import com.shopnow.form.UserForm;
import com.shopnow.service.LoginService;

/**
 * @author vawasthi
 *
 */
@Controller
//@Transactional
@RequestMapping(value="/login")
public class LoginController {

	@Autowired
	//private LoginJpaRepository loginRepository;
	
	private LoginService loginService;
	
	
	@RequestMapping(method=RequestMethod.GET,produces=MediaType.TEXT_HTML_VALUE)
	public ModelAndView login(ModelMap modelMap){
		System.out.println("login() -start ");
		//loginService.create(new UserForm(null, "vishnu", "awasthi", "admin", "root", "vishnu.awasthi@valuelabs.net"));
		return new ModelAndView("login",modelMap);
	}
	
	
}
