package com.sample.mvc.pojo;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class PersonValidator implements Validator{

	public boolean supports(Class<?> clazz) {
		 return Person.class.equals(clazz);
	}

	public void validate(Object obj, Errors e) {
		ValidationUtils.rejectIfEmpty(e, "username", "username.empty");
		ValidationUtils.rejectIfEmpty(e, "password", "password.empty");
		
	}

}
