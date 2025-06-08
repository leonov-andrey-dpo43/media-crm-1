import { createApp } from 'vue';
import App from './App.vue';
import store from './store.js';
import { library } from '@fortawesome/fontawesome-svg-core';
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';
import { fas } from '@fortawesome/free-solid-svg-icons';
import { far } from '@fortawesome/free-regular-svg-icons';
import { fab } from '@fortawesome/free-brands-svg-icons';

// Добавление иконок в библиотеку FontAwesome
library.add(fas, far, fab);

// Создание экземпляра приложения Vue
const app = createApp(App);

// Использование хранилища Vuex
app.use(store);

// Регистрация компонента FontAwesomeIcon
app.component('font-awesome-icon', FontAwesomeIcon);

// Монтирование приложения
app.mount('#app');