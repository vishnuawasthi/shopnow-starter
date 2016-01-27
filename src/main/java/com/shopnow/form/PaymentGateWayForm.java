package com.shopnow.form;

import java.io.Serializable;

public class PaymentGateWayForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Action url to hit Payment gateway
	private String actionURL;

	private String cmd;

	// Business Email Id
	private String business;

	// Business Password
	private String password;
	private String custom;
	private String itemName;
	private Float amount;
	private String returnURL;
	private String cancelURL;
	
	
	private String apiSignature;


	public String getActionURL() {
		return this.actionURL;
	}


	public void setActionURL(String actionURL) {
		this.actionURL = actionURL;
	}


	public String getCmd() {
		return this.cmd;
	}


	public void setCmd(String cmd) {
		this.cmd = cmd;
	}


	public String getBusiness() {
		return this.business;
	}


	public void setBusiness(String business) {
		this.business = business;
	}


	public String getPassword() {
		return this.password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getCustom() {
		return this.custom;
	}


	public void setCustom(String custom) {
		this.custom = custom;
	}


	public String getItemName() {
		return this.itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public Float getAmount() {
		return this.amount;
	}


	public void setAmount(Float amount) {
		this.amount = amount;
	}


	public String getReturnURL() {
		return this.returnURL;
	}


	public void setReturnURL(String returnURL) {
		this.returnURL = returnURL;
	}


	public String getCancelURL() {
		return this.cancelURL;
	}


	public void setCancelURL(String cancelURL) {
		this.cancelURL = cancelURL;
	}


	public String getApiSignature() {
		return this.apiSignature;
	}


	public void setApiSignature(String apiSignature) {
		this.apiSignature = apiSignature;
	}
	
	
	
	

}
