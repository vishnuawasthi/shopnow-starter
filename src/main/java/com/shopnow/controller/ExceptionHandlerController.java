package com.shopnow.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import com.shopnow.exception.ExceptionBean;

@ControllerAdvice
public class ExceptionHandlerController {

	@ExceptionHandler(value = ArithmeticException.class )
	public ModelAndView errorPage(ArithmeticException exception) {
		System.out.println("errorPage()  -start");
		ModelAndView modelAndView = new ModelAndView();
		RedirectAttributes redirectAttributes = new RedirectAttributesModelMap();
		redirectAttributes.addFlashAttribute("errorCode", "500");
		ExceptionBean bean = new ExceptionBean("500", exception.getMessage(), exception.toString());
		redirectAttributes.addFlashAttribute("model", bean);
		modelAndView.setViewName("redirect:errorRenderer");
		System.out.println("errorPage()  -end");
		return modelAndView;
	}

	

}
