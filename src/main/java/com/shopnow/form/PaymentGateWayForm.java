package com.shopnow.form;

import java.io.Serializable;

public class PaymentGateWayForm  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	
	private String paymentGateWayURL;
	private String success;
	private String failure;
	public PaymentGateWayForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPaymentGateWayURL() {
		return this.paymentGateWayURL;
	}
	public void setPaymentGateWayURL(String paymentGateWayURL) {
		this.paymentGateWayURL = paymentGateWayURL;
	}
	public String getSuccess() {
		return this.success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	public String getFailure() {
		return this.failure;
	}
	public void setFailure(String failure) {
		this.failure = failure;
	}
	
}
