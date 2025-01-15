package com.GTGH_team2.Organizers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class OrganizerServices {

	
	private List<Organizer> organizers = new ArrayList<>(); // The organizers are stored here
	
	
	// Add an organizer to the list
	
	public List<Organizer> getOrganizers() {
		return organizers;
	}

	public void setOrganizers(List<Organizer> organizers) {
		this.organizers = organizers;
	}

	// add organizer to the list & ids generation 
	
	public List<Organizer> addOrganizer(Organizer organizer) {
		Integer newId = 1;
		if(organizers.size() > 0) {
			newId = organizers.get(organizers.size() - 1).getId() + 1;
		}
		organizer.setId(newId);
//		try {
//			organizers.add(organizer);
//		}catch(Exception e) {
//			System.out.println(e.getMessage());
//		}
		
		if (!organizers.contains(organizer)) { // It checks if the list contains the event given and if not the event is added 
			organizer.setId(newId);
			organizers.add(organizer);
			System.out.println("The organizer " + organizer.getName() + " " + organizer.getSurname()+ " is added!");
		} else {
			System.out.println("This event already exists in the list");
		}
		return organizers;
	}
	// Find the organizer by Id
	
	public Organizer findOrganizerById(Integer idOrganizer) {
		for(Organizer organizer : organizers) {
			if(organizer.getId() == idOrganizer)
				return organizer;
		}
		return null;
	}
	
	// Remove an organizer from the list

	public List<Organizer> removeOrganizer(Integer id) {
		try {
			organizers.removeIf(organizer -> organizer.getId().equals(id));
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
			
		
		return organizers;
	}
	
	// Update Organizer details
	
	public Organizer updateOrganizer(Integer id, String afmUpdated, String nameUpdated, String surnameUpdated, String descriptionUpdated) {
		for(Organizer organizer : organizers) {
			if(organizer.getId() == id) {
				if(afmUpdated != null)
					organizer.setAfm(afmUpdated);
			    if(nameUpdated != null)
			        organizer.setName(nameUpdated);
				if(surnameUpdated != null)
				    organizer.setSurname(surnameUpdated);
			    if(descriptionUpdated != null)
				    organizer.setDescription(descriptionUpdated);
			    return organizer;
			}	   
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Organizer with id " + id + " doesn't exist"); // In case the organizer not found
	}

	public List<Organizer> addOrganizers(List<Organizer> organizerList) {
		for(Organizer organizer : organizerList) {
			Integer newId = 1;
			if(organizers.size() > 0) {
				newId = organizers.get(organizers.size() - 1).getId() + 1;
			}
			organizer.setId(newId);
			organizers.add(organizer);
		}
		return organizers;
	}
	
}
