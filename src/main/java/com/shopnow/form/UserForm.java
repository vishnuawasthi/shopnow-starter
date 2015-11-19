package com.shopnow.form;

public class UserForm {
	private Long id;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String email;
	public UserForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserForm(Long id, String firstName, String lastName,
			String username, String password, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return this.firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return this.lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "UserForm [id=" + this.id + ", firstName=" + this.firstName + ", lastName="
				+ this.lastName + ", username=" + this.username + ", password=" + this.password
				+ ", email=" + this.email + "]";
	}
	
}
