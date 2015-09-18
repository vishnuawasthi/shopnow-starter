package com.shopnow.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.shopnow.dao.LoginRepository;
import com.shopnow.entity.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService  {

	@Autowired
	private LoginRepository loginRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("UserDetailsServiceImpl : loadUserByUsername() -start");
		User user = loginRepository.loadUserByName(username);
		
		
		
		UserDetails userDetails = new UserDetailsImpl(user);
		System.out.println("userDetails   :::::::::"+userDetails.getUsername());
		
		System.out.println("userDetails   :::::::::"+userDetails.getPassword());
		
		System.out.println("userDetails   :::::::::"+userDetails.getAuthorities());
		
		
		System.out.println("UserDetailsServiceImpl : loadUserByUsername() -end");
		return userDetails;
	}

}
