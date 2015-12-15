package com.shopnow.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="filter_department")
public class FilterExDepartment {

	@Id
	@Column(name="department_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String name;

	@OneToMany(mappedBy = "filterExDepartment")
	private Set<FilterExEmployee> filterExEmployies = new HashSet<FilterExEmployee>();

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

	public Set<FilterExEmployee> getFilterExEmployies() {
		return this.filterExEmployies;
	}

	public void setFilterExEmployies(Set<FilterExEmployee> filterExEmployies) {
		this.filterExEmployies = filterExEmployies;
	}

	@Override
	public String toString() {
		return "FilterExDepartment [id=" + this.id + ", name=" + this.name + ", filterExEmployies="
				+ this.filterExEmployies + "]";
	}
	
	

}
