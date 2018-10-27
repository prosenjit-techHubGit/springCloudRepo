package com.example.demo;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.example.demo.controller.ServiceMainController;
import com.example.demo.domain.Assignment;
import com.example.demo.domain.Employee;
import com.example.demo.domain.Project;
import com.example.demo.repository.EmployeeRepository;
import com.example.ribbon.config.RibbonClientConfig;

@EnableConfigurationProperties
//@EnableDiscoveryClient
@EnableEurekaClient
//@EnableFeignClients
@EnableCircuitBreaker
//@EnableHystrix
//@RibbonClient(name = "address-service")
//@RibbonClient(name = "assignment-service-local")
@SpringBootApplication
public class Service1Application {

	@Autowired
	private EmployeeRepository employeeRepository;

	private static Logger logger = LoggerFactory.getLogger(ServiceMainController.class);

	public static void main(String[] args) {
		SpringApplication.run(Service1Application.class, args);
	}

/*	@PostConstruct
	void init() {

		employeeRepository.save(new Employee("Prosenjit","Prosnejit@email.com","1233435","CTS","Sabari"));
	} */
}
