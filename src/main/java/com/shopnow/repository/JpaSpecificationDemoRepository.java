package com.shopnow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.shopnow.entity.Supplier;

/**
 * 
 * @author Vishnu Awasthi
 * 		   Interface to allow execution of Specifications based
 *         on the JPA criteria API. After we have extended the
 *         JpaSpeciticationExecutor interface, the classes that use our
 *         repository interface get access to the following methods:
 * 
 *         The long count(Specification<T> spec) method returns the number of
 *         objects that fulfil the conditions specified by the Specification<T>
 *         object given as a method parameter. The List<T>
 *         findAll(Specification<T> spec) method returns objects that fulfil the
 *         conditions specified by the Specification<T> object given as a method
 *         parameter. The T findOne(Specification<T> spec) method returns an
 *         object that fulfils the conditions specified by the Specification<T>
 *         object given as a method parameter. The JpaSpecificationExecutor<T>
 *         interface declares also two other methods that are used to sort and
 *         paginate objects that fulfil the conditions specified by the
 *         Specification<T> object. We will talk more about these methods when
 *         we learn to sort and paginate our query results.
 * @see org.springframework.data.jpa.repository.JpaSpecificationExecutor
 *
 */
public interface JpaSpecificationDemoRepository
		extends
			JpaRepository<Supplier, Long>,
			JpaSpecificationExecutor<Supplier> {

}
