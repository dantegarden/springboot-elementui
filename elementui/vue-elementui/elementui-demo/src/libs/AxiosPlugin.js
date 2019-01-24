import axios from 'axios'
import qs from 'qs'
import { Message } from "element-ui";
import { getStore } from "./mUtils";

const $http = async function(url, data={}, method='GET', reponseType='json') {
  let config = {
    url,
    method,
    timeout:15000,
    withCredentials: true,
    responseType: reponseType,
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
    if(res.config.responseType==="blob"){
      axiosDownload(res)
    }
    return res.data
}, error => {
    return Promise.reject(error)
})

const axiosDownload = function(res){
  if (!res.data) {
    Message.error("下载失败，服务器或网络异常")
    return
  }
  const content = res.data
  const blob = new Blob([content])
  let fileName = '下载文件.xlsx'
  const contentDisposition = res.headers['content-disposition'];
  if (contentDisposition) {
    fileName = window.decodeURI(res.headers['content-disposition'].split('=')[1]);
  }
  if ('download' in document.createElement('a')) { // 非IE下载
    const elink = document.createElement('a')
    elink.download = fileName
    elink.style.display = 'none'
    elink.href = URL.createObjectURL(blob)
    document.body.appendChild(elink)
    elink.click()
    URL.revokeObjectURL(elink.href) // 释放URL 对象
    document.body.removeChild(elink)
  } else { // IE10+下载
    navigator.msSaveBlob(blob, fileName)
  }
}

$http.install = (Vue) => {
  Vue.prototype.$http = $http
}

export default $http
