import $http from '../libs/AxiosPlugin'

// 接口地址
const BASE_PATH = process.env.API_URL

const $get = (url, params) => $http(BASE_PATH + url, params)
const $post = (url, params) => $http(BASE_PATH + url, params, 'POST')

export default {

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

  /**数据字典**/
  code: params => $post('/code/type', params),

  /**示例**/
  getOrderList: params => $post('/demo/listOrders', params),

  // 文件上传地址
  uploadFile : `${BASE_PATH}/file/upload`,
}
