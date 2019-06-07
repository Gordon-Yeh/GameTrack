package ubc.cs304.gametrack.entities;

import java.util.UUID;

public class SportDescription {
    private String name;
    private int suggested_number_of_players;
    private UUID sport_id;

    public SportDescription(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getSuggested_number_of_players() {
        return suggested_number_of_players;
    }

    public void setSuggested_number_of_players(int suggested_number_of_players) {
        this.suggested_number_of_players = suggested_number_of_players;
    }

    public UUID getSport_id() {
        return sport_id;
    }

    public void setSport_id(UUID sport_id) {
        this.sport_id = sport_id;
    }
}
