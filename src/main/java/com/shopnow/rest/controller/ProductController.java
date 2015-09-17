/**
 * 
 */
package com.shopnow.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shopnow.assembler.ProductsAssembler;
import com.shopnow.form.Products;
import com.shopnow.resource.ProductResource;

/**
 * @author Vishnu Awasthi
 *
 */
@RestController
public class ProductController {

	@Autowired
	private ProductsAssembler assembler;
	
	@RequestMapping(value = "/getProducts",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public  HttpEntity<List<ProductResource>> getProducts() {
		return new ResponseEntity<List<ProductResource>>(  assembler.toResources( getProductList())    ,HttpStatus.OK);
				
	}

	@RequestMapping(value = "/{id}",method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public HttpEntity<ProductResource> getOneProducts(
			@PathVariable(value="id") Long id)
	{
		
		List<Products> list =getProductList();
		Products tempProducts = null;
		for(Products products : list) {
			if(products.getId().equals(id)) {
				tempProducts =products;
			}
		}
		return new ResponseEntity<ProductResource>(assembler.toResource(tempProducts) ,HttpStatus.OK);
				
	}

	private List<Products> getProductList() {
		List<Products> list = new ArrayList<>();
		Products products1 = new Products(10L, "LUX", "20");
		Products products2 = new Products(11L, "LUX", "20");
		Products products3 = new Products(12L, "LUX", "20");
		Products products4 = new Products(14L, "LUX", "20");

		list.add(products1);
		list.add(products2);
		list.add(products3);
		list.add(products4);
		return list;

	}
}
