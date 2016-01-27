package com.shopnow.dto;

public class PersonDTO {

  private Long id;
  private String firstName;
  private String lastName;
  private String email;
  private String mobile;
  private String addressLine1;
  private String addressLine2;
  private String description;
  private String imageURL;
  
  public PersonDTO() {
	super();
	// TODO Auto-generated constructor stub
  }
  
  public Long getId() {
	return id;
  }
  public void setId(Long id) {
	this.id = id;
  }
  public String getFirstName() {
	return firstName;
  }
  public void setFirstName(String firstName) {
	this.firstName = firstName;
  }
  public String getLastName() {
	return lastName;
  }
  public void setLastName(String lastName) {
	this.lastName = lastName;
  }
  public String getEmail() {
	return email;
  }
  public void setEmail(String email) {
	this.email = email;
  }
  public String getMobile() {
	return mobile;
  }
  public void setMobile(String mobile) {
	this.mobile = mobile;
  }
  public String getAddressLine1() {
	return addressLine1;
  }
  public void setAddressLine1(String addressLine1) {
	this.addressLine1 = addressLine1;
  }
  public String getAddressLine2() {
	return addressLine2;
  }
  public void setAddressLine2(String addressLine2) {
	this.addressLine2 = addressLine2;
  }
  public String getDescription() {
	return description;
  }
  public void setDescription(String description) {
	this.description = description;
  }
  public String getImageURL() {
	return imageURL;
  }
  public void setImageURL(String imageURL) {
	this.imageURL = imageURL;
  }

}
