package com.GTGH_team2.Visitors;

	import java.util.ArrayList;
	import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

	@Service
	public class VisitorServices {
		
	    private List<Visitor> visitors = new ArrayList<Visitor>();

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
	    
	    //teleutaios visiotr ths listas kai pairnw to od, auksanw, enas visitor diagrafetai diagrafontai kai ta reservations
	    //2 methods delete reservations by visitor id delete reservations by event id
		
	    public List<Visitor> removeVisitor(int id) {
	    	visitors.removeIf(visitor -> visitor.getId() == id);
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
	    
	}
