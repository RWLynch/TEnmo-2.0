<script setup>
import { RouterLink, RouterView } from 'vue-router'
import { useStore } from './stores/authStore'

const authStore = useStore();
</script>

<template>
  <div>
    <header>
    <img class="logo" src="src\assets\TEnmo logo.png" alt="the" />
    </header>
    <body>
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
  </body>
  </div>
  <RouterView />
</template>

<style>
header {
  background-color: white;
}

a {
  color: white;
  font-size: 30px;
  font-style: none;
  text-decoration: none;
}
.logo {
  /* position: absolute; */
  top: 0;
  left: 0;
  max-width: 100vw;
  padding: 0;
  margin: 0;
}
body {
  margin-top: 120px;
  background-color: #b5dfa4;
}

</style>
