package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.publisher.EmployeeSource;

@RestController
public class MessageController {

	@Autowired
	private EmployeeSource empSource;

	@PostMapping("/send")
	public String sendMessage(@RequestBody String body) {

		empSource.lateralHireChannel().send(MessageBuilder.withPayload(body).build());
		return "Success";
	}

}
