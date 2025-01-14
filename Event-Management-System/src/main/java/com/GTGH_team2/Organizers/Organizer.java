package com.GTGH_team2.Organizers;

import java.util.ArrayList;
import java.util.Objects;

import com.GTGH_team2.Events.Event;

public class Organizer {
	private Integer id;
    private String afm;
    private String name;
    private String surname;
    private String description;
    private Event events;

    // Constructor

    public Organizer(String afm, String name, String surname, String description) {
        this.afm = afm;
        this.name = name;
        this.surname = surname;
        this.description = description;
    }

    public Integer getId() {
		return 1;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAfm() {
	     return afm;
	}
	
	public void setAfm(String afm) {
		this.afm = afm;
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

    public Event getEvents() {
		return events;
	}

	public void setEvents(Event events) {
		this.events = events;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
        return description;
    }

    // It returns the name and the surname of the Organizer

    @Override
    public String toString() {
        return name + " " + surname;
    }

}

