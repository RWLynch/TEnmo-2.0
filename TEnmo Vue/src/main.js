import { createApp } from 'vue'
import { createPinia } from 'pinia'
import { useStore } from './stores/authStore'

import App from './App.vue'
import router from './router'
import axios from 'axios'

axios.defaults.baseURL = import.meta.env.VUE_APP_REMOTE_API;

const app = createApp(App)

const pinia = createPinia();
const store = useStore(pinia);


app.use(createPinia())
app.use(router)

app.mount('#app')

