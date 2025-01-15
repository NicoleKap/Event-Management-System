package com.GTGH_team2;

import java.io.FileOutputStream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.GTGH_team2.Employees.Employee;
import com.GTGH_team2.Employees.EmployeeServices;
import com.GTGH_team2.Events.Event;
import com.GTGH_team2.Events.EventServices;
import com.GTGH_team2.Organizers.Organizer;
import com.GTGH_team2.Organizers.OrganizerServices;
import com.GTGH_team2.Reservations.ReservationServices;
import com.GTGH_team2.Visitors.Visitor;
import com.GTGH_team2.Visitors.VisitorServices;

import ch.qos.logback.classic.net.LoggingEventPreSerializationTransformer;

import com.GTGH_team2.ApprovalRequests.ApprovalRequestServices;

@SpringBootApplication
@ComponentScan("com.GTGH_team2")
public class EventManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventManagementSystemApplication.class, args);
		
//		VisitorServices visitorServices = new VisitorServices();
        EmployeeServices employeeServices = new EmployeeServices();
//        ReservationServices reservationServices = new ReservationServices(visitorServices, null);
        OrganizerServices organizerServices = new OrganizerServices();
//        EventServices eventServices = new EventServices(employeeServices);
//        ApprovalRequestServices approvalRequestServices = new ApprovalRequestServices(organizerServices,  employeeServices, eventServices);
        
//        visitorServices.addVisitor(new Visitor(1, "John", "A", "johnA@gmail.com"));
//        visitorServices.addVisitor(new Visitor(2, "Jim", "B", "jimB@gmail.com"));
//        visitorServices.addVisitor(new Visitor(3, "Mary", "C", "maryC@gmail.com"));

//        visitorServices.getAllVisitors();
//          	
//
//		employeeServices.addEmployee(new Employee(1,"Daniela","Fischer", "danielafisher@nomail.com"));
//		employeeServices.addEmployee(new Employee(2,"Henry","Oakley", "oakleyhenry@nomail.com"));
//		employeeServices.addEmployee(new Employee(3,"Shannon","Ramirez", "shanramirez@nomail.com"));
//		
		Organizer org1 = new Organizer("111654321","Nikki","Ioannou","Computer Scientist");
	
		organizerServices.addOrganizer(org1);
		System.out.println(organizerServices.getOrganizers());
//		Organizer org2 = new Organizer("111654321","Maria","Papadopoulou","Computer Scientist");
//		organizerServices.addOrganizer(org2);
//		Organizer org3 = new Organizer("111654321","Nikki","Ioannou","Computer Scientist");
//		organizerServices.addOrganizer(org3);
//		Organizer org4 = new Organizer("111654321","Nikki","Ioannou","Computer Scientist");
//		organizerServices.addOrganizer(org4);
//		
//		eventServices.addEvent(new Event("Christmas Bazaar","Christmas Event","You can either sell objects or buy objects for charity","Athens",500,"Friday","December","2025",5,30,"5:30",org1,"Approved"));
//		eventServices.addEvent(new Event("Cinema Festival","Cinema History","Come and enjoy movies of all time","Athens",500,"Thursday","May","2025",5,30,"5:30",org1,"Approved"));
//		eventServices.addEvent( new Event("Spring Festival","Welcome Spring","Come and enjoy the beauty of the nature with us","Patra",350,"Saturday","March","2025",12,30,"12:30",org2,"Approved"));
//		eventServices.addEvent(new Event("Music Festival","Rock Bands of 1980s","Music contest for best band from the 80s","Larissa",1000,"Saturday","July","2025",21,00,"3 hours",org1,"Pending"));
//		eventServices.addEvent(new Event("Masquerade Festival","Greek cinema","Choirs of Thessaloniki come together to present covers of songs from the Greek cinema","Thessaloniki",500,"Friday","August","2025",19,30,"3 hours",org1,"Pending"));
//		eventServices.addEvent(new Event("Christmas Bazaar","Christmas Event","You can either sell objects or buy objects for charity","Athens",500,"Friday","December","2025",5,30,"5:30",org1,"Approved"));
//		eventServices.addEvent(new Event("Christmas Bazaar","Christmas Event","You can either sell objects or buy objects for charity","Athens",500,"Friday","December","2025",5,30,"5:30",org1,"Approved"));
//		eventServices.addEvent(new Event("Christmas Bazaar","Christmas Event","You can either sell objects or buy objects for charity","Athens",500,"Friday","December","2025",5,30,"5:30",org1,"Approved"));
//	    
		
		EventServices eventServices = new EventServices();
		eventServices.addEvent("Christmas Bazaar","Christmas Event","You can either sell objects or buy objects for charity","Athens",500,22,12,2025,5,30,"5:30",org1.getId());
//		System.out.println(eventServices.getAllEvents());
	}

}
