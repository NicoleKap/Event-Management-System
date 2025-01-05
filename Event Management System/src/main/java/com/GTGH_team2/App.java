package com.GTGH_team2;

import java.beans.EventSetDescriptor;

public class App
{
    public static void main( String[] args ) {

    //      Functionality trial!!!
        Organizer org1 = new Organizer("111654321","Nikki","Ioannou","Computer Scientist");
        Event event = new Event("Christmas Bazaar","Christmas Event","You can either sell objects or buy objects for charity","Athens",500,"Friday","December","2025",5,30,"5:30",org1,"Approved");
        org1.addEvent(event);

        Organizer org2 = new Organizer("111654321","Maria","Papadopoulou","Computer Scientist");
        Event event2 = new Event("Cinema Festival","Cinema History","Come and enjoy movies of all time","Athens",500,"Thursday","May","2025",5,30,"5:30",org1,"Approved");
        org2.addEvent(event2); // test: it adds a new event in the list
        org2.addEvent(event2); // test: it shows that the event exists

        Event event3 = new Event("Spring Festival","Welcome Spring","Come and enjoy the beauty of the nature with us","Patra",350,"Saturday","March","2025",12,30,"12:30",org2,"Approved");
        org1.addEvent(event2);
        org1.viewEvents();
        org1.deleteEvent(event); // test: it deletes an existing event from the list
        org1.viewEvents();
        org1.deleteEvent(event3); // test: We haven't added this event to the list so we get the message "The event is not found in the list"
        org2.viewEvents();
        org1.addEvent(event3);
        org1.viewEvents();
        org1.deleteEvent(event2);
        org1.viewEvents();
        org2.addEvent(event);
        org2.viewEvents();

        // Event List
        System.out.println("All Events");
        for( Object e : Event.viewEvents()) {
            System.out.println();
            System.out.println(e +" ");
        }
        
        //Employees
        Event event3 = new Event("Music Festival","Rock Bands of 1980s","Music contest for best band from the 80s","Larissa",1000,"Saturday","July","2025",21,00,"3 hours",org1,"Pending");
        Event event4 = new Event("Choir Festival","Greek cinema","Choirs of Thessaloniki come together to present covers of songs from the Greek cinema","Thessaloniki",500,"Friday","August","2025",19,30,"3 hours",org1,"Pending");
        
        Employee emp1 = new Employee("Dimitra", "Filippou", "dimitrafilippou@gmail.com");
        Employee emp2 = new Employee("Viktor", "Petrou", "viktorp7@gmail.com");
        emp1.approveEvent(event3);
        emp2.approveEvent(event4);
        emp1.deleteEvent(event4);
    }
}





