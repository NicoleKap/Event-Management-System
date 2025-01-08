package com.GTGH_team2;

import java.util.ArrayList;
import java.util.Objects;

public class Organizer {
    private final String afm;
    private String name;
    private String surname;
    private String description;
    private Event events;
    private final ArrayList<Event> eventsListByOrganizer = new ArrayList<>(); // The events are stored here

    // Constructor

    public Organizer(String afm, String name, String surname, String description) {
        this.afm = afm;
        this.name = name;
        this.surname = surname;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDescription() {
        return description;
    }

    // A list of the Events by organizer

    public void viewEvents() {
        System.out.println("------------------------------------------------------------------------");
        System.out.println("Events organized by " + name + " " + surname);
        for( Event event : eventsListByOrganizer) {
            System.out.println(event +" ");
        }
        System.out.println("------------------------------------------------------------------------");
    }

    // The Organizer can create a new Event
    
    public void addEvent(Event event) {
        // Check if the event already exists or the event is null
        if(event != null && !eventsListByOrganizer.contains(event)) {
            if(Objects.equals(event.getStatus(), "Approved")){
                this.eventsListByOrganizer.add(event);
                event.addEvent(event);
                System.out.println("The organizer " + name + " created the event " + event.getTitle());
            }else if(Objects.equals(event.getStatus(), "Pending")) {
                System.out.println("The approval is pending!");
            }else {
                System.out.println("This event is not approved!");
            }
        }else if (eventsListByOrganizer.contains(event)){
            System.out.println("This event already exists in the list");
        }else {
            System.out.println("This event is empty");
        }
    }

    // The Organizer can delete an existing Event

    public void deleteEvent(Event event) {
        if(eventsListByOrganizer.contains(event)) {
            if(Objects.equals(event.getStatus(), "Approved")) {
                this.eventsListByOrganizer.remove(event);
                event.removeEvent(event);
                System.out.println("The event " + event.getTitle() + " is successfully deleted by " + name);
            }else if(Objects.equals(event.getStatus(), "Pending")) {
                System.out.println("The approval is pending!");
            }
            else {
                System.out.println("This event is not approved!");
            }
        }else {
            System.out.println("The event " + event.getTitle() + " is not found in the list");
        }


    }

    // It returns the name and the surname of the Organizer

    @Override
    public String toString() {
        return name + " " + surname;
    }


    public String getAfm() {
        return afm;
    }
}

