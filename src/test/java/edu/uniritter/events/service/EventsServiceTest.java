package edu.uniritter.events.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import edu.uniritter.events.domain.Event;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EventsServiceTest {
	
//	@Autowired
//	private DataSource datasource;
	
	@Autowired
	private EventsService service;
	
	@Test
	@Transactional
	public void testCreateEvent() {
		//Given
		LocalDate eventDate = LocalDate.of(2017, 9, 20);
		String eventName = "Rush";
		Event event = new Event(eventName, eventDate);
		
		//When
		Event createdEvent = service.createEvent(event);
		
		//Then
		assertThat(createdEvent.getDate()).isEqualTo(eventDate);
		assertThat(createdEvent.getName()).isEqualTo(eventName);
		assertThat(createdEvent.getId()).isNotNull();
	}

}
