<script>
import { useStore } from '../stores/authStore'
import TransactionService from '../services/TransactionService'
import { RouterLink } from 'vue-router'

export default {
  data() {
    return {
      balance: null
    }
  },
  computed: {
    userId() {
      const authStore = useStore()
      return authStore.userId
    }
  },
  created() {
    this.bal(this.userId)
  },
  methods: {
    bal(userId) {
      TransactionService.getBalance(userId)
        .then((response) => {
          this.balance = response.data
        })
        .catch((error) => {
          console.log(error)
        })
    }
  },
  components: { RouterLink }
}
</script>

<template>
  <div>
    <div class="bal">
      <h3>Current balance: $ {{ balance }}</h3>   
    </div>
    <div class="bal">
      <RouterLink to="authorized">back</RouterLink>
    </div>
  </div>
</template>

<style scoped>
.bal {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100px;
}
</style>
