package com.GTGH_team2.Events;

import java.util.ArrayList;

import com.GTGH_team2.Visitors.Visitor;

public class EventServices {

	private static ArrayList<Event> allEvents = new ArrayList<>();
	private ArrayList<Visitor> participants = new ArrayList<>();
	
	public static ArrayList<Event> getAllEvents() {
		return allEvents;
	}

	public static void setAllEvents(ArrayList<Event> allEvents) {
		EventServices.allEvents = allEvents;
	}

	public void setParticipants(ArrayList<Visitor> participants) {
		this.participants = participants;
	}

	 public ArrayList<Visitor> getParticipants() {
			return participants;
		}
	    
	// Add an Event to the list
	 
    public void addEvent(Event event) {
        allEvents.add(event);
        System.out.println("The event " + event.getTitle() + " is added!");
    }

    // Remove an Event from the list
    
    public void removeEvent(int id) {
    	Event eventToBeRemoved = null;
    	for(Event event : allEvents) {
    		if(event.getId() == id) {
    			eventToBeRemoved = event;
    			break;
    		}
    		if(eventToBeRemoved != null) {
    			allEvents.remove(eventToBeRemoved);
    			System.out.println("The event " + eventToBeRemoved.getTitle() + " is removed successfully!");
    		}else {
    			System.out.println("The event does not exists in the list!");
    		}
    	}   
    }
    
    // Update an Event
    
    public void updateEvent(int id, String newTitle, String newTheme, String newDescription, String newLocation, int newMaxCapacity, String newDay, String newMonth, int newYear, int newHour, int newMinute, String newDuration) {
    	for(Event event : allEvents) {
    		if(newTitle != null)
    			event.setTitle(newTitle);
    		if(newTheme != null)
    			event.setTheme(newTheme);
    		if(newDescription != null)
    			event.setDescription(newDescription);
    		if(newLocation != null)
    			event.setTitle(newLocation);
    		if(newMaxCapacity != 0)
    			event.setMaxCapacity(newMaxCapacity);
    		if(newDay!= null) 
    			event.setDay(newDay);
    		if(newMonth != null)
    			event.setTheme(newTheme);
    		if(newYear != 0)
    			event.setDescription(newDescription);
    		if(newHour != 0)
    			event.setTitle(newLocation);
    		if(newMinute != 0)
    			event.setMinutes(newMinute);
    		if(newDuration!= null) {
    			event.setDuration(newDuration);
    		}
    	}
    }
    
    // Add a participant to the list
    
	public void addParticipant(Visitor visitor) {
        if (!participants.contains(visitor)) {
            participants.add(visitor);
        }
    }
	
	// Update a participant in the list
	
	public void updateParticipant(String newName, String newSurname, String newEmail) {
		for(Visitor participant : participants) {
			if(newName!= null)
				participant.setName(newName);
			if(newSurname!= null)
				participant.setSurname(newSurname);
			if(newEmail!= null)
				participant.setEmail(newEmail);
		}
	}
}
