package com.GTGH_team2;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Employee {
	private String name; //name of the employee
	private String surname; //surname of the employee
	private String email; //email of the employee
	private List<ApprovalRequest> allRequests; //list of all the previous requests that the employee had

	// Constructor
	public Employee(String name, String surname, String email) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.allRequests = new ArrayList<>();
	}
	
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

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", surname=" + surname + ", email=" + email + "]";
	}
	
	//events services -> 
	//reservation -> make reservation (eventID ,visitorID)
	// visitor services -> apothikeuei neous visitor, (opos book)
	// visitor -> mono setters getters
	
}