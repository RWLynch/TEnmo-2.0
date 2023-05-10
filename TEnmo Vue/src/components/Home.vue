<script>
import { useStore } from '../stores/authStore'

export default {
  computed: {
    userName() {
      const authStore = useStore()
      return authStore.userFirstName
    }
  }
}
</script>

<template>
  <div>
    <h1>Welcome, {{ userName }}!</h1>
  </div>
</template>

<style></style>
