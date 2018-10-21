package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.domain.Employee;
import com.example.demo.domain.Person;


@Configuration
public class ServiceAppConfig {
    
	@Autowired
	private Person person;
	@Bean
	@RefreshScope
	public Employee getEmployee() {

		return new Employee(person.getName(), "aa@email.com", null, null, null);

	}

}
