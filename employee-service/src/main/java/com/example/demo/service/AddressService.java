package com.example.demo.service;

import java.util.Arrays;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;

@Service
public class AddressService {

	@Value("${server.port}")
	private String employeeServicePort;

	/*
	 * @Autowired private EurekaClient eurekaClient;
	 * 
	 * 
	 * 
	 * @Value("${address.service.uri}") private String addressServiceUri;
	 */

	/*
	 * @Autowired private RestTemplate restTemplate;
	 */

	/*
	 * @Autowired private AddressClient addressServiceProxy;
	 */

	@Autowired

	private RestTemplateBuilder restTemplateBuilder;

//	@HystrixCommand(fallbackMethod = "unknown")
	public Address getEmployeeAddress() {

		/*
		 * String uri = eurekaClient.getNextServerFromEureka("address-service",
		 * false).getHomePageUrl(); System.out.println(uri);
		 */
		/*
		 * return restTemplate.getForObject("http://address-service", String.class) +
		 * " Employee Service Port " + employeeServicePort;
		 */

		// return (Address)addressServiceProxy.getAddress();

		return new Address();

		/*
		 * RestTemplate restTemplate = new RestTemplate();
		 * 
		 * HttpEntity<String> request = new HttpEntity<String>(getHeaders());
		 * ResponseEntity<String> response =
		 * restTemplate.exchange("http://localhost:1111/services/address",
		 * HttpMethod.GET, request, String.class); return response.getBody();
		 */

		/*
		 * RestTemplate restTemplate = restTemplateBuilder.basicAuthorization("bill",
		 * "abc123").build(); return restTemplate.getForObject("http://address-service",
		 * String.class) + " Employee Service Port " + employeeServicePort;
		 */

	}

	private static HttpHeaders getHeaders() {
		String plainCredentials = "john123:password";
		String base64Credentials = new String(Base64.encodeBase64(plainCredentials.getBytes()));

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic " + base64Credentials);
		headers.setAccept(Arrays.asList(MediaType.TEXT_PLAIN));
		return headers;
	}

	public String unknown() {

		return "unknown";
	}

}
