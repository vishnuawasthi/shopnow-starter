package com.shopnow.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.shopnow.utils.SearchCriteria;


@Repository(value="searchAutoCompleteRespository")
public  class SearchAutoCompleteRespository{

	@PersistenceContext
	private EntityManager entityManager;
	
	private Class<?> clazz;
	private String entityName;
	private String searchField;
	private String searchFieldValue;

	public void setSearchCriteria(SearchCriteria searchCriteria) {
		this.searchField = searchCriteria.getSearchField();
		this.searchFieldValue =searchCriteria.getSearchFieldValue();
		this.entityName=searchCriteria.getEntityName();
		this.clazz=searchCriteria.getClazz();
	}
	
	public List<?> search(){
		TypedQuery<?> query = entityManager.createQuery(" FROM "+this.entityName+"  entity WHERE "+ "entity."+searchField+ "  =:"+searchField , this.clazz);
		query.setParameter(searchField, searchFieldValue);
		return query.getResultList();
	}
}
