package com.example.demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.config.FeignClientConfiguration;

@FeignClient(name = "address-service", configuration = FeignClientConfiguration.class)
public interface AddressClient {

	@RequestMapping(method = RequestMethod.GET, value = "/services/address")
	Address getAddress();
}
