package com.foodapp.rest.r;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.foodapp.rest.r.service.MyUserDetailsService;

@Configuration
public class SecurityConfig {
	@Autowired
	private MyUserDetailsService myUserDetailsService;

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(getAuthProvider());
	}
	
	private DaoAuthenticationProvider getAuthProvider(){
		// It will take spring to my DB for loading the users. 
		DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
		//1. Password encoder 
		dao.setPasswordEncoder(getPasswordEncoder());
		//2. Take dao to service class that will load the user from DB 
		dao.setUserDetailsService(myUserDetailsService);
		
		return dao;
	}
	
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers(HttpMethod.GET,"/api/user/login").authenticated()
		.antMatchers(HttpMethod.GET, "/api/user/hello").permitAll()
		.antMatchers(HttpMethod.GET, "/api/user/private/hello").authenticated()
		.antMatchers(HttpMethod.GET, "/api/user/private/role/hello").hasAnyAuthority("RESTAURANT")
		.anyRequest().permitAll()
		.and().httpBasic()
		.and().csrf().disable();
	}
	

	
	@Bean
	PasswordEncoder getPasswordEncoder(){ 

		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder; 
	}
}
