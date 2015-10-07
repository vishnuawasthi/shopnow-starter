package com.shopnow.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shopnow.entity.Supplier;
import com.shopnow.security.service.EntitySearchService;
import com.shopnow.utils.SearchCriteria;
import com.shopnow.utils.ValidationUtils;

@RestController
public class SearchAutoCompleteController {
	
	@Autowired
	private EntitySearchService entitySearchService;

	@RequestMapping(value = "/rest/autoSearch", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
		
	public HttpEntity<List<String>> search() {
		System.out.println(" search() - start");
		List<String> searchValues = new ArrayList<String>();
		List<?> supplierList = entitySearchService.search(new SearchCriteria("name", "TST1","Supplier", Supplier.class));

		for (Object tempObject : ValidationUtils.nullSafe(supplierList)) {
			Supplier supplier = (Supplier) tempObject;
			searchValues.add(supplier.getName());
		}
		System.out.println(" search() - end");
		return new ResponseEntity<List<String>>(searchValues, HttpStatus.OK);

	}

}
