package ubc.cs304.gametrack.controllers.userjoins;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ubc.cs304.gametrack.entities.LeaderboardUser;
import ubc.cs304.gametrack.entities.UserJoins;

import java.util.List;

@Service
public class UserJoinsService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    void joinTeam(UserJoins userjoins) {
        jdbcTemplate.update("INSERT INTO UserJoins (user_id,event_id,team_number) VALUES (?,?,?)",
                userjoins.getUser_id().toString(),
                userjoins.getEvent_id().toString(),
                userjoins.getTeam_number());
        jdbcTemplate.update("UPDATE Team SET curr_size = curr_size + 1 WHERE event_id = ? AND team_number = ?", userjoins.getEvent_id().toString(), userjoins.getTeam_number());
    }

    List<UserJoins> findAllUsersByEvent(String event_id) {
        return jdbcTemplate.query("SELECT user_id,event_id,team_number FROM UserJoins WHERE event_id = '" +
                event_id +
                "'",
                new BeanPropertyRowMapper<UserJoins>(UserJoins.class));
    }

    List<UserJoins> findAllUsersById(String user_id) {
        return jdbcTemplate.query("SELECT user_id,event_id,team_number FROM UserJoins WHERE user_id = '" +
                user_id +
                "'",
                new BeanPropertyRowMapper<UserJoins>(UserJoins.class));
    }

    void removeUser(String user_id, String event_id, String team_number) {
        jdbcTemplate.update("DELETE FROM UserJoins WHERE event_id = ? AND user_id = ? AND team_number = ?", event_id, user_id, team_number);
        jdbcTemplate.update("UPDATE Team SET curr_size = curr_size - 1 WHERE event_id = ? AND team_number = ?", event_id, team_number);
    }

    List<LeaderboardUser> getLeaderboard(String sport) {
//        return jdbcTemplate.query("SELECT username, full_name, count(event_id) AS no_of_events FROM UserJoins" +
//                "           GROUP BY username" +
//                "           ORDER BY no_of_events",
//                            new BeanPropertyRowMapper<LeaderboardUser>(LeaderboardUser.class));

//        return jdbcTemplate.query("SELECT u.username, u.full_name, count(uj.event_id) AS no_of_events FROM User u, UserJoins uj " +
//                "WHERE u.user_id = uj.user_id " +
//                "GROUP BY u.username, u.full_name " +
//                "ORDER BY count(uj.event_id) DESC",new BeanPropertyRowMapper<LeaderboardUser>(LeaderboardUser.class));
        return jdbcTemplate.query("SELECT u.username, u.full_name, count(uj.event_id) AS no_of_events FROM User u, UserJoins uj, Event e " +
                "WHERE u.user_id = uj.user_id " +
                "AND uj.event_id = e.event_id " +
                "AND e.sport = '" + sport + "' " +
                "GROUP BY u.username, u.full_name " +
                "ORDER BY count(uj.event_id) DESC, u.username",new BeanPropertyRowMapper<LeaderboardUser>(LeaderboardUser.class));
    }
}
