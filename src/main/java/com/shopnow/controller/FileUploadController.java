package com.shopnow.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.shopnow.form.FilUploadForm;
import com.shopnow.utils.FileUploadUtils;

@Controller
public class FileUploadController {
	@Autowired
	private FileUploadUtils  fileUploadUtils ;
	
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
			BindingResult result,HttpServletRequest request) {
		System.out.println("fileUpload() -start");
		MultipartFile file = filUploadForm.getFile();
		try {
			System.out.println("Name  : "+file.getName());
			System.out.println("Original file name:  "+ file.getOriginalFilename());
			String fileName  =	fileUploadUtils.createFile(file, request,"IMAGE");
			System.out.println("fileName   : "+fileName);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ModelAndView modelAndView = new ModelAndView();
		// modelAndView.addObject("filUploadForm", new FilUploadForm());
		modelAndView.setViewName("springFileUpload");
		System.out.println("fileUpload() -end");
		return modelAndView;
	}

}
