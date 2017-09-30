package edu.uniritter.events.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import edu.uniritter.events.domain.Event;
import edu.uniritter.events.service.EventsService;

@Controller
public class EventsController {
	
	@Autowired
	EventsService service;
	
	@GetMapping("events")
	public ResponseEntity<List<Event>> listEvents() {
		
		return ResponseEntity.ok(service.findAll());
	}
	
	@PostMapping("events")
	public ResponseEntity<Event> createEvent(
			@RequestBody Event event) {
		
		Event eventCreated = service.createEvent(event);
		
		return ResponseEntity.ok(eventCreated);
	}
	
}
