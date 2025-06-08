import { createApp } from 'vue';
import { createStore } from 'vuex';

const store = createStore({
    state: {
        isModalWindowVisible: false
    },
    mutations: {
        CHANGE_MODALWINDOW: (state) => {
            state.isModalWindowVisible = true;
        }
    },
    actions: {
        SHOW_MODALWINDOW({commit}) {
            commit('CHANGE_MODALWINDOW');
        }
    },
    getters: {
        MODALWINDOW_STATE(state) {
            return state.isModalWindowVisible;
        }
    }
});

const app = createApp({});
app.use(store);

export default store;