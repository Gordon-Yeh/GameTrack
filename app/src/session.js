// reference: https://www.npmjs.com/package/js-cookie
import * as Cookies from "js-cookie";

let cookieValue = 'user';
let sessionUser = null;
// let sessionLifeInDays = 1;

/**
 * get user session from cookie
 * @returns null if no session or session expired
 */
export function getSessionFromCookie() {
  let session = Cookies.getJSON(cookieValue);
  return session ? session : null;
}

/**
 * check if browse has a session currently
 * @returns {Bool}
 */
export function hasSession() {
  if (sessionUser !== null) {
    return true;
  }
  sessionUser = getSessionFromCookie();
  return (sessionUser !== null);
}

/**
 * stores a new session in browser
 * @param {Object} user 
 */
export function storeSession(user) {
  // by default the cookie is removed when browser is closed
  Cookies.set(cookieValue, user); // TODO: add expiration , { expires: sessionLifeInDays });
  sessionUser = user;
}
