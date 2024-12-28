package com.GTGH_team2;

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
    private boolean status;
    private static int nextId = 1;
    private int id;

    public Event(String title, String theme, String description, String location, int maxCapacity, String day, String month, String year, int hour, int minutes, String duration, Organizer organizer, boolean status) {
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
        this.id = nextId++;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return  "\n" + id
                + ". Event title: " + title  +
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

