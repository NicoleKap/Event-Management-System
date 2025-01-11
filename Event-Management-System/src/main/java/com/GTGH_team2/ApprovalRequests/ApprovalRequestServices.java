package com.GTGH_team2.ApprovalRequests;

import java.util.ArrayList;
import java.util.List;

import com.GTGH_team2.Employees.Employee;
import com.GTGH_team2.Employees.EmployeeServices;
import com.GTGH_team2.Events.Event;
import com.GTGH_team2.Events.EventServices;
import com.GTGH_team2.Organizers.Organizer;
import com.GTGH_team2.Organizers.OrganizerServices;

//The ApprovalRequestServices class handles the requests 
//that an organizer makes for the events. The organizer makes a request
//to add or delete an event. This request has to be approved or rejected by the 
//employee
public class ApprovalRequestServices {

	// List to store all the ApprovalRequests
	private List<ApprovalRequest> approvalRequests = new ArrayList<ApprovalRequest>();

	OrganizerServices organizerServices;
	EmployeeServices employeeServices;
	EventServices eventServices;

	public ApprovalRequestServices(OrganizerServices organizerServices, EmployeeServices employeeServices,
			EventServices eventServices) {
		this.organizerServices = organizerServices;
		this.employeeServices = employeeServices;
		this.eventServices = eventServices;
	}

	// This method creates and adds an Approval Request to the approvalRequests list
	public List<ApprovalRequest> addApprovalRequest(String type, Event event, Organizer organizer, Employee employee,
			String comments) {
		approvalRequests.add(new ApprovalRequest(1, type, event, organizer, null, null, employee, null, comments));
		return approvalRequests;
	}

	// This method removes an Approval Request from the approvalRequests list
	public List<ApprovalRequest> removeApprovalRequest(Integer idRequest) {
		approvalRequests.removeIf(approvalRequest -> approvalRequest.getId() == idRequest);
		return approvalRequests;
	}

	// This method returns the approvalRequests list
	public List<ApprovalRequest> getApprovalRequest() {
		return approvalRequests;
	}

	// This method returns only the pending requests from the approvalRequests list
	public List<ApprovalRequest> getAllPendingRequests() {
		List<ApprovalRequest> pendingRequests = new ArrayList<ApprovalRequest>(); // All requests that are pending
		for (ApprovalRequest approvalRequest : approvalRequests) {
			if (approvalRequest.getStatus() == "Pending")
				pendingRequests.add(approvalRequest);
		}
		return pendingRequests;
	}

	// This method updates the params of Approval Request
	public List<ApprovalRequest> updateApprovalRequest(Integer id, String newType, Event newEvent,
			Organizer newOrganizer, String newCreatedAt, String newStatus, Employee newEmployee, String newClosedAt,
			String newComments) {
		for (ApprovalRequest approvalRequest : approvalRequests) {
			if (id == approvalRequest.getId()) {
				if (newType != null)
					approvalRequest.setType(newType);
				if (newEvent != null)
					approvalRequest.setEvent(newEvent);
				if (newOrganizer != null)
					approvalRequest.setSubmittedBy(newOrganizer);
				if (newCreatedAt != null)
					approvalRequest.setCreatedAt(newCreatedAt);
				if (newStatus != null)
					approvalRequest.setStatus(newStatus);
				if (newEmployee != null)
					approvalRequest.setHandledBy(newEmployee);
				if (newClosedAt != null)
					approvalRequest.setClosedAt(newClosedAt);
				if (newComments != null)
					approvalRequest.setComments(newComments);
			}
		}
		return approvalRequests;
	}

	// This method updates the Employee that handles the Approval Request
	public List<ApprovalRequest> updateApprovalRequestEmployee(int idApprovalRequest, int idEmployee) {
		for (ApprovalRequest approvalRequest : approvalRequests) {
			if (idApprovalRequest == approvalRequest.getId()) {
				for (Employee employeee : employeeServices.getAllEmployees()) {
					if (employeee.getId() == idEmployee) {
						approvalRequest.setHandledBy(employeee);

					}
				}
			}
		}
		return approvalRequests;
	}

