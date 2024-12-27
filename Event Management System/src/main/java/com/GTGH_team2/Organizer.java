package com.GTGH_team2;

import java.util.ArrayList;

class Organizer {
    private String afm;
    private String name;
    private String surname;
    private String description;
    private Event events;
    private final ArrayList<Event> eventsList = new ArrayList<>(); // The events are stored here
    private static int id = 0 ;

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

    public static int getId() {
        return id;
    }

    // Generating a unique id for each event! Every time, an event is added this methode generate a unique id
    public static int generateId() {
        return ++id;
    }

    // The Organizer can create a new Event
    
    public void addEvent(Event event) {
        this.eventsList.add(event);
        System.out.println("The organizer " + name + " created the event " + event.getTitle());

    }

    // The Organizer can delete an existing Event

    public void deleteEvent() {

    }


    @Override
    public String toString() {
        return name + " " + surname;
    }
}

