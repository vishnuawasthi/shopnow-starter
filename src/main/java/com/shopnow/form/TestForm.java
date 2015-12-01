package com.shopnow.form;

import org.hibernate.validator.constraints.NotEmpty;

public class TestForm {
	private Integer id;
	@NotEmpty
	private String name;
	@NotEmpty
	private String password;
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
