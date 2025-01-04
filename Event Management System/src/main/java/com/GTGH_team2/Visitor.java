package com.GTGH_team2;

import java.util.ArrayList;

class Visitor {
	private String name;
    private String surname;
    private String email;
    private ArrayList<Reservation> reservations = new ArrayList<>();
    
    
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
    
    
    //anazhthsh ekdhlwsewn 
    public ArrayList<Event> EventsSearching(ArrayList<Event> events, String day, String location, String theme) {
    	ArrayList<Event> specificEvents = new ArrayList<>(); //ekdhlwseis pou plhroun ta krithria
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
    	for ( Reservation res : reservations) {
    		if ( res.getEvent().equals(event)) {
    			System.out.println(" You have already booked that event " + event.getTitle() );
                return false;
    		}
    	} 
    	Reservation newReservation = new Reservation(this, event);
    		reservations.add(newReservation);
    		System.out.println("The booking for the event " + event.getTitle() + " is done!");	
            return true;
        } 
    
    //akurwsh krathshs
    public boolean ReservationCanceling(Event event) {
    	for ( Reservation res : reservations) {
    		if ( res.getEvent().equals(event)) {
    			reservations.remove(res);
    			System.out.println("The booking for the event " + event.getTitle() + " is deleted!");
                return true;
    		} 
    	}
            System.out.println("The booking " + event.getTitle() + " can not be found in the system!");
            return false;
        }
    }
    


