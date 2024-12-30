package com.GTGH_team2;

import java.util.Date;

public class ApprovalRequest {
    private String type; // Type of the request ("Add" or "Delete")
    private Event event; // The event
    private Organizer submittedBy; // The organizer who submitted the request
    private Date createdAt; // Date when the request was created
    private String status; // Status of the request("Pending", "Approved", "Rejected")
    private Employee handledBy; // The employee who handles the request
    private Date closedAt; // Date when the request was closed
    private String comments; 

    // Constructor
	public ApprovalRequest(String type, Event event, Organizer submittedBy, Date createdAt, String status) {
	    this.type = type;
		this.event = event;
		this.submittedBy = submittedBy;
		this.createdAt = createdAt;
		this.status = status;
		this.handledBy = null;
		this.closedAt = null;
		this.comments = "";
	}
	
	
    // Method to view the request details
    public void viewRequest() {
        System.out.println("Approval Request:");
        
    }


    // Getter and setter methods
    
	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public Event getEvent() {
		return event;
	}


	public void setEvent(Event event) {
		this.event = event;
	}


	public Organizer getSubmittedBy() {
		return submittedBy;
	}


	public void setSubmittedBy(Organizer submittedBy) {
		this.submittedBy = submittedBy;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Employee getHandledBy() {
		return handledBy;
	}


	public void setHandledBy(Employee handledBy) {
		this.handledBy = handledBy;
	}


	public Date getClosedAt() {
		return closedAt;
	}


	public void setClosedAt(Date closedAt) {
		this.closedAt = closedAt;
	}


	public String getComments() {
		return comments;
	}


	public void setComments(String comments) {
		this.comments = comments;
	}

}


