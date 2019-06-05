package ubc.cs304.gametrack.entities;

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

    public Event(UUID host_user_id, UUID booking_id) {
        event_id = UUID.randomUUID();
        this.host_user_id = host_user_id;
        this.booking_id = booking_id;
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

    public UUID getEvent_id() {
        return event_id;
    }

    public int getNumber_of_teams() {
        return number_of_teams;
    }

    public UUID getHost_user_id() {
        return host_user_id;
    }

    public void addTeamSize() {
        number_of_teams++;
    }

    public void subTeamSize() {
        number_of_teams--;
    }
}
