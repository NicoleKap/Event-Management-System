package com.GTGH_team2.ApprovalRequests;

import java.util.Date;
import java.util.List;

import com.GTGH_team2.Employees.Employee;
import com.GTGH_team2.Events.Event;
import com.GTGH_team2.Organizers.Organizer;

import java.util.ArrayList;

public class ApprovalRequest {
	private Integer id;
    private String type; // Type of the request ("Add" or "Delete")
    private Event event; // The event
    private Organizer submittedBy; // The organizer who submitted the request
    private String createdAt; // Date when the request was created
    private String status; // Status of the request("Pending", "Approved", "Rejected")
    private Employee handledBy; // The employee who handles the request
    private String closedAt; // Date when the request was closed
    private String comments; 

    
    // Constructor
	public ApprovalRequest(Integer id,String type, Event event, Organizer submittedBy, String createdAt, String status,Employee handledBy, String closedAt, String comments) {
	    this.id = id;
		this.type = type;
		this.event = event;
		this.submittedBy = submittedBy;
		this.createdAt = createdAt;
		this.status = status;
		this.handledBy = handledBy;
		this.closedAt = closedAt;
		this.comments = comments;
	}
	
	
    
    // Getter and setter methods
    
	@Override
	public String toString() {
		return "ApprovalRequest [id=" + id + ", type=" + type + ", event=" + event + ", submittedBy=" + submittedBy
				+ ", createdAt=" + createdAt + ", status=" + status + ", handledBy=" + handledBy + ", closedAt="
				+ closedAt + ", comments=" + comments + "]";
	}




	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



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


	public String getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(String createdAt) {
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


	public String getClosedAt() {
		return closedAt;
	}


	public void setClosedAt(String closedAt) {
		this.closedAt = closedAt;
	}


	public String getComments() {
		return comments;
	}


	public void setComments(String comments) {
		this.comments = comments;
	}


}


