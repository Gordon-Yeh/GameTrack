package ubc.cs304.gametrack.controllers.event;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Filter {
	@JsonProperty("created_by")
	@Nullable
	String created_by;
	
	@JsonProperty("event_name")
	@Nullable
	String event_name;
	
	@JsonProperty("sport")
	@Nullable
	String sport;
	
	@JsonProperty("location_name")
	@Nullable
	String location_name;
	
	@JsonProperty("no_of_teams")
	@Nullable
	int no_of_teams;
	
	@JsonProperty("is_a_tournament")
	@Nullable
	boolean is_a_tournament;
	
	@JsonProperty("start_day")
	int start_day;
	
	@JsonProperty("start_month")
	int start_month;
	
	@JsonProperty("start_year")
	int start_year;
	
	public Filter() {
		
	}
	
	public Filter(String created_by, String event_name, String sport, String location_name, int no_of_teams,
			boolean is_a_tournament, int start_day, int start_month, int start_year) {
		this.created_by = created_by;
		this.event_name = event_name;
		this.sport = sport;
		this.location_name = location_name;
		this.no_of_teams = no_of_teams;
		this.is_a_tournament = is_a_tournament;
		this.start_day = start_day;
		this.start_month = start_month;
		this.start_year = start_year;
	}
}
