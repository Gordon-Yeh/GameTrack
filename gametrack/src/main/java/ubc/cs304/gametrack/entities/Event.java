package ubc.cs304.gametrack.entities;

import java.sql.Timestamp;
import java.util.UUID;

public class Event {
	private UUID event_id;
	private String name;
	private int team_size;
	private boolean is_a_tournament;
	private int number_of_teams;
	private UUID host_user_id;
	private UUID booking_id;
	private String sport;
	private String location_name;
	private Timestamp start_date;
	private Timestamp end_date;
	private String creator_username;

	public Event() {

	}

	public Event(UUID event_id, String name, int team_size, boolean is_a_tournament, int number_of_teams,
			UUID host_user_id, UUID booking_id, String sport, String location_name, Timestamp start_date,
			Timestamp end_date, String creator_username) {
		this.event_id = event_id;
		this.name = name;
		this.team_size = team_size;
		this.is_a_tournament = is_a_tournament;
		this.number_of_teams = number_of_teams;
		this.host_user_id = host_user_id;
		this.booking_id = booking_id;
		this.sport = sport;
		this.location_name = location_name;
		this.start_date = start_date;
		this.end_date = end_date;
		this.setCreator_username(creator_username);
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

	public String getLocation_name() {
		return location_name;
	}

	public void setLocation_name(String location_name) {
		this.location_name = location_name;
	}

	public Timestamp getStart_date() {
		return start_date;
	}

	public void setStart_date(Timestamp start_date) {
		this.start_date = start_date;
	}

	public Timestamp getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Timestamp end_date) {
		this.end_date = end_date;
	}

	public String getCreator_username() {
		return creator_username;
	}

	public void setCreator_username(String creator_username) {
		this.creator_username = creator_username;
	}
}
