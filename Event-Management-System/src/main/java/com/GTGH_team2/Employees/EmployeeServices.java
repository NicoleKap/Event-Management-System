package com.GTGH_team2.Employees;

import java.util.ArrayList;
import java.util.List;


//The EmployeeServices class handles the employees.It adds,deletes and updates the employee.
//
public class EmployeeServices {
	
	// List to store all the Employees
	private List<Employee> employees = new ArrayList<Employee>();
	
	

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
	
	
	


}