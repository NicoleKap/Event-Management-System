package com.GTGH_team2;

import java.beans.EventSetDescriptor;

import com.GTGH_team2.Events.Event;
import com.GTGH_team2.Events.EventServices;
import com.GTGH_team2.Organizers.Organizer;

public class App
{
    public static void main( String[] args ) {

//      Functionality trial!!!
        Organizer org1 = new Organizer("111654321","Nikki","Ioannou","Computer Scientist");
        EventServices eventServices = new EventServices();
        Event event = new Event("Christmas Bazaar","Christmas Event","You can either sell objects or buy objects for charity","Athens",500,"Friday","December","2025",5,30,"5:30",org1,"Approved");
//        org1.addEvent(event);
        eventServices.addEvent(event);
//
        Organizer org2 = new Organizer("111654321","Maria","Papadopoulou","Computer Scientist");
        Event event2 = new Event("Cinema Festival","Cinema History","Come and enjoy movies of all time","Athens",500,"Thursday","May","2025",5,30,"5:30",org1,"Approved");
        eventServices.addEvent(event2);
        
        System.out.println(eventServices.toString());
//        org2.addEvent(event2); // test: it adds a new event in the list
//        org2.addEvent(event2); // test: it shows that the event exists
        
        System.out.println("=============================================================");
        eventServices.removeEvent(event2.getId());
        
        System.out.println(eventServices.toString());
//	
//        Event event3 = new Event("Spring Festival","Welcome Spring","Come and enjoy the beauty of the nature with us","Patra",350,"Saturday","March","2025",12,30,"12:30",org2,"Approved");
//        org1.addEvent(event2);
//        org1.viewEvents();
//        org1.deleteEvent(event); // test: it deletes an existing event from the list
//        org1.viewEvents();
//        org1.deleteEvent(event3); // test: We haven't added this event to the list so we get the message "The event is not found in the list"
//        org2.viewEvents();
//        org1.addEvent(event3);
//        org1.viewEvents();
//        org1.deleteEvent(event2);
//        org1.viewEvents();
//        org2.addEvent(event);
//        org2.viewEvents();
//
//        // Event List
//        System.out.println("All Events");
//        for( Object e : Event.viewEvents()) {
//            System.out.println();
//            System.out.println(e +" ");
//        }
//    }
 }
}
