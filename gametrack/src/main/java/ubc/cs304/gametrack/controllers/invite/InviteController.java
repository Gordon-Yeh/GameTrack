package ubc.cs304.gametrack.controllers.invite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ubc.cs304.gametrack.entities.Invite;

import java.util.List;

@RestController
public class InviteController {

    @Autowired
    InviteService inviteService;

    @RequestMapping(method= RequestMethod.POST, value="/invites")
    public void createInvite(@RequestBody Invite invite) {
        inviteService.createInvite(invite);
    }

    @RequestMapping(method=RequestMethod.GET, value="/invites")
    public List<Invite> getAllInvites() {
        return inviteService.findAllInvites();
    }

    @RequestMapping(method=RequestMethod.GET, value="/invites_user/{user_id}")
    public Invite getInviteByUser(@PathVariable String user_id) {
        return inviteService.findInviteByUser(user_id);
    }

    @RequestMapping(method=RequestMethod.GET, value="/invites_guest/{guest_id}")
    public Invite getInviteByGuest(@PathVariable String guest_id) {
        return inviteService.findInviteByGuest(guest_id);
    }

    @RequestMapping(method=RequestMethod.GET, value="/invites_event/{event_id}")
    public Invite getInviteByEvent(@PathVariable String event_id) {
        return inviteService.findInviteByEvent(event_id);
    }

}
