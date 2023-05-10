<script>
import { useStore } from '../stores/authStore'

export default {
  computed: {
    userName() {
      const authStore = useStore()
      return authStore.userFirstName
    },
    token() {
      const authStore = useStore()
      return authStore.tokenCheck
    }
  }
}
</script>

<template>
  <div>
    <h1 class="greeting" v-if="token != ''">Welcome, {{ userName }}!</h1>
    <h1 class="greeting" v-else="token == ''">Hello! Please log in.</h1>
  </div>
</template>

<style></style>
