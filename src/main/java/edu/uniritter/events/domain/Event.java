package edu.uniritter.events.domain;

import java.util.Date;

public class Event {
	private Long id;
	private String name;
	private Date date;
	
	public Event() {}
	
	public Event(String name, Date date) {
		this.name = name;
		this.date = date;
	}

	public Event(Long id, String name, Date date) {
		this(name, date);
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
