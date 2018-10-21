package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Employee;
import com.example.demo.domain.Person;

@RestController
public class ServiceMainController {

	private static Logger logger = LoggerFactory.getLogger(ServiceMainController.class);
	@Autowired
	private Employee employee;

	@Autowired
	private Person person;

	@GetMapping
	public String getPersonDetails() {
	/*	employee.setName(person.getName());
		System.out.println(employee.getName()); */
		return employee.getName();
	}

}
