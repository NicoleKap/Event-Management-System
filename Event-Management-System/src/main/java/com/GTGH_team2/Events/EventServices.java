package com.GTGH_team2.Events;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.GTGH_team2.Employees.Employee;
import com.GTGH_team2.Employees.EmployeeServices;
import com.GTGH_team2.Reservations.ReservationServices;

public class EventServices {

	private List<Event> allEvents = new ArrayList<>();

	@Autowired
	ReservationServices reservationServices;
	@Autowired
	EmployeeServices employeeServices;

	public EventServices(EmployeeServices employeeServices) {
		this.employeeServices = employeeServices;
	}

	public List<Event> getAllEvents() {
		return allEvents;
	}

	public void setAllEvents(ArrayList<Event> allEvents) {
		this.allEvents = allEvents;
	}

	public List<Event> viewApprovedEvents() {
		List<Event> approvedEvents = new ArrayList<>();
		System.out.println("------------------------------------------------------------------------");
		if(allEvents.isEmpty() ) {
			System.out.println("There are no events");
		}else {
			System.out.println("Approved Events");
			for (Event event : allEvents) {
				if(event.getStatus() == "Approved")
					approvedEvents.add(event);
					System.out.println(event + " ");
			}
		}
		System.out.println("------------------------------------------------------------------------");
		return approvedEvents;
	}

	// Add an Event to the list

	public void addEvent(Event event) {
		if (!allEvents.contains(event)) { // It checks if the list contains the event given and if not the event is added 
			allEvents.add(event);
			System.out.println("The event " + event.getTitle() + " is added!");
		} else {
			System.out.println("This event already exists in the list");
		}
	}

	// Remove an Event from the list

	public List<Event> removeEvent(Integer id) {
//		Event eventToBeRemoved = null;
//		for (Event event : allEvents) {
//			if (event.getId() == id) {
//				eventToBeRemoved = event;
//				break;
//			}
//		}
//		if (eventToBeRemoved != null) {
//			allEvents.remove(eventToBeRemoved);
//			System.out.println("The event " + eventToBeRemoved.getTitle() + " is removed successfully!");
//		} else {
//			System.out.println("The event does not exists in the list!");
//		}
		allEvents.removeIf(event -> event.getId() == id);
		return allEvents;
	}

	// Update an Event

	public List<Event> updateEvent(Integer id, String newTitle, String newTheme, String newDescription, String newLocation,
			Integer newMaxCapacity, String newDay, String newMonth, Integer newYear, Integer newHour, Integer newMinute,
			String newDuration) {
		for (Event event : allEvents) {
			if (newTitle != null)
				event.setTitle(newTitle);
			if (newTheme != null)
				event.setTheme(newTheme);
			if (newDescription != null)
				event.setDescription(newDescription);
			if (newLocation != null)
				event.setTitle(newLocation);
			if (newMaxCapacity != null)
				event.setMaxCapacity(newMaxCapacity);
			if (newDay != null)
				event.setDay(newDay);
			if (newMonth != null)
				event.setMonth(newMonth);
			if (newYear != null)
				event.setYear(newYear);
			if (newHour != null)
				event.setHour(newHour);
			if (newMinute != null)
				event.setMinutes(newMinute);
			if (newDuration != null)
				event.setDuration(newDuration);
		}
		return allEvents;
	}

	// Update specific attributes of an event
	
	public List<Event> updateLocation(Integer idEvent, String newLocation) {
		for(Event event : allEvents) {
			if(event.getId() == idEvent) {
				if(newLocation != null)
					event.setLocation(newLocation);
			}	
		}
		return allEvents;
		
	}
	
	// Update Description for a specific event
	
	public List<Event> updateDescription(Integer idEvent, String newDescription) {
		for(Event event : allEvents) {
			if(event.getId() == idEvent) {
				if(newDescription != null)
					event.setLocation(newDescription);
			}	
		}
		return allEvents;
	}
	
	public List<Event> updateDateOfEvent(Integer idEvent, String newDay, String newMonth, Integer newYear){
		for(Event event : allEvents) {
			if (newDay != null)
				event.setDay(newDay);
			if (newMonth != null)
				event.setMonth(newMonth);
			if (newYear != null)
				event.setYear(newYear);
		}
		return allEvents;
	}
	
	// Update Event Status
	
	public List<Event> updateEventStatus(Integer idEvent, String newStatus) {
		for(Event event : allEvents) {
			if(event.getId() == idEvent)
				if(newStatus!=null)
					event.setStatus(newStatus);
		}
		return allEvents;
	}
	
	// Searching for an event in the existing events list
	
	public List<Event> searchingAnEvent(String day, String month, Integer year, String theme) {
		List<Event> eventByCriteria = new ArrayList<>(); // The events which are found is stored in this list
		for(Event event : allEvents) {
			if(event.getDay() == day)
				eventByCriteria.add(event);
			if(event.getMonth() == month) {
				
			}
				eventByCriteria.add(event);
			if(event.getYear() == year)
				eventByCriteria.add(event);
			if(event.getTheme() == theme)
				eventByCriteria.add(event);		
		}
		return eventByCriteria;
		
	}
	
	// Find an event by its Id
	
	public String findEventById(Integer id) {
		for(Event event : allEvents) {
			if(event.getId().equals(id));
				return "The event with id " + id + " is found with titele " + event.getTitle();
		}
		return "The event with id " + id + " is not found";
	}
	
	// Book an event - This class is for reservation
	
	public void boοκAnEvent(Integer idEvent) {
		for (Event event : allEvents) { // Check if the id is part of the event list
			if (event.getId() == idEvent && reservationServices.getReservations().size() < event.getMaxCapacity()) {
				System.out.println("The event " + event.getTitle() + " has been booked successfully");
				return; // To stop the rest of the loop
			}else if(event.getId() == idEvent && reservationServices.getReservations().size() >= event.getMaxCapacity()) {
				System.out.println("This event is fully booked! No more reservations avalable");
				return;
			}else {
				System.out.println("This event does not exist");
			}
		}
	}
	
	// Cancel a booking
	
	public void cancelEventBooking(Integer idEvent) { // This class is for reservation
//		for(Event event : allEvents) {
//			if (event.getId() == idEvent)
//				reservationServices.getReservations().remove(event);
//		}
		allEvents.stream();
		
	}

	public void eventCancellation(Integer idEvent) {
		
	}
	
	//This method allows the Employee to delete an Event
	
	public List<Event> deleteEvent(Integer idEvent, Integer idEmployee) {
		for (Employee employee : employeeServices.getAllEmployees()) {
			if (idEmployee == employee.getId()) {
				for (Event event : allEvents) {
					if (event.getId() == idEvent) {
						removeEvent(idEvent);
					}
				}
			}
		}
		return allEvents;
	}

}
