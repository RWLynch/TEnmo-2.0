import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:8080"
});

export default {
    getBalance(id) {
        return http.get(`/account/${id}`)
      },
    }