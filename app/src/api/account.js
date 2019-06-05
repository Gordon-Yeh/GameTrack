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
  });
}

/**
 * Attempts to create a new account with the given user info
 * @param {Object} userInfo 
 */
function signup(userInfo) {
  return new Promise((resolve, reject) => {
    // TODO: add real api call when server is set up
    let fakeCall = setTimeout(() => {
      if (userInfo.username === 'admin') {
        reject('USERNAME_ALREADY_EXIST');
      } else {
        resolve();
      }
    }, 200);
  });
}

module.exports = {
  login,
  signup
};
