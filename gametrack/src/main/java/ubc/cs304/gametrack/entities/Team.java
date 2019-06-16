package ubc.cs304.gametrack.entities;

import java.util.List;
import java.util.UUID;

public class Team {
    private UUID event_id;
    private String name;
    private int team_number, curr_size, max_size;
    private List<User> team_members;


    public Team() {
    }

    public Team(UUID event_id, int team_number, int curr_size, int max_size, String name, List<User> team_members) {
        this.event_id = event_id;
        this.team_number = team_number;
        this.curr_size = curr_size;
        this.max_size = max_size;
        this.name = name;
    }


    public UUID getEvent_id() {
        return event_id;
    }

    public void setEvent_id(UUID event_id) {
        this.event_id = event_id;
    }

    public int getTeam_number() {
        return team_number;
    }

    public void setTeam_number(int team_number) {
        this.team_number = team_number;
    }

    public int getCurr_size() {
        return curr_size;
    }

    public void setCurr_size(int curr_size) {
        this.curr_size = curr_size;
    }

    public int getMax_size() {
        return max_size;
    }

    public void setMax_size(int max_size) {
        this.max_size = max_size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public List<User> getTeam_members() {
		return team_members;
	}

	public void setTeam_members(List<User> team_members) {
		this.team_members = team_members;
	}
}
