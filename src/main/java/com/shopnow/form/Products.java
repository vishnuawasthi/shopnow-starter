/**
 * 
 */
package com.shopnow.form;

import java.io.Serializable;

/**
 * @author Dell
 *
 */
public class Products implements Serializable {

	private Long id;
	private String productName;
	private String price;

	public Products(Long id, String productName, String price) {
		super();
		this.id = id;
		this.productName = productName;
		this.price = price;
	}
	public Products() {
		super();
	}
	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
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
