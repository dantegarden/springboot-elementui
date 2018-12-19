import Vue from 'vue'
import Router from 'vue-router'
const _import = file => () => import('@/views/' + file + '.vue')
Vue.use(Router)

export const constantRoutes = [
  {
    path: '/',
    redirect: '/login',
    meta: { hidden:true }
  },
  {
    path: '/login',
    component: _import('Login'),
    meta: { hidden:true }
  },
  {
    path: '/home',
    component: _import('Home'),
    meta: { hidden: true },
    children:[
      {
        path: '',
        meta: { title: '主页', el_icon: 'el-icon-location' },
        component: _import('dashboard/Dashboard')
      }
    ]
  }
]

export const optionalRoutes = [
  {
    path: '/demo',
    component: _import('Home'),
    meta: { title:'基本示例', el_icon:'el-icon-news'},
    children: [
      {
        path: '',
        component: _import('demo/Order'),
        meta: {title: '订单管理', icon: 'user'},
        menu: 'demo'
      },
      {
        path: 'pivot',
        component: _import('demo/Pivot'),
        meta: {title: '交叉表', icon: 'user'},
        menu: 'demo'
      }
    ]
  },
  {
    path: '/user',
    component: _import('Home'),
    meta: { title:'用户管理', el_icon:'el-icon-menu'},
    children: [
      {
        path: '',
        component: _import('user/User'),
        meta: {title: '用户列表', icon: 'user'},
        menu: 'user'
      },
      {
        path: 'role',
        component: _import('user/Role'),
        meta: {title: '权限管理', icon: 'password'},
        menu: 'role'
      }
    ]
  },
]

export default new Router({
  mode: 'history',
  scrollBehavior:() => ({y: 0}), //路由时y轴归位
  routes: constantRoutes
})
