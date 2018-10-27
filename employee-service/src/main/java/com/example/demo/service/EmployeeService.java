package com.example.demo.service;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.ServiceMainController;
import com.example.demo.domain.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.exception.EmployeeNotAddedException;

@Service
public class EmployeeService {

	private static Logger logger = LoggerFactory.getLogger(EmployeeService.class);
	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee addEmployee(Employee employee) {
		Employee emp = null;

		if (employeeRepository.findByEmail(employee.getEmail()).isPresent()) {
			logger.info("Employee could not be added - Email ID " + employee.getEmail() + " already exists");
			throw new EmployeeNotAddedException();

		}

		emp = employeeRepository.save(employee);

		return emp;

	}

	public List<Employee> getAllEmployees() {

		List<Employee> empList = employeeRepository.findAll();
		return empList;

	}

}
