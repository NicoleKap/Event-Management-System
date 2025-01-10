package com.GTGH_team2.Employees;

import java.util.ArrayList;
import java.util.List;

import com.GTGH_team2.ApprovalRequests.ApprovalRequest;
import com.GTGH_team2.ApprovalRequests.ApprovalRequestServices;

public class EmployeeServices {
	
	ApprovalRequestServices approvalRequestServices;
	private List<Employee> employees = new ArrayList<Employee>();
	
	public EmployeeServices(ApprovalRequestServices approvalRequestServices) {
		this.approvalRequestServices = approvalRequestServices;
	}

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
	
	public List<ApprovalRequest> getAllRequests(Employee employee) {
		return employee.getAllRequests();
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