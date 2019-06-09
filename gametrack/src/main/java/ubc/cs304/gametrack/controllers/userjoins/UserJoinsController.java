package ubc.cs304.gametrack.controllers.userjoins;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ubc.cs304.gametrack.entities.Team;

import java.util.List;

@RestController
public class UserJoinsController {

    @Autowired
    UserJoinsService teamservice;

    @RequestMapping(method= RequestMethod.POST, value="/teams")
    public void createTeam(@RequestBody Team team) {
        teamservice.createTeam(team);
    }

    @RequestMapping(method=RequestMethod.GET, value="/teams")
    public List<Team> getAllTeams() {
        return teamservice.findAllTeams();
    }

    @RequestMapping(method=RequestMethod.GET, value="/teams/{event_id}/{team_number}")
    public Team findTeamById(@PathVariable String event_id,@PathVariable int team_number) {
        return teamservice.findTeamById(event_id, team_number);
    }

    @RequestMapping(method=RequestMethod.GET, value="/teams/{event_id}")
    public List<Team> findAllTeamById(@PathVariable String event_id) {
        return teamservice.findAllTeamsById(event_id);
    }

    @RequestMapping(method=RequestMethod.GET, value="/teams_name/{name}")
    public Team findTeamByName(@PathVariable String name) {
        return teamservice.findTeamByName(name);
    }


    @RequestMapping(method= RequestMethod.DELETE, value="/teams/{event_id}/{team_number}")
    public void deleteTeam(@PathVariable String event_id, @PathVariable int team_number) {
        teamservice.deleteTeam(event_id, team_number);
    }

}
