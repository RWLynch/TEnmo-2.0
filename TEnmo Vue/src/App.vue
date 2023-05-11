<script setup>
import { RouterLink, RouterView } from 'vue-router'
import { useStore } from './stores/authStore'
import 'bootstrap/dist/css/bootstrap.css'

const authStore = useStore();
</script>

<template>
  <div>
    <header>
    <img class="logo1" src="src\assets\TEnmo logo.png" alt="the main logo" />
    <img class="logo2" src="src\assets\TE header small logo.png" alt="the other logo" />
    </header>
    <body>
      <div class="nav-items">
    <nav>
      <div>
        <RouterLink class="link" to="/">
          <span class="link-text">Home</span>
        </RouterLink>

        <RouterLink :to="{ name: 'login' }" v-if="authStore.tokenCheck == ''"
          >Login</RouterLink>

        <RouterLink :to="{ name: 'logout' }" v-if="authStore.tokenCheck != ''" @click="authStore.logout"
          >Logout
        </RouterLink>

        <RouterLink :to="{ name: 'register' }" v-if="authStore.tokenCheck == ''"
          >Register
        </RouterLink>
      </div>
    </nav>
      <RouterLink  :to="{ name: 'profile' }" v-if="authStore.tokenCheck != ''">
          <img class="profile-pic" src="src/assets/default_avatar_2.png" />
        </RouterLink>
        </div>

  </body>
  </div>
  <RouterView />
</template>

<style>
header {
  background-size: cover;
  background-color: white;
  display: flex;
  justify-content: space-between;
}

.logo1 {

  max-width: fit-content;
}

.logo2 {
  padding-right: 150px;
  max-height: 300px;
}

nav {
  display: inline-flex;
}

.profile-pic {
  max-width: 50px;
  border-radius: 50%;
  border: 2px white solid;
  float: right;
  margin-right: 10px;
  margin-top: 5px;
}

.profile-pic:hover {
  max-width: 50px;
  border-radius: 50%;
  border: 2px #6a8d5c solid;
}

nav a {
  color: white;
  font-size: 30px;
  font-style: none;
  text-decoration: none;
  padding: 5px;
  margin: 0 5px;
}

body {
  margin: 0 auto;
  background-color: #b5dfa4;
}

nav a.router-link-active {
border-bottom: 2px solid #333;
}

nav a:hover {
  border-bottom: 2px solid #FFF;
}



</style>
