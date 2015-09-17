/**
 * 
 */
package com.shopnow.repository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.shopnow.entity.User;

/**
 * @author Vishnu Awasthi
 *
 */
@Component
@Repository(value="loginRepository")
public class LoginRepository extends AbstractRepository<User> {
	public LoginRepository() {
		setClazz(User.class);
	}
}
