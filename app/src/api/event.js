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
