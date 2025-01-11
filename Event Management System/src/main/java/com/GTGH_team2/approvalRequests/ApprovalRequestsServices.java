package com.GTGH_team2.approvalRequests;

import java.util.ArrayList;
import java.util.List;
//the employee needs to see the pending requests so he can approve or reject them
public class ApprovalRequestsServices {

	private List<ApprovalRequest> allPendingRequests = new ArrayList<ApprovalRequest>(); // All requests that are pending
	private List<ApprovalRequest> allApprovalRequests = new ArrayList<ApprovalRequest>(); // All approval requests
	
	public void viewAllPendingRequests() {
		if (allPendingRequests.isEmpty()) {
			System.out.println("There are no pending requests.");
		} else {
			System.out.println("Pending requests:");
			for (ApprovalRequest request : allPendingRequests) {
				System.out.println(request);
			}
		}
	}

	public void addPendingRequest(ApprovalRequest request) {
		if(request.getStatus().equalsIgnoreCase("Pending"));
			allPendingRequests.add(request);
	}
	
	public List<ApprovalRequest> getAllPendingRequests() {
		return allPendingRequests;
	}
	
	public List<ApprovalRequest> removePendingRequest(ApprovalRequest request) {
		allPendingRequests.remove(request);
		return allPendingRequests;
	}
	
	
	public void addApprovalRequest(ApprovalRequest request) {
		allApprovalRequests.add(request);
	}
	
	public List<ApprovalRequest> getAllApprovalRequests() {
		return allApprovalRequests;
	}
	
	public List<ApprovalRequest> removeApprovalRequest(ApprovalRequest request) {
		allApprovalRequests.remove(request);
		return allApprovalRequests;
	}
	
	

}
