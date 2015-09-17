package com.shopnow.resource;

import org.springframework.hateoas.ResourceSupport;

public class ProductResource extends ResourceSupport {
	private Long productId;
	private String productName;
	private String price;
	public ProductResource() {
		super();
	}
	public ProductResource(Long productId, String productName, String price) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
	}
	
	public Long getProductId() {
		return this.productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return this.productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getPrice() {
		return this.price;
	}
	public void setPrice(String price) {
		this.price = price;
	}

}
