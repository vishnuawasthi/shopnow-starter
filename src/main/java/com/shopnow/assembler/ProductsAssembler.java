package com.shopnow.assembler;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Service;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


import com.shopnow.form.Products;
import com.shopnow.resource.ProductResource;
import com.shopnow.rest.controller.ProductController;

@Service
public class ProductsAssembler extends ResourceAssemblerSupport<Products,ProductResource> {

	public ProductsAssembler() {
		super(ProductController.class, ProductResource.class);
	}

	@Override
	public ProductResource toResource(Products product) {
		 ProductResource resource = new ProductResource();
		 resource.setProductId(product.getId());
		 resource.setProductName(product.getProductName());
		 resource.setPrice(product.getPrice());
		 resource.add(linkTo(methodOn(ProductController.class).getOneProducts(product.getId())).withSelfRel());
		 return resource;
	}
	

}
