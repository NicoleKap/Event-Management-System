package com.GTGH_team2.Organizers;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.GTGH_team2.Events.Event;

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
	
	// Remove an organizer from the list

	public List<Organizer> removeOrganizer(Integer id) {
		organizers.removeIf(organizer -> organizer.getId() == id);
		//cancel events, delete reservations
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
