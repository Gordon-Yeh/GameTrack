package ubc.cs304.gametrack.entities;

public class LeaderboardLocation {
    private String name;
    private String street_address;
    private String postal_code;
    private int no_of_events;

    public LeaderboardLocation() {

    }

    public LeaderboardLocation(String location_name, String address, String postal_code, int no_of_events) {
        this.name = location_name;
        this.street_address = address;
        this.postal_code = postal_code;
        this.no_of_events = no_of_events;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet_address() {
        return street_address;
    }

    public void setStreet_address(String street_address) {
        this.street_address = street_address;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public int getNo_of_events() {
        return no_of_events;
    }

    public void setNo_of_events(int no_of_events) {
        this.no_of_events = no_of_events;
    }
}
