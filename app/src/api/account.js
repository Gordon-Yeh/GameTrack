import messageSamples from '../test-data/messages.json';
import { API_ENDPOINT } from '../env.js';

/**
 * Attempts to login with the given user info
 * @param {String} username 
 * @param {String} password
 * @return {Promise} 
 */
export function login(username, password) {
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
export function signup(userInfo) {
  return new Promise((resolve, reject) => {
    fetch('/users', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(userInfo)
      })
    .then((res) => {
      if (res.status === 200) {
        resolve();
      } else {
        console.log(res.statusText);
        reject(res.statusText);
      }
    })
    .catch((err) => {
      console.log(err);
    });
  });
}

export function getMessages() {
  return new Promise((resolve, reject) => {
    let fakeCall = setTimeout(() => {
      resolve(messageSamples);
    }, 200);
  });
}

export function sendMessage() {
  return new Promise((resolve, reject) => {
    let fakeCall = setTimeout(() => {
      resolve();
    }, 200);
  });
}

export async function getAllUsers() {
  try {
    const res = await fetch(`/users`);
    const result = await res.json();
    console.log(result);
    return result;
  }
  catch (error) {
    console.log(error);
  }
}