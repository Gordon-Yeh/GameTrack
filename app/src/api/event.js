/**
 * Attempts to create a new event
 * @param {Object} eventInfo
 */
export function createEvent(eventInfo) {
  return new Promise((resolve, reject) => {
    fetch('/events', {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(eventInfo)
    })
    .then((res) => {
      if (res.status === 200) {
        resolve();
      } else {
        reject(res.statusText);
      }
    })
  });
}

/**
 * Attempts to update an existing event
 * @param {Object} eventInfo
 */
export function editEvent(eventId, eventInfo) {
  return new Promise((resolve, reject) => {
    const body = {
      ...eventInfo,
      event_id: eventId,
    };

    fetch('/events', {
      method: 'PUT',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(body)
    })
    .then((res) => {
      if (res.status === 200) {
        resolve();
      } else {
        reject(res.statusText);
      }
    })
  });
}


/**
 * get all events 
 */
export async function getAllEvents() {
  try {
    const res = await fetch("/events");
    const result = await res.json();
    return result;
  }
  catch (error) {
    console.log(error);
  }
}

/**
 * get all events 
 */
export async function getFilteredEvents(filters) {
  try {
    const res = await fetch("/events/filtered", {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(filters)
    });
    const result = await res.json();
    return result;
  }
  catch (error) {
    console.log(error);
  }
}

export async function getEventTeams(eventId) {
  try {
    const res = await fetch(`/teams/${eventId}`);
    const result = await res.json();
    return result;
  }
  catch (error) {
    console.log(error);
  }
}

export async function joinTeam(eventId, userId, teamNo) {
  try {
    let joinReq = {};
    joinReq.event_id = eventId;
    joinReq.user_id = userId;
    joinReq.team_number = teamNo;
    const res = await fetch("/userJoinsTeam", {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(joinReq)
    });
    const result = await res.json();
    return result;
  }
  catch (error) {
    console.log(error);
  }
}

export async function kickOutOfTeam(eventId, userId, teamNo) {
  try {
    let kickReq = {};
    kickReq.event_id = eventId;
    kickReq.user_id = userId;
    kickReq.team_number = teamNo;
    const res = await fetch("/kickOutOfTeam", {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(kickReq)
    });
    const result = await res.json();
    return result;
  }
  catch (error) {
    console.log(error);
  }
}

export async function inviteUserToEvent(eventId, userId, recipientId) {
  try {
    let invite = {};
    invite.host_user_id = userId;
    invite.guest_user_id = recipientId;
    invite.event_id = eventId;
    const res = await fetch("/invites", {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(invite)
    });
    const result = await res.json();
    return result;
  }
  catch (error) {
    console.log(error);
  }
}

// @RequestMapping(method=RequestMethod.GET, value="/invites_guest/{guest_id}")
export async function getUsersInvites(userId) {
  try {
    const res = await fetch(`/invites_guest/${userId}`);
    const result = await res.json();
    return result;
  }
  catch (error) {
    console.log(error);
  }
}

export async function getUserEvents(userId) {
  try {
    const res = await fetch(`/events/user_id=${userId}`);
    const result = await res.json();
    return result;
  }
  catch (error) {
    console.log(error);
  }
}

export async function getEventsUserJoined(userId) {
  try {
    const res = await fetch(`/eventsUserJoined/${userId}`);
    const result = await res.json();
    return result;
  }
  catch (error) {
    console.log(error);
  }
}

