package com.GTGH_team2;

import com.GTGH_team2.approvalRequests.ApprovalRequest;

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
	
	public void approveEvent(Event event) {
	    if (event.getStatus().equals("Pending")) {
	    	event.setStatus("Approved");
	        System.out.println("Event : " + event.getTitle() + " has been approved.");
	        } 
	    else {
	         System.out.println("Event: " + event.getTitle() + " is already " + event.getStatus() + ".");
		    }
	}
	
	public void rejectEvent(Event event) {
	    if (event.getStatus().equals("Pending")) {
	    	event.setStatus("Rejected");
	        System.out.println("Event : " + event.getTitle() + " has been rejected.");
	        } 
	    else {
         System.out.println("Event: " + event.getTitle() + " is already " + event.getStatus() + ".");
	    }
	}
	
	public void deleteEvent(Event event) {
	    if (Event.getAllEvents().remove(event)) {
	        System.out.println("Event: " + event.getTitle() + " has been deleted by Employee " + name + " " + surname + ".");
	    } else {
	        System.out.println("Event: " + event.getTitle() + " was not found in the list.");
	    }
	}
	
	public void viewAllRequests() {
        if (allRequests.isEmpty()) {
            System.out.println("There are no previous requests.");
        } else {
            System.out.println("Previous Requests:");
            for (ApprovalRequest request : allRequests) {
                System.out.println(request);
            }
        }
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
	
	
}
