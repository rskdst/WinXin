<template>
  <div style="font-family: 幼圆;">
    <div class="head">
      <a href="#/login" class="close">
        <img src="@//assets/weixin/关闭.png">
      </a>
    </div>
    <div class="the-way">
      <h3>手机号注册</h3>
    </div>
    <div class="message">
      <form @submit.prevent="submit">
        <div class="head-message">
          <div class="nickname">
            <label for="nickname">昵称</label>
            <input type="text" placeholder="例如：陈晨" id="nickname" name="nickname" v-model="messageDict.nickname">
          </div>
          <div class="logo">
            <input type="file" ref="file" name="avatar" accept="image/*" @change="add_avatar">
            <img id="touxiang" src="@/assets/weixin/上传头像.png" @click="upload">
          </div>
        </div>
        <div class="mid-message">
          <div class="address">
            <label>国家/地区</label>
            <select name="address" v-model="messageDict.address">
              <option :value="address.value" v-for="address in addressList">
                {{address.name}}
              </option>
            </select>
          </div>
          <div class="phone">
            <label for="phone">手机号</label>
            <input type="text" placeholder="请填写手机号" id="phone" name="phone" v-model="messageDict.phone">
          </div>
        </div>
        <div class="password">
          <label for="password">密码</label>
          <input type="password" placeholder="填写密码" id="password" name="password" v-model="messageDict.password">
        </div>
        <div class="foot-message">
          <div class="agree">
            <img :src="agree?agreeImg.agreePicture:agreeImg.Picture" @click="changeAgree">
            <p>已阅读并同意<a href="#" style="text-decoration: none;color: #586b95">《软件许可及服务协议》</a></p>
          </div>
          <div class="register">
            <input type="submit" value="注册"
                   :disabled="messageDict.nickname!==''&&messageDict.phone!==''&&messageDict.password!==''?disabled[0]:disabled[1]"
                   :style="messageDict.nickname!==''&&messageDict.phone!==''&&messageDict.password!==''?registerStyle.click:registerStyle.noclick">
          </div>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
  import {get, post} from "../main"

  export default {
    name: "register",
    data() {
      return {
        agree: false,
        agreeImg: {agreePicture: require("@/assets/weixin/圆1.png"), Picture: require("@/assets/weixin/圆.png")},
        registerStyle: {click: "color:white;background:#07c160", noclick: "color: #c2c2c2;background: #f2f2f2;"},
        disabled: [false, true],
        addressList: [
          {value: 1, name: "中国大陆（+86）"},
          {value: 2, name: "美国大陆（+86）"}
        ],
        messageDict: {
          nickname: "",
          address: "",
          phone: "",
          password: "",
          isAgree: false,
          avatar: "",
        },
      }
    },
    created() {
      this.messageDict.address = this.addressList[0].value
    },
    methods: {
      upload() {
        this.$refs.file.click();
      },
      add_avatar() {
        var that = this;
        var file = this.$refs.file.files[0];
        var reader = new FileReader();
        reader.readAsDataURL(file);
        reader.onload = function () {
          //改变img的路径
          that.messageDict.avatar = this.result;
          document.querySelector("#touxiang").src = this.result;
        };
      },
      submit() {
        if (!this.messageDict.isAgree) {
          console.log("未同意")
        } else if (this.messageDict.nickname.length < 2 || this.messageDict.nickname.length > 8) {
          alert("昵称不能小于两位，或大于八位！")
        } else if (!(/^1[3456789]\d{9}$/.test(this.messageDict.phone))) {
          alert("手机号码格式不正确！")
        } else if (!/^(?![^a-zA-Z]+$)(?!\D+$).{6,18}$/.test(this.messageDict.password)) {
          alert("密码必须为6-18字母、数字！")
        } else {
          // let imgFile =
          post("api/register/", {
            nickname: this.messageDict.nickname,
            address: this.messageDict.address,
            password: this.messageDict.password,
            phone: this.messageDict.phone,
            avatar: this.messageDict.avatar,
          },).then(res => {
            if (res.status === 1) {
              console.log("用户创建成功！");
              this.$router.push({path: "/login"})
            } else {
              console.log("用户已存在！");
            }
          }).catch(err => {
            console.log(err)
          })
        }
      },
      changeAgree() {
        this.agree = !this.agree;
        this.messageDict.isAgree = !this.messageDict.isAgree
      },
    },


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
    height: 200px;
    /*background: red;*/
  }

  form {
    font-size: 16px;
  }

  .head-message {
    width: 100%;
    height: 50px;
  }

  .nickname {
    width: 290px;
    float: left;
    /*position: relative;*/
    display: inline-block;
    line-height: 50px;
    border-bottom: 1px solid #d8d8d8;
  }

  label {
    display: inline-block;
    /*position: relative;*/
    padding-left: 20px;
    width: 80px;
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

  .logo {
    width: 50px;
    height: 50px;
    float: right;
    margin-right: 20px;
    display: inline-block;
  }

  .logo input {
    display: none;
    width: 50px;
    height: 50px;
  }

  .mid-message {
    width: 100%;
    height: 100px;
    margin-top: 1px;
  }

  .address {
    width: 100%;
    height: 50px;
    line-height: 50px;
  }

  select {
    display: inline-block;
    width: 120px;
    color: #06af54;
    height: 49px;
    border: none;
    outline: none;
    -webkit-appearance: none;
    background: rgba(0, 0, 0, 0);
    font-size: 16px;
    font-family: 幼圆;
  }

  .phone {
    width: 100%;
    height: 50px;
    border-bottom: 1px solid #d8d8d8;
  }

  .password {
    width: 100%;
    height: 50px;
    margin-top: 1px;
    border-bottom: 1px solid #d8d8d8;
  }

  .foot-message {
    width: 100%;
    height: 100px;
    margin-top: 1px;
  }

  .agree {
    width: 100%;
    height: 50px;
    position: relative;
  }

  .agree img {
    width: 20px;
    height: 20px;
    border-radius: 50%;
    display: inline-block;
    position: relative;
    top: 25px;
    left: 60px;

  }

  .agree p {
    display: inline-block;
    width: 250px;
    height: 30px;
    line-height: 30px;
    font-size: 12px;
    position: relative;
    top: 20px;
    left: 60px;

  }

  .register {
    width: 100%;
    height: 50px;
  }

  .register input {
    width: 355px;
    height: 50px;
    margin: 0 10px;
    font-size: 16px;
    font-family: 幼圆;
    border-radius: 5px;
    letter-spacing: 3px;
  }
</style>
