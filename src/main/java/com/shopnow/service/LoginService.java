package com.shopnow.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.shopnow.dao.LoginDAO;
import com.shopnow.entity.User;
import com.shopnow.exception.RecordNotFoundException;
import com.shopnow.form.UserForm;

public interface LoginService {
	public abstract void create(UserForm userForm);
	public abstract void update(UserForm userForm)
			throws RecordNotFoundException;
	public abstract void deleteById(Long id);
	public abstract UserForm findById(Long id);
	public abstract UserForm findByName(String userName);

	@Service
	@Transactional
	public class Impl implements LoginService {

		@Autowired
		private LoginDAO loginRepository;

		public void create(UserForm userForm) {
			loginRepository.save(formToEntity(userForm));
		}

		public void update(UserForm userForm) throws RecordNotFoundException {
			User user = loginRepository.findOne(userForm.getId());
			if (!StringUtils.isEmpty(user)) {
				if (!StringUtils.isEmpty(userForm.getFirstName()))
					user.setFirstName(userForm.getFirstName());

				if (!StringUtils.isEmpty(userForm.getFirstName()))
					user.setLastName(userForm.getLastName());

				if (!StringUtils.isEmpty(userForm.getUsername()))
					user.setFirstName(userForm.getUsername());

				if (!StringUtils.isEmpty(userForm.getPassword()))
					user.setFirstName(userForm.getPassword());

				if (!StringUtils.isEmpty(userForm.getEmail()))
					user.setFirstName(userForm.getEmail());
				
				loginRepository.update(user);

			} else {
				throw new RecordNotFoundException("Record not found");
			}
		}

		public void deleteById(Long id) {
			loginRepository.deleteById(id);

		}

		public UserForm findById(Long id) {
			User user = loginRepository.findOne(id);
			return entityToForm(user);
		}

		public UserForm findByName(String userName) {
			return null;
		}

		private User formToEntity(UserForm userForm) {
			User user = new User();
			user.setId(userForm.getId());
			user.setFirstName(userForm.getFirstName());
			user.setLastName(userForm.getLastName());
			user.setUsername(userForm.getPassword());
			user.setEmail(userForm.getEmail());
			return user;
		}

		private UserForm entityToForm(User user) {
			UserForm userForm = null;
			if (!StringUtils.isEmpty(user)) {
				userForm = new UserForm();
				userForm.setId(user.getId());
				userForm.setFirstName(user.getFirstName());
				userForm.setLastName(user.getLastName());
				userForm.setUsername(user.getPassword());
				userForm.setEmail(user.getEmail());
			}
			return userForm;
		}

	}
}
