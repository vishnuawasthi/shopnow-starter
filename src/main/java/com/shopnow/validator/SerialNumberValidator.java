package com.shopnow.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class SerialNumberValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		// TODO Auto-generated method stub

	}

}
