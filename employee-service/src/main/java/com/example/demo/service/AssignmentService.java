package com.example.demo.service;

import java.net.URI;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.domain.Assignment;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import ch.qos.logback.core.net.SyslogOutputStream;


@Service
public class AssignmentService {
	
	@Autowired
	
	private RestTemplate restTemplate;
    
	@HystrixCommand(fallbackMethod="getDefaultAssignment")
	public Assignment getAssignments(Long empId) {

		ParameterizedTypeReference<Resource<Assignment>> assignmemnt = new ParameterizedTypeReference<Resource<Assignment>>() {
		};

		//RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<Resource<Assignment>> response = restTemplate.exchange(RequestEntity
				.get(URI.create("http://assignment-service/assignments/2")).accept(MediaTypes.HAL_JSON).build(),
				assignmemnt);

		assert response != null;
		if (response.getStatusCode() == HttpStatus.OK) {
			System.out.println(response);
			Assignment assignment = response.getBody().getContent();
			System.out.println(assignment.getProject());

			return assignment;
		} else {
			System.out.println(response);
			return null;

		}
	}
	
	public Assignment getDefaultAssignment(Long empId) {
		System.out.println("Fallback Method Called");
		return new Assignment();
	}

}
