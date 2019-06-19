package ubc.cs304.gametrack.controllers.invite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import ubc.cs304.gametrack.controllers.event.EventService;
import ubc.cs304.gametrack.controllers.user.UserService;
import ubc.cs304.gametrack.entities.Invite;

import java.util.List;

@Service
public class InviteService {

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	EventService eventService;
	@Autowired
	UserService userService;
	
	void createInvite(Invite invite) {

		jdbcTemplate.update("INSERT INTO Invite (host_user_id,guest_user_id,event_id) VALUES (?,?,?)",
				invite.getHost_user_id().toString(), invite.getGuest_user_id().toString(),
				invite.getEvent_id().toString());

	}

	List<Invite> findAllInvites() {
		return jdbcTemplate.query("SELECT host_user_id,guest_user_id,event_id FROM Invite",
				new BeanPropertyRowMapper<Invite>(Invite.class));
	}

	Invite findInviteByUser(String user_id) {
		List<Invite> invites = findAllInvites();
		return invites.stream().filter(i -> i.getHost_user_id().toString().equals(user_id)).findFirst()
				.orElse(new Invite());
	}

	List<Invite> findInvitesByGuest(String guest_id) {
		List<Invite> invites =  jdbcTemplate.query(
				"SELECT host_user_id,guest_user_id,event_id FROM Invite WHERE guest_user_id='" + guest_id + "'",
				new BeanPropertyRowMapper<Invite>(Invite.class));
		invites.forEach(i -> {
			System.out.println(i);
			i.setEvent(eventService.findEventBy(i.getEvent_id().toString()));
			i.setHost(userService.findUserByUserId(i.getHost_user_id().toString()));
		});
		return invites;
	}

	Invite findInviteByEvent(String event_id) {
		List<Invite> invites = findAllInvites();
		return invites.stream().filter(i -> i.getEvent_id().toString().equals(event_id)).findFirst()
				.orElse(new Invite());
	}
}
