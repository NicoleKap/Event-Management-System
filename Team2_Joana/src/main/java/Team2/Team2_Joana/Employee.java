package com.GTGH_team2;

import java.util.ArrayList;
import java.util.List;

public class Employee {
	private String name;
	private String surname;
	private String email;
	/**
	 * @param name
	 * @param surname
	 * @param email
	 */
	
	public Employee(String name, String surname, String email) {
		this.name = "name";
		this.surname = surname;
		this.email = email;
	}
	
		
	public boolean disapproveEvent(String event) {
		return true;
	}
	
	public boolean approveEvent(String event) {
		return true;
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

	public List<String> getEvents() {
		return events;
	}

	public void setEvents(List<String> events) {
		this.events = events;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", surname=" + surname + ", email=" + email + ", events=" + events + "]";
	}
	
	
}
