import $http from '../libs/AxiosPlugin'

// 接口地址
const BASE_PATH = process.env.API_URL

export default {
  //用户登录
  login : params => $http(`${BASE_PATH}/login/auth`, params, 'POST'),
  //获取用户信息
  getUserInfo: params=> $http(`${BASE_PATH}/login/getInfo`,{}, 'POST'),
  //登出
  logout: params=> $http(`${BASE_PATH}/login/logout`,{}, 'POST'),

  //获取用户列表
  getUserList : params => $http(`${BASE_PATH}/user/list`, params),
  //获取全部角色
  getAllRoles: params => $http(`${BASE_PATH}/user/getAllRoles`),

  // 文件上传地址
  uploadFile : `${BASE_PATH}/file/upload`,
}
