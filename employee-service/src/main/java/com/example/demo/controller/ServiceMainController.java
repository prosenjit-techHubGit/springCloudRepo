package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Assignment;
import com.example.demo.domain.Employee;
import com.example.demo.domain.Person;
import com.example.demo.service.Address;
import com.example.demo.service.AddressService;
import com.example.demo.service.AssignmentService;
import com.example.demo.service.EmployeeService;
import com.github.andrewoma.dexx.collection.ArrayList;

@RestController
public class ServiceMainController {

	private static Logger logger = LoggerFactory.getLogger(ServiceMainController.class);
	@Autowired
	private Employee employee;

	@Autowired
	private Person person;

	@Autowired
	private AddressService addressService;

	@Autowired
	private AssignmentService assignmentService;
	
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/")
	public Address getPersonDetails() {
		/*
		 * employee.setName(person.getName()); System.out.println(employee.getName());
		 */
		getAssignment();
		// return addressService.getEmployeeAddress();

		return new Address();

	}

	@GetMapping("/assignment")
	public Assignment getAssignment() {

		/*
		 * employee.setName(person.getName()); System.out.println(employee.getName());
		 */
		Assignment assignment = assignmentService.getAssignments(new Long(140837));

		System.out.println(assignment.getEmployeeId());
		return assignment;
	}
   
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/all")

	public List<Employee> getAllEmployees() {

		return employeeService.getAllEmployees();

	}
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/create")

	public Employee create(@Valid @RequestBody Employee employee) {
		
		System.out.println("Recieved" + employee.getEmail());  
		
		return employeeService.addEmployee(employee);
          
		
		

	}

}
