package com.GTGH_team2.Reservations;

import java.util.ArrayList;
import java.util.List;

import com.GTGH_team2.Events.Event;
import com.GTGH_team2.Visitors.Visitor;

public class ReservationServices {

	private List<Reservation> reservations = new ArrayList<Reservation>();
	private List<Visitor> visitors = new ArrayList<Visitor>();
	private List<Event> events = new ArrayList<Event>();
	
    public List<Reservation> getReservations() {
		return reservations;
	}
	
	//Booking an Event
   // This method allows a visitor to book an event by their IDs , it checks if the reservation already exists and creates a new one if not.
	public boolean bookingAnEvent(int visitorId, int eventId) {
		Visitor visitor = null;
		Event event = null;
		for (Visitor v : visitors) {
	        if (v.getId() == visitorId) 
	            visitor = v;
	            break;
	    }
		for (Event e : events) {
	        if (e.getId() == eventId) 
	            event = e;
	            break;
	    }
		if (visitor == null || event == null) {
		        System.out.println("Visitor or Event not found!");
		        return false;
		}
        for (Reservation res : reservations) {
            if (res.getEvent().equals(event) && res.getVisitor().equals(visitor)) {
                System.out.println("You have already booked this event: " + event.getTitle());
                return false;
            }
        }
        Reservation newReservation = new Reservation(visitor, event);
        reservations.add(newReservation);
        System.out.println("The booking for the event " + event.getTitle() + " is done!");
        return true;
    }

	// Canceling an Event
	// This method allows a visitor to cancel a booking for a specific event by their IDs, it checks if the reservation exists and removes it if found
    public boolean ReservationCanceling(int visitorId, int eventId) {
		Visitor visitor = null;
		Event event = null;
		for (Visitor v : visitors) {
	        if (v.getId() == visitorId) 
	            visitor = v;
	            break;
	    }
		for (Event e : events) {
	        if (e.getId() == eventId) 
	            event = e;
	            break;
	    }
		if (visitor == null || event == null) {
		        System.out.println("Visitor or Event not found!");
		        return false;
		}
        for (Reservation res : reservations) {
            if (res.getEvent().equals(event) && res.getVisitor().equals(visitor)) {
                reservations.remove(res);
                System.out.println("The booking for the event " + event.getTitle() + " is deleted!");
                return true;
            }
        }
        System.out.println("The booking for the event " + event.getTitle() + " can not be found in the system!");
        return false;
    }
	
}
