import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import Login from '../views/Login.vue'
import Register from '../views/Register.vue'
import Logout from '../views/Logout.vue'
import Profile from '../views/Profile.vue'
import Transactions from '../views/Transactions.vue'
import Balance from '../views/Balance.vue'
import Transfer from '../views/Transfer.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: "/login",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/logout",
      name: "logout",
      component: Logout,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/profile",
      name: "profile",
      component: Profile,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/authorized",
      name: "authorized",
      component: Transactions,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/balance/",
      name: "balance",
      component: Balance,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/transfer",
      name: "transfer",
      component: Transfer,
      meta: {
        requiresAuth: true
      }
    }
  ]
})

export default router
