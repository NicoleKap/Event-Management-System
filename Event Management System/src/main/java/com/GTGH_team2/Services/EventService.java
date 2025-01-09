package com.GTGH_team2.Services;

import java.util.ArrayList;

import com.GTGH_team2.Entities.Event;
import com.GTGH_team2.Entities.Visitor;

public class EventService {

	private static final ArrayList<Event> allEvents = new ArrayList<>();
    private ArrayList<Visitor> participants = new ArrayList<>();

    public ArrayList<Visitor> getParticipants() {
		return participants;
	}

	public void setParticipants(ArrayList<Visitor> participants) {
		this.participants = participants;
	}

	public static ArrayList<Event> getAllevents() {
		return allEvents;
	}

    public void addEvent(Event event) {
        allEvents.add(event);
    }

    public void removeEvent(Event event) {
        allEvents.remove(event);
    }

    public static ArrayList<Event> viewEvents() {
        return allEvents;
    }
    
	public void addParticipant(Visitor visitor) {
        if (!participants.contains(visitor)) {
            participants.add(visitor);
        }
    }
}
