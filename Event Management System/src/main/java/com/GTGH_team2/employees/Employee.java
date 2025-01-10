package com.GTGH_team2.employees;

import java.util.ArrayList;
import java.util.List;

import com.GTGH_team2.ApprovalRequest;

public class Employee {
	private String name; //name of the employee
	private String surname; //surname of the employee
	private String email; //email of the employee
	private List<ApprovalRequest> allRequests; //list of all the previous requests that the employee had

	// Constructor
	public Employee(String name, String surname, String email) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.allRequests = new ArrayList<>();
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

	@Override
	public String toString() {
		return "Employee [name=" + name + ", surname=" + surname + ", email=" + email + "]";
	}
}