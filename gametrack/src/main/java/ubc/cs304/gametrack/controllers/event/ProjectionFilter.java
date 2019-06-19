package ubc.cs304.gametrack.controllers.event;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProjectionFilter {
	@JsonProperty("name")
	boolean name;
	@JsonProperty("host_username")
    boolean host_username;
	@JsonProperty("sport")
    boolean sport;
	@JsonProperty("locationName")
    boolean locationName;
	@JsonProperty("startDate")
    boolean startDate;
	@JsonProperty("number_of_teams")
    boolean number_of_teams;
	@JsonProperty("is_a_tournament")
    boolean is_a_tournament;
    
    public ProjectionFilter() {
    	
    }
}
