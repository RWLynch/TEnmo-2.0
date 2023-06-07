<script>
import { useStore } from '../stores/authStore'

export default {
  data() {
    return {
      currentUser: null
    }
  },
  computed: {
    user() {
      const authStore = useStore()
      return authStore.getCurrentUser
    }
  }
}
</script>

<template>
  <div>
    <h1>This is your profile</h1>

    <p>Name: {{ user.firstName }} {{ user.lastName }}</p>
    <p>Username: {{ user.username }}</p>
    <p>Email Address: {{ user.email }}</p>
    <p>Phone Number: {{ user.phone }}</p>
  </div>
</template>

<style></style>
