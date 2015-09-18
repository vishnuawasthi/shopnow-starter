package com.shopnow.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
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
		//auth.authenticationProvider(authenticationProvider);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*http
			.csrf().disable()
			.authorizeRequests()
			//.antMatchers("/**", "/**")
			.anyRequest()
			.access("hasRole('USER')")
			.and()
			.formLogin()
			.failureUrl("/login?error")
			.usernameParameter("username").passwordParameter("password")
			.and().authenticationProvider(authenticationProvider);
	*/
		
		http
		.csrf().disable()
		//.authorizeRequests().antMatchers("GET","/rest/getProducts")
		.authorizeRequests().antMatchers("/rest/getProducts")
		//.access("hasRole('USER')")
		.authenticated().and().formLogin();	
		//.failureUrl("/login?error")
		//.usernameParameter("username").passwordParameter("password").and().logout().logoutSuccessUrl("/login?logout");/*.and()
		//.exceptionHandling().accessDeniedPage("/403").and().csrf();*/
		
		
	}
}
