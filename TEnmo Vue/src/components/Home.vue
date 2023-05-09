<script>
import { useStore } from '../stores/authStore'

export default {
  computed: {
    userName() {
      const authStore = useStore()
      return authStore.userName
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
