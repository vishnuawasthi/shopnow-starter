package com.shopnow.exception;

public class ExceptionBean {
	private String code;
	private String message;
	private String descrption;
	
	
	
	public ExceptionBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public ExceptionBean(String code, String message, String descrption) {
		super();
		this.code = code;
		this.message = message;
		this.descrption = descrption;
	}


	public String getCode() {
		return this.code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return this.message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDescrption() {
		return this.descrption;
	}
	public void setDescrption(String descrption) {
		this.descrption = descrption;
	}


	@Override
	public String toString() {
		return "ExceptionBean [code=" + this.code + ", message=" + this.message + ", descrption="
				+ this.descrption + "]";
	}
	
	
	
}
