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

        <RouterLink :to="{ name: 'login' }" v-if="authStore.tokenCheck == ''"
          >Login | 
        </RouterLink>

        <RouterLink :to="{ name: 'logout' }" v-if="authStore.tokenCheck != ''" @click="authStore.logout"
          >Logout | 
        </RouterLink>

        <RouterLink :to="{ name: 'register' }" v-if="authStore.tokenCheck == ''">
          Register
        </RouterLink>

        <!-- <RouterLink :to="{ name: 'profile' }" v-if="authStore.tokenCheck != ''">
          Profile
        </RouterLink> -->
      </div>
    </nav>
  </body>
  </div>
  <RouterView />
</template>

<style>
header {
  display: flex;
  justify-content: center;
  background-size: cover;
  background-color: white;
}

a {
  color: white;
  font-size: 30px;
  font-style: none;
  text-decoration: none;
}

body {
  background-color: #b5dfa4;
}

</style>
