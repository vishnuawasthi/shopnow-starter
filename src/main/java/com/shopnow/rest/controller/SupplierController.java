package com.shopnow.rest.controller;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shopnow.assembler.SupplierAssembler;
import com.shopnow.entity.Supplier;
import com.shopnow.repository.SupplierRepository;
import com.shopnow.resource.SupplierResource;

@RestController
@Transactional
@RequestMapping(value="/suppliers")
public class SupplierController {

	@Autowired
	private SupplierRepository supplierRepository;

	@Autowired
	private SupplierAssembler supplierAssembler;

	@Autowired
	private SessionFactory sessionFactory;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PagedResources<SupplierResource>> getAllSuppliers(
			 @PageableDefault(size=2000,value=Integer.MAX_VALUE)	Pageable pageable,
			PagedResourcesAssembler<Supplier> assembler) {
		
		Page<Supplier> page = supplierRepository.findAll(pageable);
		PagedResources<SupplierResource> pagedResource = assembler.toResource(page,
				supplierAssembler);
		
		System.out.println("sessionFactory  ::::"+sessionFactory);
		
		return new ResponseEntity<PagedResources<SupplierResource>>(pagedResource, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET,
		produces = MediaType.APPLICATION_JSON_VALUE)
	public HttpEntity<SupplierResource> getSupplier(
			@PathVariable(value = "id") Long id) {
		return new ResponseEntity<SupplierResource>(supplierAssembler.toResource(supplierRepository
				.findOne(id)), HttpStatus.OK);
	}

}
