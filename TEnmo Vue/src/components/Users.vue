<template>
  <div>
    <div>
      <table class="table table-hover">
        <thead>
          <tr>
            <th>Name</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Profile Photo</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="user in users" :key="user.userId" @click="openModal(user)">
            <td class="user-name">{{ user.username }}</td>
            <td class="first-name">{{ user.firstName }}</td>
            <td class="last-name">{{ user.lastName }}</td>
            <td class="profile-pic-table">
              <img :src="user.profilePicture" class="profile-img" />
            </td>
          </tr>
        </tbody>
      </table>
    </div>

    <div class="modal" :class="{ 'is-active': showModal }">
      <div class="modal-background"></div>
      <div class="modal-content">
        <div class="modal-header">
          <h3 class="modal-title">{{ selectedUser.username }}</h3>
          <img :src="selectedUser.profilePicture" class="large-profile-img" />
        </div>
        <div class="modal-body">
          <div class="bal">
            <h3>Current balance: ${{ balance }}</h3>
          </div>
          <form>
            <h1 class="h3 mb-3 fw-normal">Please enter an amount.</h1>
            <!-- <div role="alert" v-if="invalidTransaction"> -->
            <!--create function for if send amount is greater than their balance-->
            <div class="form-floating">
              <input type="number" min="0.00" class="form-control" id="floatingInput" placeholder="amount">
              <label for="floatingInput">Enter amount $</label>
            </div>
            <div class="form-floating">
              <input type="text" class="form-control" id="floatingInput" placeholder="note">
              <label for="floatingInput">Note</label>
            </div>
            <div class="btn group">
              <button class="btn btn-primary btn-lg mx-1">Pay</button>
              <button class="btn btn-primary btn-lg mx-1">Request</button>
            </div>
        </form>
      </div>
      <div class="modal-footer">
        <button class="button" @click="closeModal">Close</button>
      </div>
    </div>
  </div>
</div></template>
  
<script>
import { useStore } from '../stores/authStore'
import UserService from '../services/UserService'
import TransactionService from '../services/TransactionService'

export default {
  name: 'users-list',
  data() {
    return {
      users: [],
      selectedUser: "",
      showModal: false,
      balance: null,
      transfer: {
        transferType: null,
        transferStatus: null,
        accountFrom: null,
        accountTo: null,
        amount: 0,
        note: ""
      }
    }
  },
  computed: {
    userId() {
      const authStore = useStore()
      return authStore.getUserId
    }
  },
  created() {
    const authStore = useStore()

    UserService.getUsersList().then((response) => {
      this.users = response.data.filter((user) => user.id !== authStore.getUserId)
      console.log(authStore.getUserId)
      console.log(response.data)
    }),
      this.bal(this.userId)
  },
  methods: {
    openModal(user) {
      this.selectedUser = user;
      this.showModal = true;
    },
    closeModal() {
      this.selectedUser = "";
      this.showModal = false;
    },
    bal(userId) {
      TransactionService.getBalance(userId)
        .then((response) => {
          this.balance = response.data
        })
        .catch((error) => {
          console.log(error)
        })
    },
    setTwoNumberDecimal(event) {
      this.value = parseFloat(this.value).toFixed(2);
    }
  }
}
</script>
  
<style>
.profile-img {
  max-height: 30px;
  max-width: 30px;
  border-radius: 50%;
  border: 2px white solid;
}

.large-profile-img {
  max-height: 75px;
  max-width: 75px;
  border-radius: 50%;
  border: 2px white solid;
}

.modal {
  display: none;
}

.modal.is-active {
  display: flex !important;
  align-items: center;
  justify-content: center;
}

.modal-background {
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background-color: rgba(0, 0, 0, 0.5);
}

.modal-content {
  background-color: #fff;
  border-radius: 4px;
  padding: 1rem;
}

.modal-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  border-bottom: 1px solid #ccc;
  padding-bottom: 0.5rem;
  margin-bottom: 0.5rem;
}

.modal-title {
  margin: 0;
}

.modal-body {
  margin-bottom: 1rem;
}

.modal-footer {
  display: flex;
  justify-content: flex-end;
}
</style>
  