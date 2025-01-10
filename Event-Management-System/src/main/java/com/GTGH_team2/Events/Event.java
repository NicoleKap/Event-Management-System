package com.GTGH_team2.Events;

import  com.GTGH_team2.*;
import com.GTGH_team2.Organizers.Organizer;
import com.GTGH_team2.Visitors.Visitor;

import java.util.ArrayList;

public class Event {
<<<<<<< HEAD:Event Management System/src/main/java/com/GTGH_team2/Event.java
    private final String title;
    private final String theme;
    private final String description;
    private final String location;
    private final int maxCapacity;
    private final String day;
    private final String month;
    private final String year;
    private final int hour;
    private final int minutes;
    private final String duration;
    private final Organizer organizer;
    private final String status;
    private static final ArrayList<Event> allEvents = new ArrayList<>();
    private final ArrayList<Visitor> participants = new ArrayList<>();
=======
    private String title;
    private String theme;
    private String description;
    private String location;
    private int maxCapacity;
    private String day;
    private String month;
    private String year;
    private int hour;
    private int minutes;
    private String duration;
    private Organizer organizer;
    private String status;
    private static final ArrayList<Event> allEvents = new ArrayList<>();
    private ArrayList<Visitor> participants = new ArrayList<>();
>>>>>>> main:Event-Management-System/src/main/java/com/GTGH_team2/Events/Event.java

    public Event(String title, String theme, String description, String location, int maxCapacity, String day, String month, String year, int hour, int minutes, String duration,Organizer organizer, String status) {
        this.title = title;
        this.theme = theme;
        this.description = description;
        this.location = location;
        this.maxCapacity = maxCapacity;
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.minutes = minutes;
        this.duration = duration;
        this.organizer = organizer;
        this.status = status;

    }
   
    // Setters & Getters

    public String getTheme() {
<<<<<<< HEAD:Event Management System/src/main/java/com/GTGH_team2/Event.java
        return theme;
    }

    public String getLocation() {
        return location;
    }

    public String getDay() {
        return day;
    }
=======
		return theme;
	}

	public String getLocation() {
		return location;
	}


	public String getDay() {
		return day;
	}
>>>>>>> main:Event-Management-System/src/main/java/com/GTGH_team2/Events/Event.java

	public String getTitle() {
        return title;
    }

    public String getStatus() {
        return status;
    }

<<<<<<< HEAD:Event Management System/src/main/java/com/GTGH_team2/Event.java
    public void addEvent(Event event) {
        allEvents.add(event);
    }

    public void removeEvent(Event event) {
        allEvents.remove(event);
    }

    public static ArrayList<Event> viewEvents() {
        return allEvents;
    }

    // Add participant to this event

    public void addParticipant(Visitor visitor) {
        if (!participants.contains(visitor)) {
            participants.add(visitor);
            System.out.println("Participant added: " + visitor.getName());
        }
    }

    // Remove a participant from this event
    
    public void removeParticipant(Visitor visitor) {
        participants.remove(visitor);
        System.out.println("Participant removed: " + visitor.getName());
    }
    
=======
>>>>>>> main:Event-Management-System/src/main/java/com/GTGH_team2/Events/Event.java
    @Override
    public String toString() {
        return  "Event title: " + title  +
                "\nTheme: " + theme +
                "\nDescription: " + description  +
                "\nLocation: " + location +
                "\nMax Capacity: " + maxCapacity +
                "\nDay: " + day +
                "\nMonth: " + month +
                "\nYear: " + year  +
                "\nHour: " + hour +
                "\nMinutes: " + minutes +
                "\nDuration: " + duration  +
                "\nOrganizer: " + organizer +
                "\nStatus: " + status;
    }

	
}
