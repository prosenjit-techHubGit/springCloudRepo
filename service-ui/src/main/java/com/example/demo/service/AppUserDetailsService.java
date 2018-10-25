package com.example.demo.service;

import java.util.Collection;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.login.service.UserService;


public class AppUserDetailsService  {
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserService userService;
	
	
	
	/*@Override
	public UserDetails loadUserByUsername(final String username) {} */
	
}
