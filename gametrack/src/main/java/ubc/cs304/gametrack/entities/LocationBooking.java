package ubc.cs304.gametrack.entities;

import java.util.UUID;

public class LocationBooking {
    private UUID booking_id;
    private int start_time;
    private int end_time;
    private UUID location_id;

    public LocationBooking(UUID booking_id, UUID location_id) {
        this.booking_id = booking_id;
        this.location_id = location_id;
    }

    public void setStart_time(int start_time) {
        this.start_time = start_time;
    }

    public void setEnd_time(int end_time) {
        this.end_time = end_time;
    }

    public UUID getBooking_id() {
        return booking_id;
    }

    public int getStart_time() {
        return start_time;
    }

    public int getEnd_time() {
        return end_time;
    }

    public UUID getLocation_id() {
        return location_id;
    }
}
