<template>
  <h1>Send Money</h1>
  <h3>Select a user</h3>
  <Users />
  //modal
</template>

<script>
import { useStore } from '../stores/authStore'
import TransactionService from '../services/TransactionService'
import { RouterLink } from 'vue-router'
import Users from '../components/Users.vue'

export default {
  components: { Users }
}
</script>

<style></style>
