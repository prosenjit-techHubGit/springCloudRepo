package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.example.demo.controller.ServiceMainController;

@EnableConfigurationProperties
@SpringBootApplication
public class Service1Application {
	private static Logger logger = LoggerFactory.getLogger(ServiceMainController.class);
	public static void main(String[] args) {
		SpringApplication.run(Service1Application.class, args);
	}
}
