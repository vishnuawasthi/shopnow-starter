/**
 * 
 */
package com.shopnow.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.shopnow.entity.User;
import com.shopnow.repository.AbstractRepository;

/**
 * @author Vishnu Awasthi
 *
 */
@Component
@Repository(value="loginRepository")
public class LoginRepository extends AbstractRepository<User> {
	@PersistenceContext
	private EntityManager entityManager;
	
	public LoginRepository() {
		setClazz(User.class);
	}
	
	public User loadUserByName(String username){
		System.out.println("loadUserByName() - start");
		TypedQuery<User>  query=  entityManager.createNamedQuery("User.loadUserByName", User.class);
		query.setParameter("username", username);
		System.out.println("loadUserByName() - start");
		User user = query.getSingleResult();
		
		System.out.println("user  ::::::::"+user);
		
		if(!StringUtils.isEmpty(user)){
			System.out.println("User Name      :"+user.getUsername());
			System.out.println("User Password  :"+user.getPassword());
		}
		return user;
	}
}
