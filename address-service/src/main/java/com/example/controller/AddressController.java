package com.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Address;

@RestController

public class AddressController {

	@Value("${server.port}")
	private String servicePort;

	@GetMapping("/address")
	public Address getAddress() {

		return new Address("123 Street", "Janai", "712304", "WB", "India");
	}

}
