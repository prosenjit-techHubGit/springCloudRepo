package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Assignment;
import com.example.demo.model.Employee;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class EmployeeService {

	@Value("${app.gateway.service-url}")
	private String gatewayServiceUrl;

	@HystrixCommand(fallbackMethod = "getAPIData")
	public Assignment getEmployeeAssignment(String accessToken) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();

		headers.add("Authorization", "Bearer " + accessToken);

		HttpEntity<String> request = new HttpEntity<String>(headers);

		ResponseEntity<Assignment> res = restTemplate.exchange(gatewayServiceUrl + "employee/assignment",
				HttpMethod.GET, request, Assignment.class);
		System.out.println(res.getBody().getEmployeeId());
		return res.getBody();
	}

	public Assignment getAPIData(String accessToken) {

		System.out.println("Fallback Method called");

		return new Assignment();

	}

	public List<Employee> getAllEmployee(String accessToken) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();

		headers.add("Authorization", "Bearer " + accessToken);

		HttpEntity<String> request = new HttpEntity<String>(headers);

		ResponseEntity<List<Employee>> res = restTemplate.exchange(gatewayServiceUrl + "employee/all", HttpMethod.GET,
				request, new ParameterizedTypeReference<List<Employee>>() {
				});
		System.out.println(res.getBody());
		return res.getBody();
	}

	public Employee addEmployee(String accessToken, Employee employee) {
		RestTemplate restTemplate = new RestTemplate();
		// MultiValueMap<String, Object> map = new LinkedMultiValueMap<String,
		// Object>();
		// map.add("employee", employee);
		HttpHeaders headers = new HttpHeaders();

		headers.add("Authorization", "Bearer " + accessToken);
		// HttpEntity<MultiValueMap<String, Object>> httpEntity = new
		// HttpEntity<MultiValueMap<String, Object>>(map, headers);

		HttpEntity<Employee> request = new HttpEntity<Employee>(employee, headers);

		ResponseEntity<Employee> res = restTemplate.exchange("http://localhost:5555/services/employee/create",
				HttpMethod.POST, request, Employee.class);
		System.out.println(res.getBody());
		return res.getBody();
	}

}
