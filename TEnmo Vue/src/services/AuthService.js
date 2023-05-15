import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:8080"
});

export default {

  login(payload) {
    return http.post('/login', payload)
  },

  register(user) {
    return http.post('/register', user)
  },

  getCurrentUser() {
    return axios.get('/user')
  },

}