package com.GTGH_team2;

import java.util.ArrayList;

class Organizer {
    private String afm;
    private String name;
    private String surname;
    private String description;
    private Event events;
    private final ArrayList<Event> eventsList = new ArrayList<>(); // The events are stored here

    // Constructor

    public Organizer(String afm, String name, String surname, String description) {
        this.afm = afm;
        this.name = name;
        this.surname = surname;
        this.description = description;
    }

    public ArrayList<Event> getEventsList() {
        return eventsList;
    }

    // A list of the Events by organizer

    public void viewEvents() {
        System.out.println("------------------------------------------------------------------------");
        System.out.println("Events organized by " + name + " " + surname);
        for( Event event : eventsList) {
            System.out.println(event +" ");
        }
        System.out.println("------------------------------------------------------------------------");

    }


    // The Organizer can create a new Event
    
    public void addEvent(Event event) {
        // Check if the event already exists or the event is null
        if(event != null && !eventsList.contains(event)) {
            this.eventsList.add(event);
            System.out.println("The organizer " + name + " created the event " + event.getTitle());
        }else if (eventsList.contains(event)){
            System.out.println("This event already exists in the list");
        }else {
            System.out.println("This event is empty");
        }


    }

    // The Organizer can delete an existing Event

    public void deleteEvent(Event event) {
        if(eventsList.contains(event)) {
            this.eventsList.remove(event);
            System.out.println("The event " + event.getTitle() + " is successfully deleted by " + name);
        }else {
            System.out.println("The event " + event.getTitle() + " is not found in the list");
        }

        // IDs update after the event removal

        for(int i = 0; i < eventsList.size(); i++) {
            eventsList.get(i).setId(i + 1);
        }

    }


    @Override
    public String toString() {
        return name + " " + surname;
    }
}

