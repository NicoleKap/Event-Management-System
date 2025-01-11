package com.GTGH_team2.Organizers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// Spring REST Controller
// The organizer requests are created here through HTTP protocol

@RestController // Set the class a REST controller
@RequestMapping("/organizers") // The path
public class OrganizerController {

	@Autowired 
	OrganizerServices organizerServises; 
	
	@GetMapping("/all") // Get request for the list of organizers
	public List<Organizer> getAllOrganizers(){
		return organizerServises.getOrganizers();
	}
	
	@PostMapping("/addOrganizer")  // Post request for adding an organizer
	public List<Organizer> addOrganizer(@RequestBody Organizer organizer) {
		organizerServises.addOrganizer(organizer);
		return organizerServises.getOrganizers();
		
	}
	
	@DeleteMapping("/deleteOrganizer") // Delete request for removing organizers
	public List<Organizer> deleteOrganizer(@RequestParam Integer id) {
		organizerServises.removeOrganizer(id);
		return organizerServises.getOrganizers();
		
	}
	
	@PutMapping("/update") // Update the organizers details
	public List<Organizer> updateOrganizer(@RequestParam Integer id,@RequestParam String afmUpdated, @RequestParam String nameUpdated,@RequestParam String surnameUpdated,@RequestParam String descriptionUpdated){
		organizerServises.updateOrganizer(id,afmUpdated,nameUpdated,surnameUpdated,descriptionUpdated);
		return organizerServises.getOrganizers();
	}
}
;