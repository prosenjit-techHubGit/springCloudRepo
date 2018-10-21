package com.example.demo.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Project {

	@Id
	@GeneratedValue
	private Long id;

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Project(String projectName, Date startDate, Date endDate) {
		super();
		this.projectName = projectName;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	private String projectName;
	private Date startDate;
	private Date endDate;

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
