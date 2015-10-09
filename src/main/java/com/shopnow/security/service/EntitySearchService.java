package com.shopnow.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.shopnow.repository.SearchAutoCompleteRespository;
import com.shopnow.utils.SearchCriteria;

public interface EntitySearchService {
	public abstract List<?> search(SearchCriteria searchCriteria);
	

	@Service
	public class Impl implements EntitySearchService {
		
		@Autowired
		private SearchAutoCompleteRespository repositoryImpl;

		@Override
		public List<?> search(SearchCriteria searchCriteria) {
			repositoryImpl.setSearchCriteria(searchCriteria);
			return repositoryImpl.search();
		}
	}
}
