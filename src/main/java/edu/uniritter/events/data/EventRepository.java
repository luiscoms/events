package edu.uniritter.events.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import edu.uniritter.events.domain.Event;

@Repository
public class EventRepository {
	
	@Autowired
	NamedParameterJdbcTemplate jdbc;
	
	public List<Event> findAll() {
		
		String selectSql = "select * from event";
		
		List<Event> events = jdbc.query(selectSql, new RowMapper<Event>() {
			@Override
			public Event mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Event(
						rs.getLong("event_id"), 
						rs.getString("event_name"), 
						rs.getDate("event_date"));
			}
		});
		
		return events;
	}

	public Event insertEvent(Event event) {
		
		String sql = "insert into event (event_name, event_date) values (:name, :date)";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", event.getName());
		params.put("date", event.getDate());
		
		jdbc.update(sql, params);
		
		String selectSql = "select * from event where event_name = :name and event_date = :date";
		
		Event createdEvent = jdbc.queryForObject(selectSql, params, new RowMapper<Event>() {
			@Override
			public Event mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Event(
						rs.getLong("event_id"), 
						rs.getString("event_name"), 
						rs.getDate("event_date"));
			}
		});
		
		return createdEvent;
	}

}
