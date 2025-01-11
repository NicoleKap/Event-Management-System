package com.GTGH_team2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.GTGH_team2.Employees.Employee;
import com.GTGH_team2.Employees.EmployeeServices;

@SpringBootApplication
public class EventManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventManagementSystemApplication.class, args);
		
		EmployeeServices employeeServices = new EmployeeServices();
	

		employeeServices.addEmployee(new Employee(1,"Daniela","Fischer", "danielafisher@nomail.com"));
		employeeServices.addEmployee(new Employee(2,"Henry","Oakley", "oakleyhenry@nomail.com"));
		employeeServices.addEmployee(new Employee(3,"Shannon","Ramirez", "shanramirez@nomail.com"));
		
				
	}

}
