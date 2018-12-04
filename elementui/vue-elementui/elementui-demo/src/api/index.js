import Axios from '../libs/AxiosPlugin'

// 接口地址
const BASE_PATH = process.env.API_URL

export default {
  //用户登录
  login : params => { return Axios.post(`${BASE_PATH}/login/auth`, params).then(res => res.data); },
  //获取用户信息
  getUserInfo: params=> { return Axios.post(`${BASE_PATH}/login/getInfo`).then(res => res.data); },
  //登出
  logout: params=> { return Axios.post(`${BASE_PATH}/login/logout`).then(res => res.data); },

  //获取用户列表
  getUserList : params => { return Axios.get(`${BASE_PATH}/user/list`, params).then(res => res.data); },
  //加载首页数据
  loadData : params => { return Axios.get(`${BASE_PATH}/home/loadData`).then(res => res.data) },
  // 文件上传地址
  uploadFile : `${BASE_PATH}/file/upload`,
}
