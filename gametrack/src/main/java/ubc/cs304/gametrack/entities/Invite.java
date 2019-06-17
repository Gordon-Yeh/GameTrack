package ubc.cs304.gametrack.entities;

import java.util.UUID;

public class Invite {
    private UUID host_user_id;
    private UUID guest_user_id;
    private UUID event_id;
    private Event event;
    private User host;

    public Invite() {
    }

    public Invite(UUID host_user_id, UUID guest_user_id, UUID event_id) {
        this.host_user_id = host_user_id;
        this.guest_user_id = guest_user_id;
        this.event_id = event_id;
    }

    public UUID getHost_user_id() {
        return host_user_id;
    }

    public void setHost_user_id(UUID host_user_id) {
        this.host_user_id = host_user_id;
    }

    public UUID getGuest_user_id() {
        return guest_user_id;
    }

    public void setGuest_user_id(UUID guest_user_id) {
        this.guest_user_id = guest_user_id;
    }

    public UUID getEvent_id() {
        return event_id;
    }

    public void setEvent_id(UUID event_id) {
        this.event_id = event_id;
    }

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public User getHost() {
		return host;
	}

	public void setHost(User host) {
		this.host = host;
	}
}
