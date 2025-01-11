package com.GTGH_team2.Employees;

import java.util.ArrayList;
import java.util.List;

import com.GTGH_team2.ApprovalRequests.ApprovalRequest;

public class Employee {
	private Integer id; //id of the employee
	private String name; //name of the employee
	private String surname; //surname of the employee
	private String email; //email of the employee
	private List<ApprovalRequest> allRequests; //list of all the previous requests that the employee had

	// Constructor
	public Employee(Integer id,String name, String surname, String email) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.allRequests = new ArrayList<>();
	}
		
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	public List<ApprovalRequest> getAllRequests() {
		return allRequests;
	}

	public void addRequest(ApprovalRequest approvalRequest) {
		allRequests.add(approvalRequest);
		
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", surname=" + surname + ", email=" + email + ", allRequests="
				+ allRequests + "]";
	}

	

}