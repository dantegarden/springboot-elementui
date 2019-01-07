import Vue from 'vue'
import Vuex from 'vuex'
import getters from './getters'
import common from './modules/common'
import user from './modules/user'
import permission from './modules/permission'
import demo from './modules/demo'

Vue.use(Vuex);

export default new Vuex.Store({
  modules: {
    common,
    user,
    permission,
    demo
  },
  getters
});
