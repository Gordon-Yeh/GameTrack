package ubc.cs304.gametrack.controllers.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ubc.cs304.gametrack.entities.Team;

import java.util.List;

@RestController
public class TeamController {

    @Autowired
    TeamService teamservice;

    @RequestMapping(method= RequestMethod.POST, value="/teams")
    public void createTeam(@RequestBody Team team) {
        teamservice.createTeam(team);
    }

    @RequestMapping(method=RequestMethod.GET, value="/teams")
    public List<Team> getAllTeams() {
        return teamservice.findAllTeams();
    }

    @RequestMapping(method=RequestMethod.GET, value="/teams/{team_id}")
    public Team findTeamById(@PathVariable String team_id) {
        return teamservice.findTeamById(team_id);
    }

    @RequestMapping(method=RequestMethod.GET, value="/teams/{name}")
    public Team findTeamByName(@PathVariable String name) {
        return teamservice.findTeamByName(name);
    }

}
