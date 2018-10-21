package com.example.demo;

import javax.xml.transform.Source;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.InboundChannelAdapter;

import com.example.demo.domain.Employee;
import com.example.demo.publisher.EmployeeSource;

@SpringBootApplication
//@EnableBinding(Sink.class)

public class LoggingConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoggingConsumerApplication.class, args);
	}
	
	//@StreamListener(Sink.INPUT)
	public void handle(Employee employee) {
		System.out.println("Received: " + employee);
	}
	
	

	public static class Person {
		private String name;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String toString() {
			return this.name;
		}
	}
}
