package com.example.demo.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Assignment {

	@Id
	@GeneratedValue
	private Long id;
	private Date startDate;
	private Date endDate;
	private Long employeeId;

	@OneToOne
	private Project project;

	public Assignment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Assignment(Date startDate, Date endDate, Project project, Long employeeId) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.project = project;
		this.employeeId = employeeId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

}
