package ubc.cs304.gametrack.controllers.invite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ubc.cs304.gametrack.entities.Invite;

import java.util.List;

@Service
public class InviteService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    void createInvite(Invite invite) {

        jdbcTemplate.update( "INSERT INTO Invite (host_user_id,guest_user_id,event_id) VALUES (?,?,?)",
                                invite.getGuest_user_id(),
                                invite.getGuest_user_id(),
                                invite.getEvent_id());

    }

    @SuppressWarnings("unchecked")
    List<Invite> findAllInvites() {
        return jdbcTemplate.query("SELECT host_user_id,guest_user_id,event_id FROM Invite",
                new BeanPropertyRowMapper(Invite.class));
    }

    Invite findInviteByUser(String user_id) {
        List<Invite> invites = findAllInvites();
        return invites.stream().filter(i -> i.getHost_user_id().toString().equals(user_id)).findFirst().orElse(new Invite());
    }

    Invite findInviteByGuest(String guest_id) {
        List<Invite> invites = findAllInvites();
        return invites.stream().filter(i -> i.getGuest_user_id().toString().equals(guest_id)).findFirst().orElse(new Invite());
    }

    Invite findInviteByEvent(String event_id) {
        List<Invite> invites = findAllInvites();
        return invites.stream().filter(i -> i.getEvent_id().toString().equals(event_id)).findFirst().orElse(new Invite());
    }
}
