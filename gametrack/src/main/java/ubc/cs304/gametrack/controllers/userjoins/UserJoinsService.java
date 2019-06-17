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
                userjoins.getUser_id(),
                userjoins.getEvent_id(),
                userjoins.getTeam_number());
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

    void removeUser(String user_id, String event_id) {
        jdbcTemplate.update("DELETE FROM UserJoins WHERE event_id = ? AND user_id = ?", event_id, user_id);
    }

    List<LeaderboardUser> getLeaderboard() {
//        return jdbcTemplate.query("SELECT username, full_name, count(event_id) AS no_of_events FROM UserJoins" +
//                "           GROUP BY username" +
//                "           ORDER BY no_of_events",
//                            new BeanPropertyRowMapper<LeaderboardUser>(LeaderboardUser.class));

        return jdbcTemplate.query("SELECT u.username, u.full_name, count(uj.event_id) AS no_of_events FROM User u, UserJoins uj " +
                "WHERE u.user_id = uj.user_id " +
                "GROUP BY u.username, u.full_name " +
                "ORDER BY count(uj.event_id) DESC",new BeanPropertyRowMapper<LeaderboardUser>(LeaderboardUser.class));
    }
}
