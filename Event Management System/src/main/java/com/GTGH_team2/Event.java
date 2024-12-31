package com.GTGH_team2;

import java.util.ArrayList;

class Event {
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

