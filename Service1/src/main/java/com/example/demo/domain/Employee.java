package com.example.demo.domain;

public class Employee {
	
	

	public Employee(String name, String email, String phone, String department, String manager) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.department = department;
		this.manager = manager;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	private String email;
	private String phone;
	private String department;
	private String manager;

}
