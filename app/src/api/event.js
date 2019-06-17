/**
 * Attempts to create a new event
 * @param {Object} eventInfo
 * @return {Promise} promise to create a new event
 */
export function createEvent(eventInfo) {
  return new Promise((resolve, reject) => {
    let fakeCall = setTimeout(() => {
      const expectedFields = ['isATournament', 'sport', 'locationId', 'teamSize', 'numberOfTeams'];
      const actualFields = Object.keys(eventInfo);
      if (JSON.stringify(actualFields.sort()) === JSON.stringify(expectedFields.sort())) {
        alert(JSON.stringify(eventInfo));
        resolve();
      } else {
        alert(JSON.stringify(eventInfo));
        reject('INVALID_INFO');
      }
    }, 200);
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
    console.log(filters);
    const res = await fetch("/events/filtered", {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(filters)
    });
    const result = await res.json();
    console.log(result);
    return result;
  }
  catch (error) {
    console.log(error);
  }
}


