import axios from 'axios'
import qs from 'qs'
import { Message } from "element-ui";
import { getStore } from "./mUtils";

const $http = async function(url, data={}, method='GET') {
  let config = {
    url,
    method,
    timeout:15000,
    withCredentials: true,
    responseType:'json',
    headers: {
      'Content-Type':'application/json; charset=UTF-8', //get时是json, post时是multipart/formdata
    }
  }
  if(config.method.toUpperCase()==="POST"){
    config.data = data
  }else{
    config.params = data;
  }
  return axios.request(config)
}

//POST传参序列化(添加请求拦截器)
axios.interceptors.request.use(config => {
    // 在发送请求之前做某件事
    return config
},error =>{
    return Promise.reject(error)
})

//返回状态判断(添加响应拦截器)
axios.interceptors.response.use(res =>{
    //需要登陆
    if(res.data.code == 401 || res.data.code == 402 || res.data.code == 403) {
      window.location = "/login";
    }
    return res.data
}, error => {
    return Promise.reject(error)
})

$http.install = (Vue) => {
  Vue.prototype.$http = $http
}

export default $http
