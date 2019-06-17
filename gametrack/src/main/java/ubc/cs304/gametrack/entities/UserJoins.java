package ubc.cs304.gametrack.entities;

import java.util.UUID;

public class UserJoins {
    private UUID user_id;
    private UUID event_id;
    private int team_number;
    
    public UserJoins() {
    	
    }
    
    public UserJoins(UUID user_id, UUID event_id, int team_number) {
        this.user_id = user_id;
        this.event_id = event_id;
        this.team_number = team_number;
    }

    public UUID getUser_id() {
        return user_id;
    }

    public UUID getEvent_id() {
        return event_id;
    }

    public int getTeam_number() {
        return team_number;
    }
}
