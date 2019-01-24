import $http from '../libs/AxiosPlugin'

// 接口地址
const BASE_PATH = process.env.API_URL

const $get = (url, params) => $http(BASE_PATH + url, params)
const $post = (url, params) => $http(BASE_PATH + url, params, 'POST')
const $download = (url, params) => $http(BASE_PATH + url, params, 'POST', 'blob')

export default {

  baseUrl : BASE_PATH,

  /**登录登出**/
  //用户登录
  login : params => $post('/login/auth', params),
  //获取用户信息
  getUserInfo: params => $post('/login/getInfo',{}),
  //登出
  logout: params=> $post('/login/logout',{}),

  /**用户和权限**/
  //获取用户列表
  getUserList : params => $get('/user/list', params),
  //获取全部角色
  getAllRoles: params => $get('/user/getAllRoles'),
  //创建用户
  addUser: params => $post('/user/addUser', params),
  //修改用户
  updateUser: params => $post('/user/updateUser', params),
  //删除用户
  deleteUser: params => $get('/user/deleteUser/' + params),
  //获得角色列表
  getRoleList: params =>  $get('/user/listRole', params),
  //获得全部权限
  getAllPermission: params => $get('/user/getAllPermission'),
  //创建角色
  addRole: params => $post('/user/addRole', params),
  //修改角色
  updateRole: params => $post('/user/updateRole', params),
  //删除角色
  deleteRole: params => $post('/user/deleteRole/' + params),
  //机构列表
  getOrgList: params => $get('/user/listOrganization', params),
  //创建机构
  addOrg: params => $post('/user/addOrganization', params),
  //修改机构
  updateOrg: params => $post('/user/updateOrganization', params),
  //删除机构
  deleteOrg: params => $post('/user/deleteOrganization/' + params),

  /**数据字典**/
  code: params => $post('/code/type', params),

  /**示例 正常表**/
  getOrderList: params => $post('/demo/listOrders', params),
  exportOrderList: params => $download('/demo/exportOrders', params),
  getCustomersByName: params => $get('/demo/customer/name', params),
  getGoodsByName: params => $get('/demo/goods/name', params),
  getOrderItemList: params => $get("/demo/listOrderItems/" + params),
  getOrder: params => $get("/demo/getOrder/" + params),
  addOrder: params => $post("/demo/addOrder", params),
  saveOrder: params => $post("/demo/saveOrder", params),
  saveOrderItem: params => $post("/demo/saveOrderItem", params),
  removeOrders: params => $post('/demo/removeOrders', params),
  removeOrderItem: params => $get('/demo/removeOrderItem/' + params),
  /**示例 交叉表**/
  getTableConfig: params => $get('/demo/pivot/config', params),
  getPivotData: params => $post('/demo/pivot/list', params),
  addCollection: params => $post('/demo/pivot/collect/add', params),
  delCollection: params => $get('/demo/pivot/collect/del/' + params),

  // 文件上传地址
  importOrders: `${BASE_PATH}/demo/upload`
}
