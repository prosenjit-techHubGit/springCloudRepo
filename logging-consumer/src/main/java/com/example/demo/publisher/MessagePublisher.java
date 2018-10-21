package com.example.demo.publisher;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.support.MessageBuilder;

import com.example.demo.domain.Employee;

@EnableBinding(EmployeeSource.class)
public class MessagePublisher {
    
	@Bean
	//@InboundChannelAdapter(channel = "lateralHireChannel", poller = @Poller(fixedDelay = "2000"))
	public MessageSource<Employee> publishMessage() {

		return () -> MessageBuilder.withPayload(new Employee("Pranjal","Family")).build();
	}

	
}
