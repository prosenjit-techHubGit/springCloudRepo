package com.example.demo.login.service;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.login.model.Role;
import com.example.demo.login.model.User;
import com.example.demo.login.repository.RoleRepository;
import com.example.demo.login.repository.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired

	public UserService(UserRepository userRepository, RoleRepository roleRepository,
			BCryptPasswordEncoder bCryptPasswordEncoder) {
		super();
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;

	}

	/*
	 * public UserService() { }
	 */

	public User findUserByEmail(String email) {
		System.out.println("In User Service " + email);
		User user = null;
		// System.out.println("Calling User repository" +
		// userRepository.findById(Long.parseLong(email)).get());
		try {

			user = userRepository.findByEmail(email);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;

	}

	public void saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setActive(1);
		Role userRole = roleRepository.findByRole("ADMIN");
		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		userRepository.save(user);
	}

}
