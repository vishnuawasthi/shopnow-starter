package com.shopnow.exception;
/**
 * 
 * @author Vishnu Awasthi
 *
 */
public class RecordNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3915718805707823075L;
	private String message;
	private String reason;
	public RecordNotFoundException(String message){
		super(message);
		this.message = message;
	}
	public RecordNotFoundException(String message, String reason) {
		super(message);
		this.message = message;
		this.reason = reason;
	}
	public String getMessage() {
		return this.message;
	}
	public String getReason() {
		return this.reason;
	}

}
