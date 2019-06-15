package ubc.cs304.gametrack.controllers.sportinfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ubc.cs304.gametrack.entities.SportInfo;

import java.util.List;
import java.util.UUID;

@Service
public class SportInfoService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    void createSportInfo(SportInfo sportInfo) {

        jdbcTemplate.update( "INSERT INTO SportInfo (sport_id,description,meta) VALUES (?,?,?) ",
                            UUID.randomUUID().toString(),
                            sportInfo.getDescription(),
                            sportInfo.getMeta());

    }

    List<SportInfo> findAllSportInfos() {
        return jdbcTemplate.query("SELECT sport_id,description,meta FROM SportInfo;",
                new BeanPropertyRowMapper<SportInfo>(SportInfo.class));
    }

    SportInfo findSportInfoBy(String sport_id) {
        List<SportInfo> sportInfos = findAllSportInfos();
        return sportInfos.stream().filter(si -> si.getSport_id().toString().equals(sport_id)).findFirst().orElse(new SportInfo());
    }
}
