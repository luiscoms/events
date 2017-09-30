package edu.uniritter.events.domain;

import java.time.LocalDate;

public class Event {
	private Long id;
	private String name;
	private LocalDate date;
	
	public Event() {}
	
	public Event(String name, LocalDate date) {
		this.name = name;
		this.date = date;
	}

	public Event(Long id, String name, LocalDate date) {
		this(name, date);
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
