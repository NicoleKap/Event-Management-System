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

	public List<Organizer> addOrganizer(Organizer organizer) {
		organizers.add(organizer);
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
		organizers.removeIf(organizer -> organizer.getId() == id);
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
				    organizer.setName(surnameUpdated);
			    if(descriptionUpdated != null)
				    organizer.setName(descriptionUpdated);
			    return organizer;
			}	   
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Organizer with id " + id + " doesn't exist"); // In case the organizer not found
	}
	
}
