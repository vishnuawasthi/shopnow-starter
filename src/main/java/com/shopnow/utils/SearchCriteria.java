package com.shopnow.utils;

public class SearchCriteria {
	private Class<?> clazz;
	private String entityName;
	private String searchField;
	private String searchFieldValue;

	public SearchCriteria(String searchField, String searchFieldValue, String entityName, Class<?> clazz) {
		this.searchField = searchField;
		this.entityName = entityName;
		this.clazz = clazz;
		this.searchFieldValue=searchFieldValue;
	}

	public Class<?> getClazz() {
		return this.clazz;
	}

	public void setClazz(Class<?> clazz) {
		this.clazz = clazz;
	}

	public String getEntityName() {
		return this.entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getSearchField() {
		return this.searchField;
	}

	public void setSearchField(String searchField) {
		this.searchField = searchField;
	}

	public String getSearchFieldValue() {
		return this.searchFieldValue;
	}

	public void setSearchFieldValue(String searchFieldValue) {
		this.searchFieldValue = searchFieldValue;
	}

}
