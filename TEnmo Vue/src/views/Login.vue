<template>
    <div id="login">
      <form @submit.prevent="login">
        <h1>Please Sign In</h1>
        <div role="alert" v-if="invalidCredentials">
          Invalid username and password!
        </div>
        <div role="alert" v-if="this.$route.query.registration">
          Thank you for registering, please sign in.
        </div>
        <div class="form-input-group">
          <label for="username">Username</label>&nbsp;
          <input
            type="text"
            id="username"
            v-model="user.username"
            required
            autofocus
          />
        </div>
        <div class="form-input-group">
          <label for="password">Password</label>&nbsp;
          <input type="password" id="password" v-model="user.password" required />
        </div>
        <br /><br />
        <button type="submit">Sign in</button>&nbsp;&nbsp;
        <router-link :to="{ name: 'register' }"
          >Need an account? Sign up.</router-link
        >
      </form>
    </div>
  </template>
  
  <script>
  import authService from "../services/AuthService";
  
  export default {
    name: "login",
    components: {},
    data() {
      return {
        user: {
          username: "",
          password: "",
        },
        invalidCredentials: false,
      };
    },
    methods: {
      login() {
        authService
          .login(this.user)
          .then((response) => {
            console.log(response.status)
            if (response.status == 200) {
              this.$store.commit("SET_AUTH_TOKEN", response.data.token);
              this.$store.commit("SET_USER", response.data.user);
              this.$router.push("/");
            }
          })
          .catch((error) => {
            const response = error.response;
  
            if (response.status === 401) {
              this.invalidCredentials = true;
            }
          });
      },
    },
  };
  </script>