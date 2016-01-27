package com.shopnow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.shopnow.form.FilUploadForm;

@Controller
public class FileUploadController {

	@RequestMapping(value = "/file", method = RequestMethod.GET)
	public ModelAndView file() {
		System.out.println("file() -start");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("filUploadForm", new FilUploadForm());
		modelAndView.setViewName("springFileUpload");
		System.out.println("file() -end");
		return modelAndView;
	}

	@RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
	public ModelAndView fileUpload(@ModelAttribute("filUploadForm") FilUploadForm filUploadForm,
			BindingResult result) {
		System.out.println("fileUpload() -start");
		
		MultipartFile file = filUploadForm.getFile();
		
		System.out.println("Name  : "+file.getName());
		System.out.println("Original file name:  "+ file.getOriginalFilename());
		
		
		ModelAndView modelAndView = new ModelAndView();
		// modelAndView.addObject("filUploadForm", new FilUploadForm());
		modelAndView.setViewName("springFileUpload");
		System.out.println("fileUpload() -end");
		return modelAndView;
	}

}
