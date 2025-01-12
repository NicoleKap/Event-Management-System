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

	public void viewEvents() {
		System.out.println("------------------------------------------------------------------------");
		if(allEvents.isEmpty() ) {
			System.out.println("There are no events");
		}else {
			System.out.println("Events");
			for (Event event : allEvents) {
				System.out.println(event + " ");
			}
		}
		
		System.out.println("------------------------------------------------------------------------");
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
			int newMaxCapacity, String newDay, String newMonth, int newYear, int newHour, int newMinute,
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
			if (newMaxCapacity != 0)
				event.setMaxCapacity(newMaxCapacity);
			if (newDay != null)
				event.setDay(newDay);
			if (newMonth != null)
				event.setTheme(newTheme);
			if (newYear != 0)
				event.setDescription(newDescription);
			if (newHour != 0)
				event.setTitle(newLocation);
			if (newMinute != 0)
				event.setMinutes(newMinute);
			if (newDuration != null) {
				event.setDuration(newDuration);
			}
		}
		return allEvents;
	}

	// Update specific attributes of an event
	
	public List<Event> updateLocation(String newLocation) {
		for(Event event : allEvents) {
			if(newLocation != null)
				event.setLocation(newLocation);
		}
		return allEvents;
		
	}
	
	// Searching for an event in the existing events list
	
	public List<Event> searchingAnEvent(String day, String month, String year, String theme) {
		List<Event> eventByCriteria = new ArrayList<>(); // The events which are found is stored in this list
		for(Event event : allEvents) {
			if(event.getDay() == day)
				eventByCriteria.add(event);
			if(event.getMonth() == month)
				eventByCriteria.add(event);
			if(event.getYear() == year)
				eventByCriteria.add(event);
			if(event.getTheme() == theme)
				eventByCriteria.add(event);		
		}
		return eventByCriteria;
		
	}
	
	// Book an event 
	
	public void boοκAnEvent(Integer id) {
		for (Event event : allEvents) { // Check if the id is part of the event list
			if (event.getId() == id && reservationServices.getReservations().size() < event.getMaxCapacity()) {
				System.out.println("The event " + event.getTitle() + " has been booked successfully");
				return; // To stop the rest of the loop
			}else if(event.getId() == id && reservationServices.getReservations().size() >= event.getMaxCapacity()) {
				System.out.println("This event is fully booked! No more reservations avalable");
				return;
			}else {
				System.out.println("This event does not exist");
			}
		}
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
