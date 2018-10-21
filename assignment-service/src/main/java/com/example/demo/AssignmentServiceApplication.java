package com.example.demo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.demo.domain.Assignment;
import com.example.demo.domain.Project;
import com.example.demo.repositories.AssignmentRepository;
import com.example.demo.repositories.ProjectRepository;

import ch.qos.logback.core.net.SyslogOutputStream;

@EnableDiscoveryClient
@EnableTransactionManagement
@SpringBootApplication
public class AssignmentServiceApplication {

	@Autowired
	private AssignmentRepository assignmentRepository;

	@Autowired
	private ProjectRepository projectRepository;

	public static void main(String[] args) {
		SpringApplication.run(AssignmentServiceApplication.class, args);
	}

@PostConstruct
	void init() {

		Project project = projectRepository.save(new Project("Project2", new java.sql.Date(System.currentTimeMillis()),
				new java.sql.Date(System.currentTimeMillis())));

		System.out.println(project.getProjectName());

		assignmentRepository.save(new Assignment(new java.sql.Date(System.currentTimeMillis()),
				new java.sql.Date(System.currentTimeMillis()), project, new Long(140837)));

	} 
}
