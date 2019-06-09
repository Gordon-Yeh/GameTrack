package ubc.cs304.gametrack.entities;

import java.util.UUID;

public class SportDescription {
    private String name; //PK
    private int suggested_number_of_players;
    private UUID sport_id; //FK

    public SportDescription() {
    }

    public SportDescription(String name, int suggested_number_of_players, UUID sport_id) {
        this.name = name;
        this.suggested_number_of_players = suggested_number_of_players;
        this.sport_id = sport_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
