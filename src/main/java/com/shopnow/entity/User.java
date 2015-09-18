package com.shopnow.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@NamedQueries({
	@NamedQuery(name="User.loadUserByName",query="FROM User user WHERE user.username =:username")
})

@Entity
@Table(name = "jpa_user")
public class User implements Serializable {
	
	private static final long serialVersionUID = 8182426570010869L;
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "user_name", nullable = false, unique = true)
	private String username;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "email")
	private String email;
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Set <Roles> userRoles = new HashSet<Roles>();
	
	public Set<Roles> getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(Set<Roles> userRoles) {
		this.userRoles = userRoles;
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

	

	
}
