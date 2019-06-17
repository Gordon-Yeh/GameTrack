package ubc.cs304.gametrack.controllers.userjoins;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ubc.cs304.gametrack.entities.UserJoins;

@RestController
public class UserJoinsController {

	@Autowired
	UserJoinsService userJoinsService;
	//
	// @RequestMapping(method= RequestMethod.POST, value="/teams")
	// public void createTeam(@RequestBody Team team) {
	// teamservice.createTeam(team);
	// }
	//
	// @RequestMapping(method=RequestMethod.GET, value="/teams")
	// public List<Team> getAllTeams() {
	// return teamservice.findAllTeams();
	// }
	//
	// @RequestMapping(method=RequestMethod.GET,
	// value="/teams/{event_id}/{team_number}")
	// public Team findTeamById(@PathVariable String event_id,@PathVariable int
	// team_number) {
	// return teamservice.findTeamById(event_id, team_number);
	// }
	//
	// @RequestMapping(method=RequestMethod.GET, value="/teams/{event_id}")
	// public List<Team> findAllTeamById(@PathVariable String event_id) {
	// return teamservice.findAllTeamsById(event_id);
	// }
	//
	// @RequestMapping(method=RequestMethod.GET, value="/teams_name/{name}")
	// public Team findTeamByName(@PathVariable String name) {
	// return teamservice.findTeamByName(name);
	// }
	//
	//
	// @RequestMapping(method= RequestMethod.DELETE,
	// value="/teams/{event_id}/{team_number}")
	// public void deleteTeam(@PathVariable String event_id, @PathVariable int
	// team_number) {
	// teamservice.deleteTeam(event_id, team_number);
	// }

	@RequestMapping(method = RequestMethod.POST, value = "/userJoinsTeam")
	public void userJoinsTeam(@RequestBody UserJoins joinReq) {
		userJoinsService.joinTeam(joinReq);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/kickOutOfTeam")
	public void kickOutOfTeam(@RequestBody UserJoins kickReq) {
		userJoinsService.removeUser(kickReq.getUser_id().toString(), kickReq.getEvent_id().toString(),
				String.valueOf(kickReq.getTeam_number()));
	}

}
