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
              if (res.code === 1){
                console.log("登陆成功");
                if(res.data.token){
                  console.log("token已存在");
                  let token = res.data.token;
                  localStorage.setItem("token",token);
                }
                console.log(res);
                this.$router.push({path:"/"})
              }else if(res.code === -2) {
                console.log("用户未创建");
              }else if(res.code === -1){
                console.log("sadasdasdasdasdasd")
              }
              else{
                console.log("用户名或密码错误")
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
    height: 5vh;
  }

  .close {
    display: block;
    position: relative;
    left: 1vmin;
    top: 1vmin;
    width: 10vmin;
    height: 10vmin;
  }

  .the-way {
    width: 100%;
    height: 15vh;
    line-height: 15vh;
  }

  h3 {
    letter-spacing: 1vmin;
    padding-left: 4vmin;
    font-size: 1rem;
  }

  .message {
    width: 92%;
    height: 16vh;
    margin: 0 5vmin;
    font-size: 0.5rem;
  }

  .message div:first-child {
    width: 100%;
    height: 8vh;
    line-height: 8vh;
    border-bottom: 1px solid #d8d8d8;
  }

  .message div:nth-child(2) {
    width: 100%;
    height: 8vh;
    border-bottom: 1px solid #06af54;
  }

  .message div:last-child {
    width: 100%;
    height: 8vh;
    border-bottom: 1px solid #06af54;
  }

  input {
    display: inline-block;
    width: 74%;
    background: rgba(0, 0, 0, 0);
    border: none;
    font-size: 0.5rem;
    outline: none;
    font-family: 幼圆;
  }

  label {
    display: inline-block;
    width: 23%;
  }

  .method {
    width: 100%;
    height: 6vh;
    line-height: 6vh;
  }

  .method a {
    padding-left: 4vmin;
    font-size: 0.4rem;
    letter-spacing: 1px;
    color: #586b95;
    text-decoration: none;
  }

  .login-button {
    width: 100%;
    height: 4vh;
  }

  .login-button input {
    color: white;
    width: 90%;
    height: 4vh;
    margin: 0 5%;
    background: #07c160;
    font-size: 0.5rem;
    font-family: 幼圆;
    border-radius: 1vmin;
    letter-spacing: 1vmin;
  }

  .sms input {
    width: 40%;
  }

  .sms a {
    display: inline-block;
    width: 30%;
    height: 1rem;
    color: #06af54;
    text-align: center;
    line-height: 1rem;
    text-decoration: none;
    background: #e1e1e1;
    border-radius: 1vmin;
  }
</style>
