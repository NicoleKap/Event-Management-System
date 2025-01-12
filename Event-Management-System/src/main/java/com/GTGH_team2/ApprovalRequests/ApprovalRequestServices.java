package com.GTGH_team2.ApprovalRequests;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
@Service
public class ApprovalRequestServices {

	// List to store all the ApprovalRequests
	private List<ApprovalRequest> approvalRequests = new ArrayList<ApprovalRequest>();
	@Autowired
	OrganizerServices organizerServices;
	@Autowired
	EmployeeServices employeeServices;
	@Autowired
	EventServices eventServices;

	DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss a");

    
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

	// This method updates the parameters of Approval Request
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

	// This method assigns the Employee that handles the Approval Request
	public List<ApprovalRequest> assignApprovalRequestEmployee(int idApprovalRequest, int idEmployee) {
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

	// This method updates the status of the Approval Request. status is "Accepted"
	// or "Rejected"
	public List<ApprovalRequest> updateApprovalRequestStatus(int idApprovalRequest, String newStatus) {
		for (ApprovalRequest approvalRequest : approvalRequests) {
			if (idApprovalRequest == approvalRequest.getId()) {
				if (newStatus != null)
					approvalRequest.setStatus(newStatus);
			}
		}
		return approvalRequests;
	}

	// This method updates the time and date that Approval Request is closed at.
	public List<ApprovalRequest> updateApprovalRequestClosedAt(int idApprovalRequest, String newClosedAt) {
		for (ApprovalRequest approvalRequest : approvalRequests) {
			if (idApprovalRequest == approvalRequest.getId()) {
				if (newClosedAt != null)
					approvalRequest.setClosedAt(newClosedAt);
			}
		}
		return approvalRequests;
	}

	// This method allows the Organizer to make a request to add or delete an Event
	// with comments. type is "Add" or "Delete"
	public List<ApprovalRequest> makeRequestToAddorDelete(Integer idEvent, Integer idOrganizer, String comments,
			String type) {
		for (Event event : eventServices.getAllEvents()) {
			if (event.getId() == idEvent) {
				for (Organizer organizer : organizerServices.getOrganizers()) {
					if (idOrganizer == organizer.getId()) {
						addApprovalRequest(type, event, organizer, null, comments);
					}
				}
			}
		}
		return approvalRequests;
	}

	// This method allows the Employee to accept or reject a request to add an
	// event. updatedStatus
	// is "Accepted" or "Rejected"
	public List<ApprovalRequest> handleRequestToAdd(Integer idApprovalRequest, Integer idEmployee,
			String updatedStatus) {
		for (ApprovalRequest approvalRequest : getApprovalRequest()) {
			if (approvalRequest.getId() == idApprovalRequest) {
				Employee employee = employeeServices.getEmployeeById(idEmployee);
				employee.getAllRequests().add(approvalRequest);
				assignApprovalRequestEmployee(idApprovalRequest, idEmployee);
				updateApprovalRequestStatus(idApprovalRequest, updatedStatus);
				// Creating an object of LocalDateTime class
			    // and getting local date and time using now() method
				LocalDateTime time = LocalDateTime.now();
			    // Formatting LocalDateTime to string
				String timeClosed = time.format(formatter);
				updateApprovalRequestClosedAt(idApprovalRequest, timeClosed);
				if (updatedStatus == "Accepted")
					eventServices.updateEventStatus(getEventID(idApprovalRequest), updatedStatus);
			}

		}
		return approvalRequests;
	}

	// This method allows the Employee to approve or reject a request to delete an
	// Event. updatedStatus is "Accepted" or "Rejected"
	public List<ApprovalRequest> handleRequestToDelete(Integer idApprovalRequest, Integer idEmployee,
			String updatedStatus) {
		for (ApprovalRequest approvalRequest : getApprovalRequest()) {
			if (approvalRequest.getId() == idApprovalRequest) {
				for (Employee employee : employeeServices.getAllEmployees()) {
					if (idEmployee == employee.getId()) {
						assignApprovalRequestEmployee(idApprovalRequest, idEmployee);// maybe not needed QUESTION
						updateApprovalRequestStatus(idApprovalRequest, updatedStatus);
						// Creating an object of LocalDateTime class
					    // and getting local date and time using now() method
						LocalDateTime time = LocalDateTime.now();
					    // Formatting LocalDateTime to string
						String timeClosed = time.format(formatter);
						updateApprovalRequestClosedAt(idApprovalRequest, timeClosed);
						employee.getAllRequests().add(approvalRequest);
						if (updatedStatus == "Accepted")
							eventServices.updateEventStatus(getEventID(idApprovalRequest), updatedStatus);

					}
				}
			}
		}
		return approvalRequests;
	}

	// Method to add each request that the employee handled to the employee's
	// allRequests list
	public List<Employee> addRequestForEmployee(Integer idEmployee, Integer idRequest) {
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
	
	//This method returns the ID of the event that is in the request
	public Integer getEventID (Integer idApprovalRequest) {
		for (ApprovalRequest approvalRequest : getApprovalRequest()) {
			if (approvalRequest.getId() == idApprovalRequest) 
				return approvalRequest.getEvent().getId();
			}
		return null;
	}
	
	
}