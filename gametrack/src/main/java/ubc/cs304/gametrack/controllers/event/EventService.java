package ubc.cs304.gametrack.controllers.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ubc.cs304.gametrack.entities.Event;

import java.util.List;
import java.util.UUID;

@Service
public class EventService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    void createEvent(Event event) {

        jdbcTemplate.update( "INSERT INTO Event (event_id,name,team_size,is_a_tournament,number_of_teams,host_user_id,booking_id,sport) VALUES (?,?,?,?,?,?,?,?)",
        UUID.randomUUID().toString(),
        event.getName(),
        event.getTeam_size(),
        event.isIs_a_tournament(),
        event.getNumber_of_teams(),
        event.getHost_user_id(),
        event.getBooking_id(),
        event.getSport());

    }

    @SuppressWarnings("unchecked")
    List<Event> findAllEvents() {
        return jdbcTemplate.query("SELECT event_id,name,team_size,is_a_tournament,number_of_teams,host_user_id,booking_id,sport FROM Event;",
                new BeanPropertyRowMapper(Event.class));
    }

    Event findEventBy(String event_id) {
    	// TODO should be done in SQL
        List<Event> events = findAllEvents();
        return events.stream().filter(e -> e.getEvent_id().toString().equals(event_id)).findFirst().orElse(new Event());
    }
    
    List<Event> findEventsByHost(String user_id) {
        return jdbcTemplate.query("SELECT event_id,name,team_size,is_a_tournament,number_of_teams,host_user_id,booking_id,sport FROM Event WHERE host_user_id = '" + user_id + "'",
                new BeanPropertyRowMapper<Event>(Event.class));
    }
}
