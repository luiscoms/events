package edu.uniritter.events.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uniritter.events.data.EventRepository;
import edu.uniritter.events.domain.Event;

@Service
public class EventsService {
	
	@Autowired
	EventRepository repository;
	
	public List<Event> findAll() {
		return repository.findAll();
	}

}
