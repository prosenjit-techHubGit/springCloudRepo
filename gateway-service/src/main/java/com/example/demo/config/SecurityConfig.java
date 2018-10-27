package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
//	http.csrf().disable().authorizeRequests().antMatchers("/services").permitAll().anyRequest().authenticated();
	http.csrf().disable().authorizeRequests().antMatchers("/services/**").permitAll();
		
	//	http.csrf().disable().authorizeRequests().antMatchers("/**").permitAll();
	}
}
