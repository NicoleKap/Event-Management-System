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
	private List<ApprovalRequest> allPendingRequests = new ArrayList<ApprovalRequest>(); // All requests that are pending
	private List<ApprovalRequest> allApprovedRequests = new ArrayList<ApprovalRequest>(); // All requests that are approved
	
	OrganizerServices organizerServices;
	EmployeeServices employeeServices;
	EventServices eventServices;

	
	public ApprovalRequestServices(OrganizerServices organizerServices, EmployeeServices employeeServices) {
		this.organizerServices = organizerServices;
		this.employeeServices = employeeServices;
	}


	public List<ApprovalRequest> addApprovalRequest(Event event, Organizer organizer, Employee employee) {
		approvalRequests.add(new ApprovalRequest(1,null, event, organizer, null, null,employee, null, null));
		return approvalRequests;
	}

	public List<ApprovalRequest> removeApprovalRequest(Integer idRequest) {
		approvalRequests.removeIf(approvalRequest -> approvalRequest.getId() == idRequest);
		return approvalRequests;
	}
	
	public List<ApprovalRequest> approveRequest(Integer idEvent, Integer idEmployee) {
		for (Event event : eventServices.getAllEvents()) {
			if (event.getId() == idEvent) {
				for (Employee employee : employeeServices.getAllEmployees()) {
					if (idEmployee == employee.getId()) {
						addApprovalRequest(event, null, employee);
					}
				}
			}
		}
        return approvalRequests;
    }
	
//	public List<ApprovalRequest> makeRequest(Integer idEvent, Integer idOrganizer) {
//		for (Event event : eventServices.getAllEvents()) {
//			if (event.getId() == idEvent) {
//				for (Organizer organizer : organizerServices.getAllOrganizers()) {
//					if (idEmployee == employee.getId()) {
//						addApprovalRequest(event, null, employee);
//					}
//				}
//			}
//		}
//        return approvalRequests;
//    }
//	
//
//	
//	public void addPendingRequest(ApprovalRequest request) {
//		if(request.getStatus().equalsIgnoreCase("Pending"));
//			allPendingRequests.add(request);
//	}
//	
//	public List<ApprovalRequest> getAllPendingRequests() {
//		return allPendingRequests;
//	}
//	
//	public List<ApprovalRequest> removePendingRequest(ApprovalRequest request) {
//		allPendingRequests.remove(request);
//		return allPendingRequests;
//	}
//	
//	
//	public void addApprovalRequest(ApprovalRequest request) {
//		allApprovalRequests.add(request);
//	}
//	
//	public List<ApprovalRequest> getAllApprovalRequests() {
//		return allApprovalRequests;
//	}
//	
//	public List<ApprovalRequest> removeApprovalRequest(ApprovalRequest request) {
//		allApprovalRequests.remove(request);
//		return allApprovalRequests;
//	}
	
	

}