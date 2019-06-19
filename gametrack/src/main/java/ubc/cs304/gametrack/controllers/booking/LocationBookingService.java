package ubc.cs304.gametrack.controllers.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ubc.cs304.gametrack.entities.LocationBooking;

import java.util.List;
import java.util.UUID;

@Service
public class LocationBookingService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void createLocationBooking(LocationBooking locationBooking) {

        jdbcTemplate.update("INSERT INTO LocationBooking (booking_id,start_time,end_time,location_id) VALUES (?,?,?,?) ",
                locationBooking.getBooking_id().toString(),
                locationBooking.getStart_time(),
                locationBooking.getEnd_time(),
                locationBooking.getLocation_id().toString());
    }

    List<LocationBooking> findAllLocationBookings() {
        return jdbcTemplate.query("SELECT booking_id,start_time,end_time,location_id FROM LocationBooking;",
                new BeanPropertyRowMapper<LocationBooking>(LocationBooking.class));
    }

    LocationBooking findLocationBookingBy(String booking_id) {
        List<LocationBooking> locationBooking = findAllLocationBookings();
        return locationBooking.stream().filter(lb -> lb.getBooking_id().toString().equals(booking_id)).findFirst().orElse(new LocationBooking());
    }
}
