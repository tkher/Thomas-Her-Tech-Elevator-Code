import './assets/main.css'

import { createApp } from 'vue'
import App from './App.vue'
import router from './router'

/* import fontawesome core */
import { library } from '@fortawesome/fontawesome-svg-core'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
import { faTrashCan, faRotate, faPenToSquare, faHouse } from '@fortawesome/free-solid-svg-icons'

/* add icons to the library */
library.add(faTrashCan);
library.add(faRotate);
library.add(faPenToSquare);
library.add(faHouse);

const app = createApp(App)
app.use(router)
app.component('font-awesome-icon', FontAwesomeIcon);
app.mount('#app')
