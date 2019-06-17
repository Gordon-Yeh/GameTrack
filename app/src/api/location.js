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

export function getLocationsFromServer() {

    return fetch("/locations", { mode: 'no-cors' })
    .then(res => {
      return res.json()
    })
    .then(
      (result) => {
        alert(result);
        console.log(result);;
        return result;
      },
      // Note: it's important to handle errors here
      // instead of a catch() block so that we don't swallow
      // exceptions from actual bugs in components.
      (error) => {
        alert(error);
        console.log(error);
      }
    );
  // .then(
  //   (result) => {
  //     alert(result)
  //     return result
  //   },
  //   // Note: it's important to handle errors here
  //   // instead of a catch() block so that we don't swallow
  //   // exceptions from actual bugs in components.
  //   (error) => {
  //     alert(error);
  //   }
  // );
}
