package ubc.cs304.gametrack.entities;

import java.sql.Timestamp;
import java.util.UUID;

public class LocationBooking {
    private UUID booking_id;
    private Timestamp start_time;
    private Timestamp end_time;
    private UUID location_id;

    public LocationBooking() {

    }

    public LocationBooking(UUID booking_id, Timestamp start_time, Timestamp end_time, UUID location_id) {
        this.booking_id = booking_id;
        this.start_time = start_time;
        this.end_time = end_time;
        this.location_id = location_id;
    }

    public UUID getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(UUID booking_id) {
        this.booking_id = booking_id;
    }

    public Timestamp getStart_time() {
        return start_time;
    }

    public void setStart_time(Timestamp start_time) {
        this.start_time = start_time;
    }

    public Timestamp getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Timestamp end_time) {
        this.end_time = end_time;
    }

    public UUID getLocation_id() {
        return location_id;
    }

    public void setLocation_id(UUID location_id) {
        this.location_id = location_id;
    }
}
