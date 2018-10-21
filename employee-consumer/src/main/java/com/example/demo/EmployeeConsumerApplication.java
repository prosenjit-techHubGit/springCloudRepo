package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import com.example.demo.domain.Employee;

@SpringBootApplication
@EnableBinding(Sink.class)
public class EmployeeConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeConsumerApplication.class, args);
	}

	@StreamListener(Sink.INPUT)
	public void handle(Employee employee) {
		System.out.println("Received: " + employee);
	}
}
