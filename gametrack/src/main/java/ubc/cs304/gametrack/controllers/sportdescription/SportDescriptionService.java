package ubc.cs304.gametrack.controllers.sportdescription;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ubc.cs304.gametrack.entities.SportDescription;

import java.util.List;

@Service
public class SportDescriptionService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    void createSportDescription(SportDescription sportDescription) {

//        String insert = "INSERT INTO SportDescription (name,suggested_number_of_player,sport_id) VALUES ";
//        String data = "('" + sportDescription.getName()+ "', ";
//        data += sportDescription.getSuggested_number_of_players() + ", '";
//        data += sportDescription.getSport_id() + "') ";
//
//        jdbcTemplate.update(insert + data);
        jdbcTemplate.update( "INSERT INTO SportDescription (name,suggested_number_of_player,sport_id) VALUES (?,?,?)",
                                sportDescription.getName(),
                                sportDescription.getSuggested_number_of_players(),
                                sportDescription.getSport_id());

    }

    List<SportDescription> findAllSportDescriptions() {
        return jdbcTemplate.query("SELECT name,suggested_number_of_player,sport_id FROM SportDescription;",
                new BeanPropertyRowMapper<SportDescription>(SportDescription.class));
    }

    SportDescription findSportDescriptionBy(String sport_id) {
        List<SportDescription> allSportDescriptions = findAllSportDescriptions();
        return allSportDescriptions.stream().filter(sd -> sd.getSport_id().toString().equals(sport_id)).findFirst().orElse(new SportDescription());
    }
}
