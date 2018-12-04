import {optionalRoutes} from '@/router/index'

const hasPermission = (menus, route) => {
  if (route.menu) {
    return menus.indexOf(route.menu) > -1;
  } else {
    return true
  }
}

const filterAsyncRouter = (optionalRoutes, menus) => {
  const accessedRouters = optionalRoutes.filter(route => {
    if (hasPermission(menus, route)) {
      if (route.children && route.children.length) {
        //如果这个路由下面还有下一级的话,就递归调用
        route.children = filterAsyncRouter(route.children, menus)
        //如果过滤一圈后,没有子元素了,这个父级菜单就也不显示了
        return (route.children && route.children.length)
      }
      return true
    }
    return false
  })
  return accessedRouters
}

export default {
  GenerateRoutes: async ({commit}, userPermission) => {
      //roles是后台传过来的角色数组,比如['管理员','文章']
      const role = userPermission.roleName;
      const menus = userPermission.menuList;
      //声明 该角色可用的路由
      let accessedRouters
      if (role === '管理员') {
        //如果角色里包含'管理员',那么所有的路由都可以用
        //其实管理员也拥有全部菜单,这里主要是利用角色判断,节省加载时间
        accessedRouters = optionalRoutes
      } else {
        //否则需要通过以下方法来筛选出本角色可用的路由
        accessedRouters = filterAsyncRouter(optionalRoutes, menus)
      }
      //执行设置路由的方法
      commit('SET_ROUTERS', accessedRouters)
    }
}
