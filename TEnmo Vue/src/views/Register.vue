<template>
  <div id="register" class="text-center">
    <form @submit.prevent="register">
      <h1>Create Account</h1>
      <div role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <div class="form-input-group">
        <label for="username">Username</label>
        <input type="text" id="username" v-model="user.username" required autofocus />
      </div>
      <div class="form-input-group">
        <label for="password">Password</label>
        <input type="text" id="password" v-model="user.password" required />
      </div>
      <div class="form-input-group">
        <label for="confirmPassword">Confirm Password</label>
        <input type="text" id="confirmPassword" v-model="user.confirmPassword" required />
      </div>
      <div class="form-input-group">
        <label for="firstName">First Name</label>
        <input type="text" id="firstName" v-model="user.firstName" required />
      </div>
      <div class="form-input-group">
        <label for="lastName">Last Name</label>
        <input type="text" id="lastName" v-model="user.lastName" required />
      </div>
      <div class="form-input-group">
        <label for="emailAddress">Email Address</label>
        <input type="text" id="emailAddress" v-model="user.email" required />
      </div>
      <div class="form-input-group">
        <label for="phone">Phone</label>
        <input type="text" id="phone" v-model="user.phone" required />
      </div>
      <!-- <div class="form-input-group">
          <label for="profilePicture">Photo URL</label>
          <input type="text" id="profilePicture" v-model="user.profilePicture" />
        </div> -->
      <button type="submit">Create Account</button>
      <p><router-link :to="{ name: 'login' }">Already have an account? Log in.</router-link></p>
    </form>
  </div>
</template>

<script>
import authService from '../services/AuthService'

export default {
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        firstName: '',
        lastName: '',
        email: '',
        phone: '',
        profilePicture: '',
        role: 'user'
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.'
    }
  },
  methods: {
    async register() {
      if (this.user.password !== this.user.confirmPassword) {
        this.registrationErrors = true
        this.registrationErrorMsg = 'Password & Confirm Password do not match.'
        return
      }

      try {
        console.log(this.user)
        const response = await authService.register(this.user)

        if (response.status === 201) {
          this.$router.push({
            path: '/login',
            query: { registration: 'success' }
          })
        }
      } catch (error) {
        const response = error.response
        this.registrationErrors = true

        if (response && response.status === 400) {
          this.registrationErrorMsg = 'Bad Request: Validation Errors'
        }
      }
    },
    clearErrors() {
      this.registrationErrors = false
      this.registrationErrorMsg = 'There were problems registering this user.'
    }
  }
}
</script>

<style scoped>
.form-input-group {
  margin-bottom: 1rem;
}
label {
  margin-right: 0.5rem;
}
</style>
