package ubc.cs304.gametrack.controllers.location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ubc.cs304.gametrack.entities.LeaderboardLocation;
import ubc.cs304.gametrack.entities.Location;

import java.util.List;

@RestController
public class LocationController {

    @Autowired
    LocationService locationService;

    @RequestMapping(method= RequestMethod.POST, value="/locations")
    public void registerUser(@RequestBody Location location) {
        locationService.createLocation(location);
    }

    @RequestMapping(method=RequestMethod.GET, value="/locations")
    public List<Location> getAllLocations() {
        return locationService.findAllLocations();
    }

    @RequestMapping(method=RequestMethod.GET, value="/locations/{location_id}")
    public Location getLocationBooking(@PathVariable String location_id) {
        return locationService.findLocationBy(location_id);
    }

    @RequestMapping(method=RequestMethod.GET, value="locations/leaderboards/{sport}")
    public List<LeaderboardLocation> getLocationLeaderboards(@PathVariable String sport) {
        return locationService.getLeaderboards(sport);
    }
}
