import Vue from 'vue'
import Vuex from 'vuex'
import topic from './modules/topic'
import category from './modules/category'
import cart from './modules/cart'
// import manage from'./module/manage'

Vue.use(Vuex)

export default new Vuex.Store({
  modules: {
    topic,
    category,
    cart,
    // manage
  }
})
