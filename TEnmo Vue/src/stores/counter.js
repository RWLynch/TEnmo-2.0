import { defineStore } from 'pinia';
import axios from 'axios';

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token');
const currentUser = JSON.parse(localStorage.getItem('user'));

if (currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export const useStore = defineStore({
  id: 'auth-store',
  state: () => ({
    latest: null,
    token: currentToken || '',
    user: currentUser || {},
  }),
  actions: {
    SET_AUTH_TOKEN(token) {
      this.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`;
    },
    SET_USER(user) {
      this.user = user;
      localStorage.setItem('user', JSON.stringify(user));
    },
    LOGOUT() {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      this.token = '';
      this.user = {};
      axios.defaults.headers.common = {};
    }
  }
});
