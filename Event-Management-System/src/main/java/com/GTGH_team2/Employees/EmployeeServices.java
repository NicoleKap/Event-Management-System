package com.GTGH_team2.Employees;

import java.util.ArrayList;
import java.util.List;

import com.GTGH_team2.ApprovalRequests.ApprovalRequest;
import com.GTGH_team2.ApprovalRequests.ApprovalRequestServices;

//The EmployeeServices class handles the employees.It adds,deletes and updates the employee.
//
public class EmployeeServices {
	
	// List to store all the Employees
	private List<Employee> employees = new ArrayList<Employee>();
	
	
	ApprovalRequestServices approvalRequestServices;
	
	public EmployeeServices(ApprovalRequestServices approvalRequestServices) {
		this.approvalRequestServices = approvalRequestServices;
	}
	
	// This method adds an Employee to the employees list
	public List<Employee> addEmployee(Employee employee) {
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
	
	// This method updates the params of an Employee
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
	
	//Method to add each request that the employee handled
	public List<Employee> addRequestForEmployee(int idEmployee, int idRequest) {
		for (Employee employee : employees) {
			if (idEmployee == employee.getId()) {
				for (ApprovalRequest approvalRequest : approvalRequestServices.getApprovalRequest()) {
					if (approvalRequest.getId() == idRequest) {
						employee.addRequest(approvalRequest);
					}
				}
			}
		}
		return employees;
	}
	
	
	
	//Method to implement in event
//	public List<event> deleteEvent(Integer idEvent, Integer idEmployee) {
//		for (Employee employee : employees) {
//			if (idEmployee == employee.getId()) {
//				for (Event event : events) {
//					if (event.getId() == idEvent) {
//						removeEvent(idEvent);
//					}
//				}
//			}
//		}
//		return events;
//	}


}