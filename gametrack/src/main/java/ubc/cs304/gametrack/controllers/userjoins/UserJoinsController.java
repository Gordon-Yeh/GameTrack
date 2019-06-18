package ubc.cs304.gametrack.controllers.userjoins;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ubc.cs304.gametrack.entities.LeaderboardUser;
import java.util.List;
import ubc.cs304.gametrack.entities.UserJoins;


@RestController
public class UserJoinsController {

    @Autowired
    UserJoinsService userJoinsService;

    @RequestMapping(method=RequestMethod.GET, value="/users/leaderboards/{sport}")
    public List<LeaderboardUser> getLeaderboard(@PathVariable String sport) {
        return userJoinsService.getLeaderboard(sport);
    }

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
