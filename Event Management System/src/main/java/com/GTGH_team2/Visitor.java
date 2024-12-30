package com.GTGH_team2;

import java.util.ArrayList;

import org.w3c.dom.events.Event;

class Visitor {
	private String name;
    private String surname;
    private StringEventl;
    private ArrayList<Event> events;
    
    public Visitor(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.events = new ArrayList<>();
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
    public ArrayList<Event> EventsSearching(ArrayList<Event> events, String date, String location, String theme) {
    	
    }
    
    //krahthsh ekdhlwshs
    public boolean bookingAnEvent(Event event) {
    	if ( events.contains(event)) {
    		events.add(event);
    		System.out.println("Η κράτηση για την εκδήλωση " + event.getName() + " ολοκληρώθηκε!");
            return true;
        } else {
            System.out.println("Έχετε ήδη κάνει κράτηση για την συγκεκριμένη εκδήλωση " + event.getName());
            return false;
        }
    }
    
    //akurwsh krathshs
    public String ReservationCanceling() {
    	if ( events.contains(events)) {
    		events.remove(events)
    		System.out.println("Η κράτηση για την εκδήλωση " + event.getName() + " διαγράφτηκε!");
            return true;
    	} else {
            System.out.println("Η κράτηση " + event.getName() + " δεν βρίσκεται στο σύστημα!");
            return false;
        }
    }
    
}

