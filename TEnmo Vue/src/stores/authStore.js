import { defineStore } from 'pinia';
import axios from 'axios';

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
    logout() {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      this.token = '';
      this.user = {};
      axios.defaults.headers.common = {};
    }
  },
    getters: {
        userFirstName() {
          return this.user ? this.user.firstName : '';
        },
        tokenCheck() {
            console.log(this.token);
            console.log(this.user);
            return this.token ? this.token : '';
        },
        getUserId(){
          return this.user.id;
        },
        getCurrentUser() {
          console.log(this.user)
          return this.user;
        }
  }
});