	// This method allows the Organizer to make a request to add an Event with
	// comments
	public List<ApprovalRequest> makeRequestToAdd(Integer idEvent, Integer idOrganizer, String comments) {
		for (Event event : eventServices.getAllEvents()) {
			if (event.getId() == idEvent) {
				for (Organizer organizer : organizerServices.getOrganizers()) {
					if (idOrganizer == organizer.getId()) {
						addApprovalRequest("Add", event, organizer, null, comments);
					}
				}
			}
		}
		return approvalRequests;
	}

	// This method allows the Organizer to make a request to delete an Event with
	// comments
	public List<ApprovalRequest> makeRequestToDelete(Integer idEvent, Integer idOrganizer, String comments) {
		for (Event event : eventServices.getAllEvents()) {
			if (event.getId() == idEvent) {
				for (Organizer organizer : organizerServices.getOrganizers()) {
					if (idOrganizer == organizer.getId()) {
						addApprovalRequest("Delete", event, organizer, null, comments);
						eventServices.removeEvent(idEvent); // deletes the event
					}
				}
			}
		}
		return approvalRequests;
	}

	// This method allows the Employee to approve a request and adds it to his list
	// of the request he has handled
	public List<ApprovalRequest> approveRequest(Integer idApprovalRequest, Integer idEmployee) {
		for (ApprovalRequest approvalRequest : getApprovalRequest()) {
			if (approvalRequest.getId() == idApprovalRequest) {
				for (Employee employee : employeeServices.getAllEmployees()) {
					if (idEmployee == employee.getId()) {
						updateApprovalRequestEmployee(idApprovalRequest, idEmployee);// maybe not needed QUESTION
						updateApprovalRequest(idApprovalRequest, null, null, null, null, "Approved", null, "timeClosed",
								null);
						employee.getAllRequests().add(approvalRequest);
						eventServices.addEvent(approvalRequest.getEvent()); // add the event
					}
				}
			}
		}
		return approvalRequests;
	}

	// This method allows the Employee to reject a request
	public List<ApprovalRequest> rejectRequest(Integer idApprovalRequest, Integer idEmployee) {
		for (ApprovalRequest approvalRequest : getApprovalRequest()) {
			if (approvalRequest.getId() == idApprovalRequest) {
				for (Employee employee : employeeServices.getAllEmployees()) {
					if (idEmployee == employee.getId()) {
						updateApprovalRequestEmployee(idApprovalRequest, idEmployee);// maybe not needed QUESTION
						updateApprovalRequest(idApprovalRequest, null, null, null, null, "Rejected", null, "timeClosed",
								null);
						employee.getAllRequests().add(approvalRequest);
					}
				}
			}
		}
		return approvalRequests;
	}

	// This method allows the Employee to accept or reject a request. updatedStatus
	// is "Accepted" or "Rejected"
	public List<ApprovalRequest> handleRequest(Integer idApprovalRequest, Integer idEmployee, String updatedStatus) {
		for (ApprovalRequest approvalRequest : getApprovalRequest()) {
			if (approvalRequest.getId() == idApprovalRequest) {
				for (Employee employee : employeeServices.getAllEmployees()) {
					if (idEmployee == employee.getId()) {
						updateApprovalRequestEmployee(idApprovalRequest, idEmployee);// maybe not needed QUESTION
						updateApprovalRequest(idApprovalRequest, null, null, null, null, updatedStatus, null,
								"timeClosed", null);
						employee.getAllRequests().add(approvalRequest);
					}
				}
			}
		}
		return approvalRequests;
	}

	// Method to add each request that the employee handled
	public List<Employee> addRequestForEmployee(int idEmployee, int idRequest) {
		for (Employee employee : employeeServices.getAllEmployees()) {
			if (idEmployee == employee.getId()) {
				for (ApprovalRequest approvalRequest : approvalRequests) {
					if (approvalRequest.getId() == idRequest) {
						employee.addRequest(approvalRequest);
					}
				}
			}
		}
		return employeeServices.getAllEmployees();
	}

}