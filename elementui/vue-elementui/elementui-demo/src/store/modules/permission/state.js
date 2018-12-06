import {constantRoutes} from '@/router/index'

export default {
  routers: constantRoutes, //本用户所有的路由,包括了固定的路由和下面的addRouters
  addRouters: [] //本用户的角色赋予的新增的动态路由
}
