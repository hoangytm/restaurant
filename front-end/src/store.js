import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    barColor: 'rgba(0, 0, 0, .8), rgba(0, 0, 0, .8)',
    barImage: 'https://demos.creative-tim.com/material-dashboard/assets/img/sidebar-1.jpg',
    drawer: null,
    session: {
      logged: false,
      token: ''
    }
  },
  mutations: {
    SET_BAR_IMAGE(state, payload) {
      state.barImage = payload
    },
    SET_DRAWER(state, payload) {
      state.drawer = payload
    },
  },
  getters: {
    // could use only this getter and use it for both token and logged
    session: state => state.session,
    // or could have both getters separated
    logged: state => state.session.logged,
    token: state => state.session.token
  },
  actions: {

  },
})
