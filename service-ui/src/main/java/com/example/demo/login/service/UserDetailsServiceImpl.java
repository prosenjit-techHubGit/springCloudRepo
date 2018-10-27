package com.example.demo.login.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User.UserBuilder;

import com.example.demo.login.model.User;
import com.example.demo.model.CustomUserDetails;


public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		System.out.println("Loading user details for " + email);
		User user = userService.findUserByEmail(email);
        System.out.println(user);
		CustomUserDetails userDetails;

		if (user != null) {

			userDetails = new CustomUserDetails(user);

		} else {
			throw new UsernameNotFoundException("User not found.");
		}
        System.out.println(userDetails);
		return userDetails;

	}

}
