package com.example.demo.publisher;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface EmployeeSource {
	@Output("lateralHireChannel")
	MessageChannel lateralHireChannel();

	@Output("freshersHirechannel")
	MessageChannel freshersHirechannel();

}	
