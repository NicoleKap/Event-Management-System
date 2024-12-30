package com.GTGH_team2;

class Visitor {
	private String name;
    private String surname;
    private String email;
    private ArrayList<Event> events;
    
    public Visitor(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.events = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public ArrayList<Event> getEvents() {
        return events;
    }
    
    //anazhthsh ekdhlwsewn 
    public ArrayList<Event> EventsSearching() {
    	
    }
    
    //krahthsh ekdhlwshs
    public String bookingAnEvent() {
    	
    }
    
    //akurwsh krathshs
    public String ReservationCanceling() {
    	
    }
    
    
    
    
}

