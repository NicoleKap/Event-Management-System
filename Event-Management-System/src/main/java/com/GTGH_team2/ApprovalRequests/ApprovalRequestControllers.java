package com.GTGH_team2.ApprovalRequests;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.GTGH_team2.Employees.Employee;
import com.GTGH_team2.Employees.EmployeeServices;
import com.GTGH_team2.Events.Event;
import com.GTGH_team2.Events.EventServices;
import com.GTGH_team2.Organizers.Organizer;
import com.GTGH_team2.Organizers.OrganizerServices;

@RestController
@RequestMapping("approvalRequests")
public class ApprovalRequestControllers {
	@Autowired
	ApprovalRequestServices approvalRequestServices;
	
	@GetMapping("/allApprovalRequests")
	public List<ApprovalRequest> getAllApprovalRequest() {
		return approvalRequestServices.getApprovalRequest();
	}
 	
 	
 	@DeleteMapping("/delete")
	public List<ApprovalRequest> deleteApprovalRequest(@RequestParam Integer id ) {
		return approvalRequestServices.removeApprovalRequest(id);
	}
 	
 	@PutMapping("/update")
	public List<ApprovalRequest> updateApprovalRequest(@RequestParam Integer id, @RequestParam(required = false) String newType, @RequestParam(required = false) Event newEvent, @RequestParam(required = false) Organizer newOrganizer, @RequestParam(required = false) String newCreatedAt,
			@RequestParam(required = false) String newStatus, @RequestParam(required = false) Employee newEmployee,@RequestParam(required = false) String newClosedAt, @RequestParam(required = false) String newComments) {
		return approvalRequestServices.updateApprovalRequest(id, newType, newEvent, newOrganizer, newCreatedAt, newStatus, newEmployee,newClosedAt, newComments);
	}
 	
 	@PostMapping("/addRequest")
	public List<ApprovalRequest> makeRequestToAddorDelete(@RequestBody Integer idEvent, Integer idOrganizer, String comments,String type) {
		return approvalRequestServices.makeRequestToAddorDelete(idEvent, idOrganizer, comments, type);
	}
 	
 	@PostMapping("/handleToAdd")
	public List<ApprovalRequest> handleRequestToAdd(@RequestBody Integer idAppReq, Integer idEmployee, String status) {
		return approvalRequestServices.handleRequestToAdd(idAppReq, idEmployee, status);
	}
 	
 	@PostMapping("/handleToDelete")
	public List<ApprovalRequest> handleRequestToDelete(@RequestBody Integer idAppReq, Integer idEmployee, String status) {
		return approvalRequestServices.handleRequestToDelete(idAppReq, idEmployee, status);
	}
}
