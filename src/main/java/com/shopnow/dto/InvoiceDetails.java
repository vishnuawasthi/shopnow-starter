package com.shopnow.dto;

import java.util.List;

public class InvoiceDetails {
	private ShippingDetails shippingDetails;
	private ProductDetails productDetails ;
	private List<ProductDetails> productDetailsList;

	public InvoiceDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ShippingDetails getShippingDetails() {
		return this.shippingDetails;
	}

	public void setShippingDetails(ShippingDetails shippingDetails) {
		this.shippingDetails = shippingDetails;
	}

	public ProductDetails getProductDetails() {
		return this.productDetails;
	}

	public void setProductDetails(ProductDetails productDetails) {
		this.productDetails = productDetails;
	}

	public List<ProductDetails> getProductDetailsList() {
		return this.productDetailsList;
	}

	public void setProductDetailsList(List<ProductDetails> productDetailsList) {
		this.productDetailsList = productDetailsList;
	}

	

}
