package com.example.demo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.login.model.Role;
import com.example.demo.login.model.User;
import com.example.demo.login.repository.RoleRepository;
import com.example.demo.login.repository.UserRepository;

@SpringBootApplication
@EnableCircuitBreaker
//@EnableWebSecurity
public class ServiceUiApplication {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(ServiceUiApplication.class, args);
	}

	@PostConstruct
	@Transactional
	void init() {

		/*
		 * List<Role> roles = roleRepository.saveAll(Arrays .asList(new Role[] { new
		 * Role("Admin"), new Role("Manager"), new Role("Auditor"), new Role("User")
		 * }));
		 * 
		 * System.out.println(roles.toArray());
		 * 
		 * Set<Role> userRoles = new HashSet<Role>(roles);
		 * 
		 * userRepository.saveAll(Arrays.asList(new User[] { new
		 * User("Prosenjit.Das@aig.com", passwordEncoder.encode("password"),
		 * "Prosenjit", "Das", 1, userRoles) }));
		 */

		Role role1 = new Role("Admin");
		Role role2 = new Role("Manager");
		Role role3 = new Role("Auditor");
		Role role4 = new Role("User");

		userRepository.save(new User("cosypro@gmail.com", passwordEncoder.encode("Appian"), "Prosenjit", null, 1,
				new HashSet<Role>(Arrays.asList(new Role[] { role1, role2, role3, role4 }))));

	}
}
