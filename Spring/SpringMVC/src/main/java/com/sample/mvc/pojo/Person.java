package com.sample.mvc.pojo;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Person {
	
	
	public Person(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public Person() {
		super();
	}

	@NotEmpty
	private String username;
	@NotEmpty(message = "Please enter your password.")
    @Size(min = 6, max = 15, message = "Your password must between 6 and 15 characters")
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
