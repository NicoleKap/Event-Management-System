package com.GTGH_team2.Employees;

import java.util.ArrayList;
import java.util.List;

import com.GTGH_team2.Events.Event;


//The EmployeeServices class handles the employees.It adds,deletes and updates the employee.
//
public class EmployeeServices {
	
	// List to store all the Employees
	private List<Employee> employees = new ArrayList<Employee>();
	
	private List<Event> deletedEvents = new ArrayList<Event>();
	

	// This method adds an Employee to the employees list
	public List<Employee> addEmployee(Employee employee) {
		if(!employees.contains(employee))
			employees.add(employee);
		return employees;
	}
	
	// This method returns the employees list
	public List<Employee> getAllEmployees() {
		return employees;
	}
	
	// This method removes an Employee to the employees list
	public List<Employee> removeEmployee(Integer id) {
		employees.removeIf(employee -> employee.getId() == id);
		return employees;
	}
	
	// This method updates the parameters of an Employee
	public List<Employee> updateEmployee(Integer id, String newName, String newSurname, String newEmail) {
		for (Employee employee : employees) {
			if (id == employee.getId()) {
				if (newName != null)
					employee.setName(newName);
				if (newSurname != null)
					employee.setSurname(newSurname);
				if (newEmail != null)
					employee.setEmail(newEmail);
			}
		}
		return employees;
	}
	
	// This returns the employee by his id
	public Employee getEmployeeById(Integer employeeId) {
		for (Employee employee : employees) {
			if (employeeId == employee.getId()) 
				return employee;
		}
		return null; 
	}
	
	// This method adds a deleted event to the deleted events list
		public List<Event> addDelEvent(Event event) {
			deletedEvents.add(event);
			return deletedEvents;
		}
	
	// This method returns the deleted events list
		public List<Event> getDeletedEvents() {
			return deletedEvents;
		}
		
		// This method returns the list of the Employee's deleted events
		public List<Event> DeletedEventsByEmployee(Integer idEmployee) {
			for (Employee employee : getAllEmployees()) {
				if (idEmployee == employee.getId()) {
					return getDeletedEvents();
				}
			}
			return null;
		}

}