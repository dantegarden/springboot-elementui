import api from '@/api'
import {setStore, removeStore} from "../../../libs/mUtils";
import store from '@/store'
import router from '@/router'

export default {
  GetInfo: async ({commit, state}) => {
    let res = await api.getUserInfo()
    if(res.status){
      let userPermission = res.data;
      commit('SET_USER', userPermission);
      setStore("hasLogin", 1)
      store.dispatch('permission/GenerateRoutes', userPermission).then(() => {
        //生成该用户的新路由json操作完毕之后,调用vue-router的动态新增路由方法,将新路由添加
        router.addRoutes(store.getters.addRouters)
      })
    }
  },
  LogOut: async ({commit}) => {
    let res = await api.logout()
    if(res.status){
      commit('RESET_USER')
      removeStore('hasLogin')
    }
  },
  //前端登出
  FedLogOut: async ({commit}) => {
      commit('RESET_USER')
      removeStore('hasLogin')
  }
}
