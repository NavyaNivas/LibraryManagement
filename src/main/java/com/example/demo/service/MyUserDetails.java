package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.model.UserPrincipal;
import com.example.demo.repo.UserRepo;

@Service
public class MyUserDetails implements UserDetailsService {

	@Autowired
	private UserRepo repo;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    User user = repo.findByuserName(username)
	        .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

	    return new UserPrincipal(user);
	}

	

}
