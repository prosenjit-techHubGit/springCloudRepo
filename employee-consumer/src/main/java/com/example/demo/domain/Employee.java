package com.example.demo.domain;

public class Employee {

	public String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String company;

	public Employee(String name, String company) {
		super();
		this.name = name;
		this.company = company;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", company=" + company + "]";
	}

}