package com.GTGH_team2;

import java.util.ArrayList;

public class Event {
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

    public String getTheme() {
        return theme;
    }

    public String getLocation() {
        return location;
    }

    public String getDay() {
        return day;
    }

	public String getTitle() {
        return title;
    }

    public String getStatus() {
        return status;
    }

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
