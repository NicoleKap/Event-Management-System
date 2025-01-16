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
	      
		
}

}

