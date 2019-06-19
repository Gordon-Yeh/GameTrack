package ubc.cs304.gametrack.controllers.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ubc.cs304.gametrack.controllers.booking.LocationBookingService;
import ubc.cs304.gametrack.controllers.userjoins.UserJoinsService;
import ubc.cs304.gametrack.entities.Event;
import ubc.cs304.gametrack.entities.EventForm;
import ubc.cs304.gametrack.entities.UserJoins;
import ubc.cs304.gametrack.entities.LocationBooking;

import java.util.List;
import java.util.UUID;

@Service
public class EventService {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	LocationBookingService bookingService;

	@Autowired
	UserJoinsService userJoinService;

	final String selectEventWithJoinQuery = "SELECT e.event_id, e.name, e.team_size, e.is_a_tournament, e.number_of_teams, e.host_user_id, e.booking_id, e.sport,"
			+ " u.username as creator_username, lb.start_time as start_date, lb.end_time as end_date, l.name as location_name "
			+ "FROM Event e, LocationBooking lb, Location l, User u "
			+ "WHERE e.booking_id = lb.booking_id AND lb.location_id = l.location_id AND e.host_user_id = u.user_id";

	void createEvent(EventForm form) {
		final String event_sql = "INSERT INTO Event (event_id,name,team_size,is_a_tournament,number_of_teams,host_user_id,booking_id,sport) VALUES (?,?,?,?,?,?,?,?)";
		final String team_sql = "INSERT INTO Team (event_id, team_number, name, curr_size, max_size) VALUES (?,?,?,?,?)";
		final UUID event_id = UUID.randomUUID();
		final UUID booking_id = UUID.randomUUID();
		final UUID location_id = form.getLocation_id();
		final UUID host_user_id = form.getHost_user_id();
		final int number_of_teams = form.getNumber_of_teams();
		final int team_size = form.getTeam_size();
		final int host_default_team_number = 1;

		bookingService.createLocationBooking(
				new LocationBooking(booking_id, form.getStart_time(), form.getEnd_time(), location_id));

		jdbcTemplate.update(event_sql, event_id.toString(), form.getName(), team_size, form.isIs_a_tournament(),
				number_of_teams, host_user_id.toString(), booking_id.toString(), form.getSport());

		// create the empty teams
		for (int i = 1; i <= number_of_teams; i++) {
			jdbcTemplate.update(team_sql, event_id.toString(), i, "Team " + String.valueOf(i), 0, team_size);
		}

		// host joins default team
		userJoinService.joinTeam(new UserJoins(host_user_id, event_id, host_default_team_number));
	}

	void editEvent(EventForm form) {
		final String sql = "UPDATE Event SET name=?, team_size=?, is_a_tournament=?, number_of_teams=? WHERE event_id=?";
		final String event_id = form.getEvent_id().toString();
		jdbcTemplate.update(sql, form.getName(), form.getTeam_size(), form.isIs_a_tournament(),
				form.getNumber_of_teams(), event_id);
	}

	List<Event> findAllEvents() {
		return jdbcTemplate.query(selectEventWithJoinQuery, new BeanPropertyRowMapper<Event>(Event.class));
	}

	public Event findEventBy(String event_id) {
		List<Event> events = findAllEvents();
		return events.stream().filter(e -> e.getEvent_id().toString().equals(event_id)).findFirst().orElse(new Event());
	}

	List<Event> findEventsByHost(String user_id) {
		String query = "SELECT e.event_id, e.name, e.team_size, e.is_a_tournament, e.number_of_teams, e.host_user_id, e.booking_id, e.sport,"
				+ " u.username as creator_username, lb.start_time as start_date, lb.end_time as end_date, l.name as location_name "
				+ " FROM Event e, LocationBooking lb, Location l, User u "
				+ " WHERE e.booking_id = lb.booking_id AND lb.location_id = l.location_id AND e.host_user_id = u.user_id AND host_user_id = '"
				+ user_id + "'";
		return jdbcTemplate.query(query, new BeanPropertyRowMapper<Event>(Event.class));
	}

	List<Event> filterEvents(Filter filters) {
		return jdbcTemplate.query(getQueryWithFilters(filters), new BeanPropertyRowMapper<Event>(Event.class));
	}

	public int findNumberOfEvents() {
		return jdbcTemplate.queryForObject("Select Count(*) from Event", Integer.class);
	}

	List<Event> getEventsUserIsParticipatingIn(String userId) {
		String query = "SELECT e.event_id, e.name, e.team_size, e.is_a_tournament, e.number_of_teams, e.host_user_id, e.booking_id, e.sport,"
				+ " u.username as creator_username, lb.start_time as start_date, lb.end_time as end_date, l.name as location_name "
				+ " FROM Event e, LocationBooking lb, Location l, User u, UserJoins uj"
				+ " WHERE e.booking_id = lb.booking_id AND lb.location_id = l.location_id AND e.host_user_id = u.user_id AND e.event_id = uj.event_id AND uj.user_id = '"
				+ userId + "'";
		return jdbcTemplate.query(query, new BeanPropertyRowMapper<Event>(Event.class));
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
			else if (filters.is_a_tournament != null)
				myQuery.append(" AND is_a_tournament = 0");

			if (filters.start_day != 0 && filters.start_month != 0 && filters.start_year != 0)
				myQuery.append(" AND DATE(start_time) = '" + String.valueOf(filters.start_year) + "-"
						+ String.valueOf(filters.start_month) + "-" + String.valueOf(filters.start_day) + "'");
			return myQuery.toString();
		}
		return selectEventWithJoinQuery;
	}

	List<Event> findEventsAndProject(ProjectionFilter filters) {
		return jdbcTemplate.query(getProjectionQuery(filters), new BeanPropertyRowMapper<Event>(Event.class));
	}

	String getProjectionQuery(ProjectionFilter filters) {

		StringBuilder myQuery = new StringBuilder("SELECT e.event_id, e.name ");
		if (filters.host_username) {
			myQuery.append(", u.username as creator_username ");
		}

		if (filters.sport) {
			myQuery.append(", e.sport ");
		}

		if (filters.locationName) {
			myQuery.append(", l.name as location_name ");
		}

		if (filters.startDate) {
			myQuery.append(", lb.start_time as start_date ");
		}

		if (filters.number_of_teams) {
			myQuery.append(", e.number_of_teams ");
		}

		if (filters.is_a_tournament) {
			myQuery.append(", e.is_a_tournament ");
		}

		myQuery.append("FROM Event e, LocationBooking lb, Location l, User u "
				+ "WHERE e.booking_id = lb.booking_id AND lb.location_id = l.location_id AND e.host_user_id = u.user_id");

		return myQuery.toString();
	}

}
