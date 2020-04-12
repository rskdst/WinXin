import Vue from 'vue'
import WeiChat from '@/components/weiChat'
import register from '@/components/register'
import login from '@/components/login'
import Router from 'vue-router'

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: '/',
      name: 'WeiChat',

      component: WeiChat
    },
    {
      path: '/register',
      name: 'register',
      component: register
    },
    {
      path: "/login",
      name: "login",
      component: login
    }
  ]
})
