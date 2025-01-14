package com.GTGH_team2.Reservations;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.GTGH_team2.Events.Event;
import com.GTGH_team2.Events.EventServices;
import com.GTGH_team2.Visitors.Visitor;
import com.GTGH_team2.Visitors.VisitorServices;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class ReservationServices {

	@Autowired
	private List<Reservation> reservations = new ArrayList<Reservation>();
	VisitorServices visitorServices;
	EventServices eventsServices;
	
    public List<Reservation> getReservations() {
		return reservations;
	}
    
    // Get Event Id for a reservation
    
    public Integer reservationsByEvent(Integer idReservation) {
    	Integer counter = 0;
        for (Reservation reservation : reservations) {
            if (reservation.getId().equals(idReservation)) {
            	counter++;
               
            }
        }
        return  counter; 
    }

   
    // Deletes all reservations with a specific visitor id
    public void deleteReservationsByVisitorId(Integer visitorId) {
        reservations.removeIf(reservation -> reservation.getVisitor().getId() == visitorId); //Remove reservations where the visitor matches the id
        System.out.println("All reservations for visitor with id number " + visitorId + " have been deleted!");
    }

    // Deletes all reservations with a specific event id.
    public void deleteReservationsByEventId(Integer eventId) {
        reservations.removeIf(reservation -> reservation.getEvent().getId() == eventId); //Remove reservations where the event matches the id
        System.out.println("All reservations for event with id number " + eventId + " have been deleted!");
    }

	
	//Booking an Event
   // This method allows a visitor to book an event by their IDs , it checks if the reservation already exists and creates a new one if not.
	// With title
    public boolean bookingAnEvent(int visitorId, int eventId) {
		Visitor visitor = null;
		Event event = null;
		for (Visitor v : visitorServices.getAllVisitors()) {
	        if (v.getId() == visitorId) 
	            visitor = v;
	            break;
	    }
		for (Event e : eventsServices.getAllEvents()) {
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
		for (Visitor v : visitorServices.getAllVisitors()) {
	        if (v.getId() == visitorId) 
	            visitor = v;
	            break;
	    }
		for (Event e : eventsServices.getAllEvents()) {
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
    
    public void viewAllReservations() {
		if (reservations.isEmpty()) {
			System.out.println("There are no reservations.");
		} else {
			System.out.println("Reservations: ");
			for (Reservation res : reservations) {
				System.out.println(reservations);
			}
		}
	}
    
    // QR code generator
    
    // Create QR code image
    
    public void qrCodeImage(String text,int width, int height,String filePath) throws WriterException, IOException{
    	QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height); // Matrix creation for pixels
        Path path = FileSystems.getDefault().getPath(filePath); // The path for QR code image
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    }
      
    
	
}
