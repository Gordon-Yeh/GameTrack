import locationSamples from '../test-data/locations.json';

/**
 * get available location based on the sport and the user's location
 * @param {} sport 
 */
export function getLocations(sport) {
  return new Promise((resolve, reject) => {
    let fakeCall = setTimeout(() => {
      resolve(locationSamples);
    }, 200);
  });
}

export async function getLocationsFromServer() {

    try {
    const res = await fetch("/locations");
    const result = await res.json();
    return result;
  }
  catch (error) {
    console.log(error);
  }
}
