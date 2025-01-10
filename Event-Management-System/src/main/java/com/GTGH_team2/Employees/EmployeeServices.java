package com.GTGH_team2.Employees;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServices {
	
	private List<Employee> employees = new ArrayList<Employee>();
	
	public List<Employee> addEmployee(Employee employee) {
		employees.add(employee);
		return employees;
	}
	
	public List<Employee> getAllEmployees() {
		return employees;
	}
	
	public List<Employee> removeEmployee(Integer id) {
		employees.removeIf(employee -> employee.getId() == id);
		return employees;
	}
	
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