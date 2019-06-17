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
	final String selectEventWithJoinQuery = "SELECT e.event_id, e.name, e.team_size, e.is_a_tournament, e.number_of_teams, e.host_user_id, e.booking_id, e.sport,"
			+ " u.username as creator_username, lb.start_time as start_date, lb.end_time as end_date, l.name as location_name "
			+ "FROM Event e, LocationBooking lb, Location l, User u "
			+ "WHERE e.booking_id = lb.booking_id AND lb.location_id = l.location_id AND e.host_user_id = u.user_id";

	void createEvent(Event event) {
		// TODO need to create teams too according to supplied no of teams, should be empty
		jdbcTemplate.update(
				"INSERT INTO Event (event_id,name,team_size,is_a_tournament,number_of_teams,host_user_id,booking_id,sport) VALUES (?,?,?,?,?,?,?,?)",
				UUID.randomUUID().toString(), event.getName(), event.getTeam_size(), event.isIs_a_tournament(),
				event.getNumber_of_teams(), event.getHost_user_id(), event.getBooking_id(), event.getSport());

	}

	List<Event> findAllEvents() {
		return jdbcTemplate.query(
				selectEventWithJoinQuery, new BeanPropertyRowMapper<Event>(Event.class));
	}

	public Event findEventBy(String event_id) {
		// TODO should be done in SQL
		List<Event> events = findAllEvents();
		return events.stream().filter(e -> e.getEvent_id().toString().equals(event_id)).findFirst().orElse(new Event());
	}

	List<Event> findEventsByHost(String user_id) {
		return jdbcTemplate
				.query("SELECT event_id,name,team_size,is_a_tournament,number_of_teams,host_user_id,booking_id,sport FROM Event WHERE host_user_id = '"
						+ user_id + "'", new BeanPropertyRowMapper<Event>(Event.class));
	}

	List<Event> filterEvents(Filter filters) {
		return jdbcTemplate.query(getQueryWithFilters(filters), new BeanPropertyRowMapper<Event>(Event.class));
	}

	private String getQueryWithFilters(Filter filters) {
		if (filters != null) {
			StringBuilder myQuery = new StringBuilder(selectEventWithJoinQuery);
			if (filters.event_name != null && !filters.event_name.isEmpty())
				myQuery.append(" AND e.name LIKE '%" + filters.event_name + "%'");

			if (filters.created_by != null && !filters.created_by.isEmpty())
				myQuery.append(" AND u.username LIKE '%" + filters.created_by + "%'");

			if (filters.sport != null && !filters.sport.isEmpty())
				myQuery.append(" AND e.sport = '" + filters.sport + "'");

			if (filters.location_name != null && !filters.location_name.isEmpty())
				myQuery.append(" AND l.location_name LIKE '%" + filters.location_name + "%'");

			if (filters.no_of_teams != 0)
				myQuery.append(" AND number_of_teams = " + String.valueOf(filters.no_of_teams));

			if (filters.is_a_tournament != null && filters.is_a_tournament.booleanValue())
				myQuery.append(" AND is_a_tournament > 0");
			else if(filters.is_a_tournament != null)
				myQuery.append(" AND is_a_tournament = 0");

			if (filters.start_day != 0 && filters.start_month != 0 && filters.start_year != 0)
				myQuery.append(" AND DATE(start_time) = '" + String.valueOf(filters.start_year) + "-"
						+ String.valueOf(filters.start_month) + "-" + String.valueOf(filters.start_day) + "'");
			return myQuery.toString();
		}
		return selectEventWithJoinQuery;
	}
}
