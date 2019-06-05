package ubc.cs304.gametrack.entities;

import java.util.UUID;

public class Location {
    private UUID location_id;
    private String name;
    private String postal_code;
    private String street_address;

    public Location(String name, String postal_code, String street_address) {
        location_id = UUID.randomUUID();
        this.name = name;
        this.postal_code = postal_code;
        this.street_address = street_address;
    }

    public UUID getLocation_id() {
        return location_id;
    }

    public String getName() {
        return name;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public String getStreet_address() {
        return street_address;
    }
}
