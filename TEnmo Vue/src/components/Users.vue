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
            <h3 class="modal-title">Send Money to (person's name or user name here)</h3>
          </div>
          <div class="modal-body">
            <p>Amount to Send</p>
            <p>Show Current Balance</p>
            <p>Recipient Profile Card?</p>
            
          </div>
          <div class="modal-footer">
            <button class="button" @click="closeModal">Close</button>
          </div>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  import { useStore } from '../stores/authStore'
  import UserService from '../services/UserService'
  
  export default {
    name: 'users-list',
    data() {
      return {
        users: [],
        selectedUser: null,
        showModal: false
      }
    },
    created() {
      const authStore = useStore()
  
      UserService.getUsersList().then((response) => {
        this.users = response.data.filter((user) => user.id !== authStore.getUserId)
        console.log(authStore.getUserId)
        console.log(response.data)
      })
    },
    methods: {
      openModal(user) {
        this.selectedUser = user;
        this.showModal = true;
      },
      closeModal() {
        this.selectedUser = null;
        this.showModal = false;
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
  