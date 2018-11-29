import Vue from 'vue'
import router from '@/router'

//判断是否有token,没有则登陆
router.beforeEach((to, from, next) => {
  document.title = '后台管理系统'
  if (to.path != '/login') {
    var token = sessionStorage.getItem('token');
    if (token == null) {
      next({path:'/login'});
    } else {
      //根据后台返回的路由进行判断是否合法
      var routers = sessionStorage.getItem('routers');
      var flag = false;
      routers.split("_").forEach( v => {
        if(v == to.path) {
          flag = true;
        }
      });

      if(flag) {
        next();
      } else {
        next({path:'/home'});
      }
    }
  } else {
    next();
  }
})

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
