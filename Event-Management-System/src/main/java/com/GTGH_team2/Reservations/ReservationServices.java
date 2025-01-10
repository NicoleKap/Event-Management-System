package com.GTGH_team2.Reservations;

import java.util.ArrayList;
import java.util.List;

import com.GTGH_team2.Events.Event;
import com.GTGH_team2.Visitors.Visitor;

public class ReservationServices {

	private List<Reservation> reservations = new ArrayList<>();
	
    public List<Reservation> getReservations() {
		return reservations;
	}
	
	//Booking an Event
	public boolean bookingAnEvent(Visitor visitor, Event event) {
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
    public boolean ReservationCanceling(Visitor visitor, Event event) {
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
