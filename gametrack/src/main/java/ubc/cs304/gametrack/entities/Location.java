package ubc.cs304.gametrack.entities;

import java.util.UUID;

public class Location {
    private UUID location_id;
    private String name;
    private String postal_code;
    private String street_address;

    public Location() {
    }

    public Location(UUID location_id, String name, String postal_code, String street_address) {
        this.location_id = location_id;
        this.name = name;
        this.postal_code = postal_code;
        this.street_address = street_address;
    }

    public UUID getLocation_id() {
        return location_id;
    }

    public void setLocation_id(UUID location_id) {
        this.location_id = location_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getStreet_address() {
        return street_address;
    }

    public void setStreet_address(String street_address) {
        this.street_address = street_address;
    }
}
