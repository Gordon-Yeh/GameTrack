package ubc.cs304.gametrack.controllers.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ubc.cs304.gametrack.entities.Team;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    void createTeam(Team team) {

        jdbcTemplate.update("INSERT INTO Team (event_id,team_number,name,curr_size,max_size)  VALUES (?,?,?,?,?)",
                team.getEvent_id().toString(),
                team.getTeam_number(),
                team.getName(),
                team.getCurr_size(),
                team.getMax_size());

    }

    @SuppressWarnings("unchecked")
    List<Team> findAllTeams() {
        return jdbcTemplate.query("SELECT event_id,team_number,name,curr_size,max_size FROM Team",
                new BeanPropertyRowMapper(Team.class));
    }

    Team findTeamById(String event_id, int team_number) {
        List<Team> teams = findAllTeams();
        return teams.stream().filter(t -> t.getEvent_id().toString().equals(event_id)).filter(t -> t.getTeam_number() == team_number).findFirst().orElse(new Team());
    }

    List<Team> findAllTeamsById(String event_id) {
        List<Team> teams = findAllTeams();
        return teams.stream().filter(t -> t.getEvent_id().toString().equals(event_id)).collect(Collectors.toList());
//        return jdbcTemplate.query("SELECT event_id,team_number,name,curr_size,max_size FROM Team WHERE event_id = '" +
//                event_id +
//                "'",
//                new BeanPropertyRowMapper(Team.class));
    }
    Team findTeamByName(String name) {
        List<Team> teams = findAllTeams();
        return teams.stream().filter(t -> t.getName().equals(name)).findFirst().orElse(new Team());
    }

    void deleteTeam(String event_id, int team_number) {
        jdbcTemplate.update("DELETE FROM Team WHERE event_id = ? AND team_number = ?", event_id, team_number);
    }

}
