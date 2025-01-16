package com.GTGH_team2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.GTGH_team2.Events.Event;
import com.GTGH_team2.Events.EventServices;
import com.GTGH_team2.Organizers.Organizer;
import com.GTGH_team2.Organizers.OrganizerServices;
import com.GTGH_team2.Visitors.Visitor;
import com.GTGH_team2.Visitors.VisitorServices;

@SpringBootApplication
public class EventManagementSystemApplication {

	public static void main(String[] args) {
		
		    ConfigurableApplicationContext context = SpringApplication.run(EventManagementSystemApplication.class, args);
	        VisitorServices visitorServices = context.getBean(VisitorServices.class);
	        EventServices eventServices = context.getBean(EventServices.class);
	        OrganizerServices organizerServices = context.getBean(OrganizerServices.class);
		
			Organizer organizer = new Organizer("13224","Laura","Fernandez","Psycologist");
			Organizer organizer2 = new Organizer("1322scs4","Mora","Mirandez","Psycologist");
			Event event = new Event("Christmas Bazaar","Christmas","Charity","London",500,22,12,2025,2,30,"5:30",organizer);
			Event event2 = new Event("Christmas Bazaar 2","Christmas","Charity","London",500,22,12,2025,2,30,"5:30",organizer);
			eventServices.addEvent(event);
			eventServices.addEvent(event2);
			Event event3 = new Event("Christmas Bazaar 3","Christmas","Charity","London",500,22,12,2025,2,30,"5:30",organizer2);
//				eventServices.addEvent(event3);
//				organizerServices.addOrganizer(organizer);
//				organizerServices.addOrganizer(organizer2);
//				organizerServices.addEvent(1,1);
//				
			Visitor visitor = new Visitor("Lara","Kroft","Lara@hotmail.com");
			eventServices.bookingAnEvent(visitor.getId(),event.getId());
		
}

}

