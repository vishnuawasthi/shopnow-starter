package com.shopnow.assembler;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.shopnow.form.Products;
import com.shopnow.resource.ProductResource;
import com.shopnow.rest.controller.ProductController;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@Service
public class ProductsAssembler extends ResourceAssemblerSupport<Products,ProductResource> {

	public ProductsAssembler() {
		super(ProductController.class, ProductResource.class);
	}

	@Override
	public ProductResource toResource(Products product) {
		System.out.println("product ::::::::::::::"+product);
		
		 ProductResource resource = new ProductResource();
		 if(!StringUtils.isEmpty(product)){
			 resource.setProductId(product.getId());
			 resource.setProductName(product.getProductName());
			 resource.setPrice(product.getPrice());
			 resource.add(linkTo(methodOn(ProductController.class).getOneProducts(product.getId())).withSelfRel());
		 }
		
		 return resource;
	}
	

}
