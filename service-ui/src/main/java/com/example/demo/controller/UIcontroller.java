package com.example.demo.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Address;
import com.example.demo.model.Assignment;
import com.example.demo.model.Employee;
import com.example.demo.model.UserDetails;
import com.example.demo.model.UserInfo;
import com.example.demo.service.EmployeeService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/suite")
public class UIcontroller {

	@Autowired
	private OAuth2ClientContext clientContext;
	@Autowired
	private OAuth2RestTemplate oauth2RestTemplate;
	@Autowired
	private EmployeeService empployeeService;

	/*
	 * @GetMapping("/") public String loadHome() {
	 * 
	 * return "home"; }
	 */

	@RequestMapping("/api")
	public String callAPIGateway(Model model) {
		OAuth2AccessToken accessToken = clientContext.getAccessToken();
		System.out.println(accessToken);
		System.out.println(oauth2RestTemplate.getResource().isAuthenticationRequired());
		System.out.println(oauth2RestTemplate.getOAuth2ClientContext().getAccessToken());

		/*
		 * ResponseEntity<String> resp =
		 * oauth2RestTemplate.exchange("http://localhost:5555/services/employee",
		 * HttpMethod.GET, null, String.class); System.out.println(resp.getBody());
		 * System.out.println(accessToken);
		 */
		empployeeService.getEmployeeAssignment(String.valueOf(accessToken));

		return "Api";

	}

	@GetMapping("/getAllEmployee")
	public List<Employee> getAllEmployee() {
		OAuth2AccessToken accessToken = clientContext.getAccessToken();
		System.out.println(accessToken);
		System.out.println(oauth2RestTemplate.getResource().isAuthenticationRequired());
		System.out.println(oauth2RestTemplate.getOAuth2ClientContext().getAccessToken());

		/*
		 * ResponseEntity<String> resp =
		 * oauth2RestTemplate.exchange("http://localhost:5555/services/employee",
		 * HttpMethod.GET, null, String.class); System.out.println(resp.getBody());
		 * System.out.println(accessToken);
		 */
		return empployeeService.getAllEmployee(String.valueOf(accessToken));

	}

	@RequestMapping(value="/create", method=RequestMethod.POST, consumes="application/json")
	public Employee addEmployee(@RequestBody Employee employee ) {
		OAuth2AccessToken accessToken = clientContext.getAccessToken();
		System.out.println(accessToken);
		System.out.println(oauth2RestTemplate.getResource().isAuthenticationRequired());
		System.out.println(oauth2RestTemplate.getOAuth2ClientContext().getAccessToken());
		System.out.println("Creating employee");
       
		/*
		 * ResponseEntity<String> resp =
		 * oauth2RestTemplate.exchange("http://localhost:5555/services/employee",
		 * HttpMethod.GET, null, String.class); System.out.println(resp.getBody());
		 * System.out.println(accessToken);
		 */
		return empployeeService.addEmployee(String.valueOf(accessToken),employee);

	}
	
	@GetMapping("/user")
	  public Principal user(Principal principal) {
	    return principal;
	  }
	
	@GetMapping("/userInfo")
	
	public UserDetails getUserInfo() {
		OAuth2AccessToken accessToken = clientContext.getAccessToken();
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();

		headers.add("Authorization", "Bearer " + accessToken);

		HttpEntity<String> request = new HttpEntity<String>(headers);

		ResponseEntity<UserDetails> res = restTemplate.exchange("https://graph.facebook.com/me",
				HttpMethod.GET, request,UserDetails.class);
		System.out.println(res.getBody());
		return res.getBody();
		
		
	}
	
	

}
