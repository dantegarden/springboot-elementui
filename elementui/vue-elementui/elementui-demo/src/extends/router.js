import Vue from 'vue'
import router from '@/router'

Vue.prototype.$go = function (path, cache = true) {
  if (cache) {
    router.push(path)
  } else {
    router.replace(path)
  }
}
Vue.prototype.$back = function () {
  router.go(-1)
}
Vue.prototype.$redirect = function(path) {
  router.replace(path)
}
