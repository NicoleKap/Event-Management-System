package com.GTGH_team2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.GTGH_team2.Visitors.Visitor;
import com.GTGH_team2.Visitors.VisitorServices;

@SpringBootApplication
public class EventManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventManagementSystemApplication.class, args);
		VisitorServices visitorServices = new VisitorServices();

        
        visitorServices.addVisitor(new Visitor(1, "John", "A", "johnA@gmail.com"));
        visitorServices.addVisitor(new Visitor(2, "Jim", "B", "jimB@gmail.com"));
        visitorServices.addVisitor(new Visitor(3, "Mary", "C", "maryC@gmail.com"));

        visitorServices.getAllVisitors();
	}

}
