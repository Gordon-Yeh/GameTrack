package ubc.cs304.gametrack.controllers.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ubc.cs304.gametrack.entities.Team;
import ubc.cs304.gametrack.entities.User;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class TeamService {

	@Autowired
	JdbcTemplate jdbcTemplate;

	void createTeam(Team team) {

		jdbcTemplate.update("INSERT INTO Team (event_id,team_number,name,curr_size,max_size)  VALUES (?,?,?,?,?)",
				team.getEvent_id().toString(), team.getTeam_number(), team.getName(), team.getCurr_size(),
				team.getMax_size());

	}

	List<Team> findAllTeams() {
		List<Team> allTeams = jdbcTemplate.query("SELECT event_id,team_number,name,curr_size,max_size FROM Team",
				new BeanPropertyRowMapper<Team>(Team.class));
		allTeams.stream()
				.forEach(t -> t.setTeam_members(getTeamMembers(t.getEvent_id().toString(), t.getTeam_number())));
		return allTeams;
	}

	Team findTeamById(String event_id, int team_number) {
		List<Team> teams = findAllTeams();
		Team found = teams.stream().filter(t -> t.getEvent_id().toString().equals(event_id))
				.filter(t -> t.getTeam_number() == team_number).findFirst().orElse(new Team());
		if (found.getName() != null) {
			found.setTeam_members(getTeamMembers(found.getEvent_id().toString(), found.getTeam_number()));
		}
		return found;
	}

	List<Team> findAllTeamsById(String event_id) {
		Stream<Team> teams = findAllTeams().stream().filter(t -> t.getEvent_id().toString().equals(event_id));
		teams.forEach(t -> t.setTeam_members(getTeamMembers(t.getEvent_id().toString(), t.getTeam_number())));
		return teams.collect(Collectors.toList());
	}

	Team findTeamByName(String name) {
		List<Team> teams = findAllTeams();
		return teams.stream().filter(t -> t.getName().equals(name)).findFirst().orElse(new Team());
	}

	void deleteTeam(String event_id, int team_number) {
		jdbcTemplate.update("DELETE FROM Team WHERE event_id = ? AND team_number = ?", event_id, team_number);
	}

	List<User> getTeamMembers(String event_id, int team_number) {
		return jdbcTemplate.query(
				"SELECT u.* from UserJoins uj, User u WHERE uj.user_id = u.user_id AND uj.event_id='" + event_id
						+ "' AND uj.team_number=" + String.valueOf(team_number),
				new BeanPropertyRowMapper<User>(User.class));
	}

}
