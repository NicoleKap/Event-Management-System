package com.GTGH_team2.Organizers;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.GTGH_team2.Events.Event;

public class OrganizerServices {

	private List<Organizer> organizers = new ArrayList<>(); // The organizers are stored here
	
	// Add an organizer to the list
	
	public List<Organizer> addOrganizer(Organizer organizer) {
		organizers.add(organizer);
		return organizers;
		
	}

	public List<Organizer> removeOrganizer(Integer id) {
		organizers.removeIf(organizer -> organizer.getId() == id);
		return organizers;
	}
	
}
