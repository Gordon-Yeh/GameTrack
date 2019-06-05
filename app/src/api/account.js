/**
 * Attempts to login with the given user info
 * @param {String} username 
 * @param {String} password
 * @return {Promise} 
 */
function login(username, password) {
  return new Promise((resolve, reject) => {
    // TODO: add real api call when server is set up
    let fakeCall = setTimeout(() => {
      if (username !== 'admin' || password !== '123123') {
        reject('DOES_NOT_EXIST');
      } else {
        resolve();
      }
    }, 200);
  })
}

module.exports = {
  login,
};
