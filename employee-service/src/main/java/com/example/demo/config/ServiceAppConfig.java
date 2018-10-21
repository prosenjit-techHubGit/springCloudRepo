package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.example.demo.domain.Employee;
import com.example.demo.domain.Person;

@Configuration
@RibbonClient("assignment-service")
public class ServiceAppConfig {

	@Autowired
	private Person person;

	@Bean
	@RefreshScope
	public Employee getEmployee() {

		return new Employee(person.getName(), "aa@email.com", null, null, null);

	}

@Bean
   @LoadBalanced
	public RestTemplate restTemplate() {

		return new RestTemplate();
	}

/*	@Bean
    @LoadBalanced 
	public RestTemplateBuilder restTemplateBuilder() {
		return new RestTemplateBuilder();
	} */

}
