package ubc.cs304.gametrack.controllers.location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ubc.cs304.gametrack.entities.Location;

import java.util.List;
import java.util.UUID;

@Service
public class LocationService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    void createLocation(Location location) {

        jdbcTemplate.update("INSERT INTO Location (location_id,name,postal_code,street_address) VALUES (?,?,?,?)",
                                UUID.randomUUID().toString(),
                                location.getName(),
                                location.getPostal_code(),
                                location.getStreet_address() );

    }

    List<Location> findAllLocations() {
        return jdbcTemplate.query("SELECT location_id,name,postal_code,street_address FROM Location",
                new BeanPropertyRowMapper<Location>(Location.class));
    }

    Location findLocationBy(String location_id) {
        List<Location> locations = findAllLocations();
        return locations.stream().filter(l -> l.getLocation_id().toString().equals(location_id)).findFirst().orElse(new Location());
    }
}
