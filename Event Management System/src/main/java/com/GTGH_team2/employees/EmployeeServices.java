package com.GTGH_team2.employees;

import java.util.ArrayList;
import java.util.List;

import com.GTGH_team2.ApprovalRequest;
import com.GTGH_team2.Event;

public class EmployeeServices {
	
	private List<Employee> employees = new ArrayList<Employee>();


	public void approveRequest(ApprovalRequest request) {
        if (request.getStatus().equals("Pending")) {
            request.setStatus("Approved");
            request.getEvent().setStatus("Approved");
            request.setHandledBy(this);
            request.setClosedAt(new java.util.Date());
            allRequests.add(request);
            Event.addEvent(request.getEvent());
            System.out.println("Request : " + request.getEvent().getTitle( )+ " has been approved.");
        } else {
            System.out.println("Request : " + request.getEvent().getTitle() + " is already " + request.getStatus() + ".");
        }
    }
	
	public void rejectRequest(ApprovalRequest request) {
        if (request.getStatus().equals("Pending")) {
            request.setStatus("Rejected");
            request.getEvent().setStatus("Rejected");
            request.setHandledBy(this);
            request.setClosedAt(new java.util.Date());
            allRequests.add(request);
            Event.addEvent(request.getEvent());
            System.out.println("Request : " + request.getEvent().getTitle() + " has been rejected.");
        } else {
            System.out.println("Request : " + request.getEvent().getTitle() + " is already " + request.getStatus() + ".");
        }
    }
	
	public void deleteEvent(Event event) {
	    if (Event.getAllEvents().remove(event)) {
	        System.out.println("Event: " + event.getTitle() + " has been deleted by Employee " + name + " " + surname + ".");
	    } else {
	        System.out.println("Event: " + event.getTitle() + " was not found in the list.");
	    }
	}
	
	//Method for employee to view all his previous requests
	public void viewAllRequests() {
        if (allRequests.isEmpty()) {
            System.out.println("There are no previous requests.");
        } else {
            System.out.println("Previous Requests of the employee: " + name + " " + surname + ".");
            for (ApprovalRequest request : allRequests) {
                System.out.println(request);
            }
        }
    }
	
	//Method for employee to view all the pending requests
	public void viewPendingRequests() {
        ApprovalRequest.viewAllPendingRequests(); 
    }

}
