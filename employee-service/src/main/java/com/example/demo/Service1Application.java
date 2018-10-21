package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.example.ribbon.config.RibbonClientConfig;

@EnableConfigurationProperties
@EnableDiscoveryClient
@EnableEurekaClient
//@EnableFeignClients
@EnableCircuitBreaker
//@EnableHystrix
//@RibbonClient(name = "address-service")
//@RibbonClient(name = "assignment-service-local")
@SpringBootApplication
public class Service1Application {
	private static Logger logger = LoggerFactory.getLogger(ServiceMainController.class);

	public static void main(String[] args) {
		SpringApplication.run(Service1Application.class, args);
	}
}
