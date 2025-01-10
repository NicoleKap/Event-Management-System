package com.GTGH_team2.ApprovalRequests;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.GTGH_team2.Employees.Employee;
import com.GTGH_team2.Employees.EmployeeServices;
import com.GTGH_team2.Events.Event;
import com.GTGH_team2.Events.EventServices;
import com.GTGH_team2.Organizers.Organizer;
import com.GTGH_team2.Organizers.OrganizerServices;

//the employee needs to see the pending requests so he can approve or reject them
public class ApprovalRequestServices {

	private List<ApprovalRequest> approvalRequests = new ArrayList<ApprovalRequest>();
	private List<ApprovalRequest> pendingRequests = new ArrayList<ApprovalRequest>(); // All requests that are pending
	private List<ApprovalRequest> approvedRequests = new ArrayList<ApprovalRequest>(); // All requests that are approved

	OrganizerServices organizerServices;
	EmployeeServices employeeServices;
	EventServices eventServices;

	public ApprovalRequestServices(OrganizerServices organizerServices, EmployeeServices employeeServices,
			EventServices eventServices) {
		this.organizerServices = organizerServices;
		this.employeeServices = employeeServices;
		this.eventServices = eventServices;
	}

	public List<ApprovalRequest> addApprovalRequest(Event event, Organizer organizer, Employee employee) {
		approvalRequests.add(new ApprovalRequest(1, null, event, organizer, null, null, employee, null, null));
		return approvalRequests;
	}

	public List<ApprovalRequest> removeApprovalRequest(Integer idRequest) {
		approvalRequests.removeIf(approvalRequest -> approvalRequest.getId() == idRequest);
		return approvalRequests;
	}

	public List<ApprovalRequest> getApprovalRequest() {
		return approvalRequests;
	}

//	public List<ApprovalRequest> approveRequest1(Integer idEvent, Integer idEmployee) {
//		for (Event event : eventServices.getAllEvents()) {
//			if (event.getId() == idEvent) {
//				for (Employee employee : employeeServices.getAllEmployees()) {
//					if (idEmployee == employee.getId()) {
//						addApprovalRequest(event, null, employee);
//					}
//				}
//			}
//		}
//		return approvalRequests;
//	} most likely wrong

	public List<ApprovalRequest> approveRequest(Integer idApprovalRequest, Integer idEmployee) {
		for (ApprovalRequest approvalRequest : getApprovalRequest()) {
			if (approvalRequest.getId() == idApprovalRequest) {
				for (Employee employee : employeeServices.getAllEmployees()) {
					if (idEmployee == employee.getId()) {
						this.approvedRequests.add(approvalRequest); // or all events immediately
						this.removePendingRequest(idApprovalRequest);
						//employee.getAllRequests().add(idApprovalRequest);
					}
				}
			}
		}
		return approvedRequests;
	}

	public List<ApprovalRequest> rejectRequest(Integer idApprovalRequest, Integer idEmployee) {
		for (Employee employee : employeeServices.getAllEmployees()) {
			if (idEmployee == employee.getId()) {
				this.removeApprovalRequest(idApprovalRequest);
				this.removePendingRequest(idApprovalRequest);
				//employee.getAllRequests().add(idApprovalRequest);
			}
		}
		return approvedRequests;
	}

	public List<ApprovalRequest> removePendingRequest(Integer idRequest) {
		pendingRequests.removeIf(approvalRequest -> approvalRequest.getId() == idRequest);
				return pendingRequests;
	}

	public void addPendingRequest(ApprovalRequest request) {
		pendingRequests.add(request);
	}

	public List<ApprovalRequest> getAllPendingRequests() {
		return pendingRequests;
	}

//	public List<ApprovalRequest> makeRequest(Integer idEvent, Integer idOrganizer, String comments) {
//		for (Event event : eventServices.getAllEvents()) {
//			if (event.getId() == idEvent) {
//				for (Organizer organizer : organizerServices.getAllOrganizers()) {
//					if (idOrganizer == organizer.getId()) {
//						addApprovalRequest(1, "Add", event, organizer, null, "Pending", null, null, comments);
//					}
//				}
//			}
//		}
//        return approvalRequests;
//    } !Need OrganizerServices

}