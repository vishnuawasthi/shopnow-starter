package com.shopnow.repository;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
/**
 * This is an abstract repository class which provides basic functionality to
 * perform database operations.
 * 
 * @author Vishnu Awasthi
 *
 */
public abstract class AbstractRepository<T extends Serializable> {
	public Class<T> clazz;
	@PersistenceContext
	EntityManager entityManager;

	public final void setClazz(Class<T> clazzToSet) {
		this.clazz = clazzToSet;
	}

	public void update(T entity) {
		entityManager.merge(entity);
	}

	public void save(T entity) {
		entityManager.persist(entity);
	}

	@SuppressWarnings("unchecked")
	public Iterable<T> findAll(T entity) {
		return entityManager.createQuery("FROM '" + clazz.getName() + "'")
				.getResultList();
	}

	public T findOne(Long id) {
		return entityManager.find(clazz, id);
	}

	public void delete(T entity) {
		entityManager.remove(entity);;
	}

	public void deleteById(Long id) {
		T entity = findOne(id);
		delete(entity);
	}
}
