package ubc.cs304.gametrack.entities;

public class LeaderboardUser {
    private String username;
    private String full_name;
    private int no_of_events;

    public LeaderboardUser() {

    }

    public LeaderboardUser(String username, String name, int no_of_events) {
        this.username = username;
        this.full_name = name;
        this.no_of_events = no_of_events;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public int getNo_of_events() {
        return no_of_events;
    }

    public void setNo_of_events(int no_of_events) {
        this.no_of_events = no_of_events;
    }
}
