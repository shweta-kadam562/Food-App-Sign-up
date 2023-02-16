package com.foodapp.rest.r.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.foodapp.rest.r.model.User;
import com.foodapp.rest.r.repo.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService{
	@Autowired
	private UserRepo userRepo;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//go to DB and load the User
		User user = userRepo.getUserByUsername(username);
		
		Collection<GrantedAuthority> list = new ArrayList<>(); 
		SimpleGrantedAuthority sga = new SimpleGrantedAuthority(user.getRole()); 
		list.add(sga);
		
		org.springframework.security.core.userdetails.User springUser = new 
				org.springframework.security.core.userdetails.User
				(user.getUsername(),user.getPassword(),list);
		return springUser;
	}
}
