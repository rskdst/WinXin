// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import axios from 'axios'
import qs from "qs";

axios.defaults.baseURL = "http://127.0.0.1:8000";

Vue.config.productionTip = false;

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: {App},
  template: '<App/>'
});

// aioxs添加请求拦截器
axios.interceptors.request.use(
  config => {
    // 设置统一的请求header
    if (localStorage.token) {
      config.headers.Authorization = localStorage.token; //授权（每次请求把sessionId带给后台）
    }
    return config;
  },
  error => {
    return Promise.reject(error);
  }
);

axios.interceptors.response.use(
  response => {
    return response;
  },
  error => {
    let code = error.response.data.data.code;
    if(code === "-1"){
      console.log("token认证失败，等重新登陆");
      router.push({path:"./login"});
    }
    return Promise.resolve(error.response);
  }
);


// axios get请求封装
export function get(url, params) {
  return new Promise((resolve, reject) => {
    axios.get(url, {
      params: params
    }).then(res => {
      resolve(res.data);
    }).catch(err => {
      reject(err.data)
    })
  });
}

// axios post请求封装
export function post(url, params) {
  return new Promise((resolve, reject) => {
    axios.post(url, qs.stringify(params))
      .then(res => {
        resolve(res.data);
      })
      .catch(err => {
        reject(err.data)
      })
  })
}
