package ubc.cs304.gametrack.entities;

import java.sql.Timestamp;
import java.util.UUID;

public class EventForm {
	private UUID event_id;
	private String name;
	private int team_size;
	private boolean is_a_tournament;
	private int number_of_teams;
	private UUID host_user_id;
	private UUID booking_id;
	private String sport;
	private UUID location_id;
	private Timestamp start_time;
	private Timestamp end_time;

	public EventForm() {
	}

	public EventForm(UUID event_id, String name, int team_size, boolean is_a_tournament, int number_of_teams,
			UUID host_user_id, UUID booking_id, String sport, UUID location_id, Timestamp start_time, Timestamp end_time) {
		this.event_id = event_id;
		this.name = name;
		this.team_size = team_size;
		this.is_a_tournament = is_a_tournament;
		this.number_of_teams = number_of_teams;
		this.host_user_id = host_user_id;
		this.booking_id = booking_id;
		this.sport = sport;
		this.location_id = location_id;
		this.start_time = start_time;
		this.end_time = end_time;
	}

	public UUID getEvent_id() {
		return event_id;
	}

	public void setEvent_id(UUID event_id) {
		this.event_id = event_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTeam_size() {
		return team_size;
	}

	public void setTeam_size(int team_size) {
		this.team_size = team_size;
	}

	public boolean isIs_a_tournament() {
		return is_a_tournament;
	}

	public void setIs_a_tournament(boolean is_a_tournament) {
		this.is_a_tournament = is_a_tournament;
	}

	public int getNumber_of_teams() {
		return number_of_teams;
	}

	public void setNumber_of_teams(int number_of_teams) {
		this.number_of_teams = number_of_teams;
	}

	public UUID getHost_user_id() {
		return host_user_id;
	}

	public void setHost_user_id(UUID host_user_id) {
		this.host_user_id = host_user_id;
	}

	public UUID getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(UUID booking_id) {
		this.booking_id = booking_id;
	}

	public String getSport() {
		return sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	public UUID getLocation_id() {
		return location_id;
	}

	public void setLocation_id(UUID location_id) {
		this.location_id = location_id;
	}

	public Timestamp getStart_time() {
		return start_time;
	}

	public void setStart_time(Timestamp start_time) {
		this.start_time = start_time;
	}

	public Timestamp getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Timestamp end_time) {
		this.end_time = end_time;
	}
}
