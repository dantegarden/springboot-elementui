// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import 'normalize.css/normalize.css' //css reset
import App from './App'
import router from './router'
import store from './store'

//element-ui
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css';
Vue.use(ElementUI);

//axios
import AxiosPlugin from './libs/AxiosPlugin'
Vue.use(AxiosPlugin)

//extends
import '@/extends'

Vue.config.productionTip = false;

/* eslint-disable no-new */
new Vue({
  el: '#app',
  store,
  router,
  template: '<App/>',
  components: { App }
})
