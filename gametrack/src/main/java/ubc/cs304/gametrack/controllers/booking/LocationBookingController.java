package ubc.cs304.gametrack.controllers.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ubc.cs304.gametrack.entities.LocationBooking;

import java.util.List;

@RestController
public class LocationBookingController {

    @Autowired
    LocationBookingService locationBookingService;

    @RequestMapping(method= RequestMethod.POST, value="/bookings")
    public void registerUser(@RequestBody LocationBooking locationBooking) {
        locationBookingService.createLocationBooking(locationBooking);
    }

    @RequestMapping(method=RequestMethod.GET, value="/bookings")
    public List<LocationBooking> getAllLocationBookings() {
        return locationBookingService.findAllLocationBookings();
    }

    @RequestMapping(method=RequestMethod.GET, value="/bookings/{booking_id}")
    public LocationBooking getLocationBooking(@PathVariable String booking_id) {
        return locationBookingService.findLocationBookingBy(booking_id);
    }

}
