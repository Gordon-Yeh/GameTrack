import messageSamples from '../test-data/messages.json';
import { storeSession } from '../session.js';

/**
 * Attempts to login with the given user info
 * @param {String} username 
 * @param {String} password
 * @return {Promise} 
 */
export function login(username, password) {
  let body = {
    username,
    password
  };

  return new Promise((resolve, reject) => {
    fetch('/users/login', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(body)
    })
      .then((res) => {
        if (res.status === 200) {
          res.json().then(user => {
            console.log(user);
            storeSession(user)
            resolve();
          })
        } else {
          console.log(res.statusText);
          reject(res.statusText);
        }
      })
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

export async function getMessages(rcvrId) {
  try {
    const res = await fetch(`/messages_receiver/${rcvrId}`);
    const result = await res.json();
    return result;
  }
  catch (error) {
    console.log(error);
  }
}

export async function getMessagesSent(userId) {
  try {
    const res = await fetch(`/messages_sender/${userId}`);
    const result = await res.json();
    return result;
  }
  catch (error) {
    console.log(error);
  }
}

export async function sendMessage(msg) {
  try {
    const res = await fetch("/messages", {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(msg)
    });
    const result = await res.json();
    return result;
  }
  catch (error) {
    console.log(error);
  }
}

export async function getAllUsers() {
  try {
    const res = await fetch(`/users`);
    const result = await res.json();
    return result;
  }
  catch (error) {
    console.log(error);
  }
}