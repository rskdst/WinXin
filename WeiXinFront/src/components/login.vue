<template>
  <div style="font-family: 幼圆;">
    <div class="head">
      <a href="#" class="close">
        <img src="@//assets/weixin/关闭.png">
      </a>
    </div>
    <div class="the-way">
      <h3>手机号登录</h3>
    </div>
    <div class="login">
      <div class="message">
        <div class="phone">
          <label for="phone">手机号</label>
          <input type="text" placeholder="请填写手机号" id="phone" name="phone" v-model="phone">
        </div>
        <div class="password" v-show="type">
          <label for="password">密码</label>
          <input type="password" placeholder="请填写微信密码" id="password" name="password" v-model="password">
        </div>
        <div class="sms" v-show="!type">
          <label for="password">验证码</label>
          <input type="text" placeholder="请填写验证码" id="sms" name="sms" v-model="sms">
          <a href="#">获取验证码</a>
        </div>
      </div>
      <div class="method">
        <a v-show="type" href="#" @click="switchType">用短信验证码登录</a>
        <a v-show="!type" @click="switchType">用密码登录</a>
      </div>
      <div class="login-button">
        <input type="submit" value="登录" @click="submit">
      </div>
    </div>
  </div>
</template>

<script>
  import {post} from '../main'

  export default {
    name: "login",
    data() {
      return {
        type: true,
        phone: "",
        sms: "",
        password: "",
      }
    },
    methods: {
      switchType() {
        this.type = !this.type
      },
      submit() {
        if (this.type) {
          // 账号密码登录
          if (!(/^1[3456789]\d{9}$/.test(this.phone))) {
            alert("手机号码格式不正确！")
          } else if (this.password.length === 0) {
            alert("请输入密码！")
          } else {
            post("api/login/", {
              phone: this.phone,
              password: this.password
            }).then(res => {
              if (res.status === 0){
                console.log("登陆成功");
                let token = res.data.token;
                localStorage.setItem("token",token);
                console.log(res);
                this.$router.push({path:"/"})
              }else {
                console.log("登陆失败");
              }
            })
          }

        } else {
          // 短信验证码登录
        }
      }

    }
  }
</script>

<style scoped>
  .head {
    height: 50px;
  }

  .close {
    display: block;
    position: relative;
    left: 10px;
    top: 10px;
    width: 32px;
    height: 32px;
  }

  .the-way {
    width: 100%;
    height: 100px;
    line-height: 100px;
  }

  h3 {
    letter-spacing: 5px;
    padding-left: 20px;
  }

  .message {
    width: 100%;
    height: 100px;
    margin-top: 1px;
  }

  .message div:first-child {
    width: 100%;
    height: 50px;
    margin-top: 1px;
    border-bottom: 1px solid #d8d8d8;
  }

  .message div:nth-child(2) {
    width: 100%;
    height: 50px;
    margin-top: 1px;
    border-bottom: 1px solid #06af54;
  }

  .message div:last-child {
    width: 100%;
    height: 50px;
    margin-top: 1px;
    border-bottom: 1px solid #06af54;
  }

  input {
    display: inline-block;
    /*position: relative;*/
    width: 180px;
    background: rgba(0, 0, 0, 0);
    border: none;
    font-size: 16px;
    outline: none;
    font-family: 幼圆;
  }

  label {
    display: inline-block;
    /*position: relative;*/
    padding-left: 20px;
    width: 80px;
  }

  .method {
    width: 100%;
    height: 80px;
    line-height: 80px;
    margin-top: 1px;
  }

  .method a {
    padding-left: 20px;
    font-size: 14px;
    letter-spacing: 1px;
    color: #586b95;
    text-decoration: none;
  }

  .login-button {
    width: 100%;
    height: 50px;
  }

  .login-button input {
    color: white;
    width: 355px;
    height: 50px;
    margin: 0 10px;
    background: #07c160;
    font-size: 16px;
    font-family: 幼圆;
    border-radius: 5px;
    letter-spacing: 3px;
  }

  .sms input {
    width: 140px;
  }

  .sms a {
    display: inline-block;
    width: 100px;
    height: 30px;
    color: #06af54;
    text-align: center;
    line-height: 30px;
    text-decoration: none;
    background: #e1e1e1;
    border-radius: 5px;
  }
</style>
