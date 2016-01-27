/**
 * 
 */
package com.shopnow.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shopnow.dto.Book;
import com.shopnow.dto.Test;
import com.shopnow.exception.ExceptionBean;
import com.shopnow.form.UserForm;
import com.shopnow.rest.support.ShopnowRestClient;

/**
 * @author vawasthi
 *
 */

@Controller
public class RedirectFlashAttributeExampleController {

	@Autowired
	private ShopnowRestClient restClient;
	
	//@Autowired 
	//PDFBuilder pdfBuilder;
	
	@RequestMapping(value = "/redirect")
	public ModelAndView show() {
		System.out.println("show() - start");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirectForm");

		// int a = 10/0;

		String response = restClient.get("http://services.groupkt.com/country/get/all",
				new HashMap<String, String>());

		System.out.println("response   : " + response);

		Test dto = (Test) restClient.jsonToObject(response.toString(), Test.class);

		// System.out.println("dto  :::::::::: "+dto);

		// System.out.println("response  :  "+response);

		System.out.println("dto   " + dto);
		// modelAndView.addObject("userForm", new UserForm());
		System.out.println("show() - end");
		return modelAndView;
	}

	@RequestMapping(value = "/errorRenderer")
	public ModelAndView errorRenderer(@ModelAttribute("model") ExceptionBean exceptionBean) {
		System.out.println("showErrorPage()  -start");
		ModelAndView modelAndView = new ModelAndView();
		System.out.println("exceptionBean::::::::::   " + exceptionBean);
		System.out.println("errorRenderer()  -end");
		return modelAndView;
	}

	@RequestMapping(value = "/redirect1")
	public ModelAndView redirect1(final RedirectAttributes redirectAttributes) {
		System.out.println("redirect1() -start");
		ModelAndView modelAndView = new ModelAndView();
		UserForm userForm = new UserForm(10L, "Vishnu ", "Awasthi", "admin", "Secure*123",
				"admin@testmail.com");
		System.out.println("redirect1()  - userForm : " + userForm);
		redirectAttributes.addFlashAttribute("message", "values Has been received..!");
		redirectAttributes.addFlashAttribute("valueinFlash", userForm);
		modelAndView.setViewName("redirect:redirect2");
		System.out.println("redirect1() - end");
		return modelAndView;
	}

	@RequestMapping(value = "/redirect2")
	public ModelAndView redirect2(@ModelAttribute("valueinFlash") UserForm userForm,
			@ModelAttribute("message") String message) {
		System.out.println("redirect2() - start");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("flashValueReceiver");
		System.out.println("userForm  :  " + userForm);
		System.out.println(" message:  " + message);
		modelAndView.addObject("flashValue", userForm);
		modelAndView.addObject("message", message);
		modelAndView.setViewName("flashValueReceiver");
		System.out.println("redirect2() - end");
		return modelAndView;
	}

	@RequestMapping(value = "/getNames", method = RequestMethod.GET)
	public @ResponseBody List<String> getNames() {
		List<String> nameList = new ArrayList<String>();
		nameList.add("Vishnu");
		nameList.add("Ravi");
		nameList.add("Sonu");
		nameList.add("Kamal");
		return nameList;
	}

	@RequestMapping(value = "/pdf", method = RequestMethod.GET)
	public ModelAndView  writePDF(HttpServletRequest request,HttpServletResponse response) {
		 // create some sample data
		System.out.println("writePDF() - start ");
        List<Book> listBooks = new ArrayList<Book>();
        listBooks.add(new Book("Spring in Action", "Craig Walls", "1935182358",
                "June 29th 2011", 31.98F));
        listBooks.add(new Book("Spring in Practice", "Willie Wheeler, Joshua White",
                "1935182056", "May 16th 2013", 31.95F));
        listBooks.add(new Book("Pro Spring 3",
                "Clarence Ho, Rob Harrop", "1430241071", "April 18th 2012", 31.85F));
        listBooks.add(new Book("Spring Integration in Action", "Mark Fisher", "1935182439",
                "September 26th 2012", 28.73F));
        response.setContentType("application/pdf");
        
        // return a view which will be resolved by an excel view resolver
        System.out.println("writePDF() - end ");
        return new ModelAndView("pdfView", "listBooks", listBooks);
	}

}
