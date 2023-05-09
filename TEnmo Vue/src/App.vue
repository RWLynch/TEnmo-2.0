<script setup>
import { RouterLink, RouterView } from 'vue-router'
import { useStore } from './stores/authStore'

const authStore = useStore();
</script>

<template>
  <div>
    <img class="logo" src="src\assets\TEnmo logo.png" alt="" />
    <nav>
      <div>
        <RouterLink class="link" to="/">
          <span class="link-text">Home | </span>
        </RouterLink>

        <!-- <RouterLink to="/login">
        <span class="link-text">Login | </span>
      </RouterLink> -->

        <RouterLink :to="{ name: 'login' }" v-if="authStore.tokenCheck == ''"
          >Login | 
        </RouterLink>

        <RouterLink :to="{ name: 'logout' }" v-if="authStore.tokenCheck != ''" @click="authStore.logout"
          >Logout
        </RouterLink>

        <RouterLink :to="{ name: 'register' }" v-if="authStore.tokenCheck == ''">
          Register
        </RouterLink>
      </div>
    </nav>
  </div>
  <RouterView />
</template>

<style>
a {
  color: white;
  font-size: 30px;
  font-style: none;
  text-decoration: none;
}
.logo {
  max-width: 100vw;
  padding: 0;
  margin: 0;
}
body {
  background-color: #b5dfa4;
}
</style>
