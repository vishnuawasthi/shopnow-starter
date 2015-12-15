package com.shopnow.assembler;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Service;

import com.shopnow.entity.Supplier;
import com.shopnow.resource.SupplierResource;
import com.shopnow.rest.controller.SupplierController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@Service
public class SupplierAssembler extends ResourceAssemblerSupport<Supplier, SupplierResource> {
	
	public SupplierAssembler() {
		super(SupplierController.class, SupplierResource.class);
	}

	@Override
	public SupplierResource toResource(Supplier entity) {
		SupplierResource resource = new SupplierResource();
									resource.setSupplierId(entity.getId());
									resource.setName(entity.getName());
									resource.setEmail(entity.getEmail());
									resource.setAddress(entity.getAddress());
									resource.setState(resource.getState());
									resource.setCountry(resource.getCountry());
									// TODO- Link should be added
									resource.add(linkTo(methodOn(SupplierController.class).getSupplier(entity.getId())).withSelfRel());
									return resource;
	}

}
