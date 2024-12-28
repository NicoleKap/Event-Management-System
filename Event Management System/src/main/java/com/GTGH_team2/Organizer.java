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


    // The Organizer can create a new Event
    
    public void addEvent(Event event) {
        this.eventsList.add(event);
        System.out.println("The organizer " + name + " created the event " + event.getTitle());

    }

    // The Organizer can delete an existing Event

    public void deleteEvent(Event event) {
        this.eventsList.remove(event);

        // IDs update after the event removal

        for(int i = 0; i < eventsList.size(); i++) {
            eventsList.get(i).setId(i + 1);
        }
        System.out.println("The event " + event.getTitle() + " is successfully deleted by " + name);
    }


    @Override
    public String toString() {
        return name + " " + surname;
    }
}

