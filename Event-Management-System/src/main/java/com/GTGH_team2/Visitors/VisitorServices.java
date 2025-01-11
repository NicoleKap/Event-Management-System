package com.GTGH_team2.Visitors;

	import java.util.ArrayList;
	import java.util.List;

import org.springframework.stereotype.Service;

	@Service
	public class VisitorServices {
	    private List<Visitor> visitors = new ArrayList<Visitor>();
	    private List<Visitor> participants = new ArrayList<Visitor>();

	    public List<Visitor> getVisitors() {
			return visitors;
		}

		public List<Visitor> getAllVisitors() {
	        return visitors;
	    }

	    public List<Visitor> addVisitor(Visitor visitor) {
	        visitors.add(visitor);
	        return visitors;
	    }
		
	    public List<Visitor> removeVisitor(int id) {
	    	visitors.removeIf(visitor -> visitor.getId() == id);
	    	//remove reservations of visitor
	        return visitors;
	    }
	  
	    public List<Visitor> updateVisitor(int id, String newName, String newSurname, String newEmail) {
	        for (Visitor visitor : visitors) {
	            if (id == visitor.getId()) {
	                if (newName != null)
	                	visitor.setName(newName);
	                if (newSurname != null) 
	                	visitor.setSurname(newSurname);
	                if (newEmail != null)
	                	visitor.setEmail(newEmail);
	            }
	        }
	        return visitors;
	    }
	    
	    //Add a participant to the list
	    public void addParticipant(Visitor visitor) {
	    	if(!participants.contains(visitor)) {
	    	participants.add(visitor);
	    	}
	    }
	    
	    //Update a participant in the list
	    public void updateParticipant(int id, String newName, String newSurname, String newEmail) {
		       for(Visitor participant : participants)
		            if (id == participant.getId()) { 
		                if (newName != null)
		                	participant.setName(newName); 
		                if (newSurname != null) 
		                	participant.setSurname(newSurname);
		                if (newEmail != null)
		                	participant.setEmail(newEmail);
		            }
	    }
	}
