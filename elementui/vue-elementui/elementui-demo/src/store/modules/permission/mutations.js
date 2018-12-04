import {constantRoutes} from '@/router/index'

export default {
  SET_ROUTERS: (state, routers) => {
    state.addRouters = routers
    state.routers = constantRoutes.concat(routers) //将固定路由和新增路由进行合并, 成为本用户最终的全部路由信息
  }
}
