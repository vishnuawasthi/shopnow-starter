package com.shopnow.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "jpa_roles")
public class Roles implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1406938387889800990L;
	@Id
	@Column(name="role_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(name="role_name",nullable=false,unique=true)
	private String roleName;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	public Roles() {
	}
	public Roles(Long id, String roleName, User user) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.user = user;
	}
	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRoleName() {
		return this.roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public User getUser() {
		return this.user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
		result = prime * result + ((this.roleName == null) ? 0 : this.roleName.hashCode());
		result = prime * result + ((this.user == null) ? 0 : this.user.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Roles other = (Roles) obj;
		if (this.id == null) {
			if (other.id != null)
				return false;
		} else if (!this.id.equals(other.id))
			return false;
		if (this.roleName == null) {
			if (other.roleName != null)
				return false;
		} else if (!this.roleName.equals(other.roleName))
			return false;
		if (this.user == null) {
			if (other.user != null)
				return false;
		} else if (!this.user.equals(other.user))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Roles [id=" + this.id + ", roleName=" + this.roleName + ", user=" + this.user + "]";
	}

}
