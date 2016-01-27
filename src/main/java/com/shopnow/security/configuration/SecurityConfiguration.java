package com.shopnow.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

//@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration  extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private AuthenticationProvider authenticationProvider;
	
	@Autowired
	private AuthenticationManager authenticationManager;


	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	   	auth.userDetailsService(userDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
	/*
		http
		.csrf().disable()
		.authorizeRequests().antMatchers("/home").access("hasRole('USER')")
		.and()
		.formLogin().usernameParameter("username").passwordParameter("password").loginPage("/login")
		.failureUrl("/login?error")
	    .and()
	    .logout().logoutSuccessUrl("/login?logout")
	    .and()
	    .exceptionHandling().accessDeniedPage("/403");*/
		
	http
		.csrf().disable()
		.authorizeRequests().antMatchers("/home").authenticated()
		.and()
		.formLogin().usernameParameter("username").passwordParameter("password").loginPage("/login")
		.failureUrl("/login?error")
	    .and()
	    .logout().logoutSuccessUrl("/login?logout")
	    .and()
	    .exceptionHandling().accessDeniedPage("/403");
	
	
	
	}
}
