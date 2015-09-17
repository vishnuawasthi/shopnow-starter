/**
 * 
 */
package com.shopnow.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.shopnow.entity.User;
import com.shopnow.repository.AbstractRepository;

/**
 * @author Vishnu Awasthi
 *
 */
@Component
@Repository(value="loginDAO")
public class LoginDAO extends AbstractRepository<User> {
	public LoginDAO() {
		setClazz(User.class);
	}
}
