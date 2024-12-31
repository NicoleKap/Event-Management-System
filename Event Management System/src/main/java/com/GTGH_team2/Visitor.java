package com.GTGH_team2;

import java.util.ArrayList;

import org.w3c.dom.events.Event;

class Visitor {
	private String name;
    private String surname;
    private String email;
    private ArrayList<Event> events = new ArrayList<>();
    
    
    public Visitor(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public ArrayList<Event> getEvents() {
        return events;
    }
    
    //anazhthsh ekdhlwsewn 
    public ArrayList<Event> EventsSearching(ArrayList<Event> events, String day, String location, String theme) {
    	ArrayList<Event> specificEvents = new ArrayList<>();
        for (Event event : events) {
            if ((day == null || event.getDay().equals(day)) &&
                (location == null || event.getLocation().equals(location)) &&
                (theme == null || event.getTheme().equals(theme))) {
                specificEvents.add(event);
            }
        }
        return specificEvents;
    }
    
    //krahthsh ekdhlwshs
    public boolean bookingAnEvent(Event event) {
    	if ( events.contains(event)) {
    		events.add(event);
    		System.out.println("The booking for the event " + event.getTitle() + " is done!");	
            return true;
        } else {
            System.out.println(" You have already booked that event " + event.getTitle() );
            return false;
        }
    }
    
    //akurwsh krathshs
    public boolean ReservationCanceling(Event event) {
    	if ( events.contains(event)) {
    		events.remove(event);
    		System.out.println("The booking for the event " + event.getTitle() + " is deleted!");
            return true;
    	} else {
            System.out.println("The booking " + event.getTitle() + " can not be found in the system!");
            return false;
        }
    }
    
}

