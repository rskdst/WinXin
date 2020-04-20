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
        <div class="nickname">
          <label for="nickname" style="border-bottom:1px solid #d8d8d8">昵称</label>
          <input type="text" placeholder="例如：陈晨" id="nickname" name="nickname" v-model="messageDict.nickname" style="border-bottom:1px solid #d8d8d8">
          <div class="logo">
            <input type="file" ref="file" name="avatar" accept="image/*" @change="add_avatar">
            <img id="touxiang" src="@/assets/weixin/上传头像.png" @click="upload">
          </div>
        </div>
        <div class="mid-message">
          <div class="address">
            <label>国家/地区</label>
            <select name="address" v-model="messageDict.address">
              <option :value="address.value" v-for="address in addressList" :key="address.value">
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
            <span>已阅读并同意<a href="#" style="text-decoration: none;color: #586b95">《软件许可及服务协议》</a></span>
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
            if (res.code === 1) {
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
    padding-left: 4%;
    font-size: 1rem;
  }

  .message {
    width: 92%;
    height: 32vh;
    margin: 0 4%;
    /* background: red; */
  }

  form {
    font-size: 0.5rem;
  }

  .nickname {
    width: 100%;
    height: 8vh;
    /*position: relative;*/
  }

  label {
    float: left;
    /*position: relative;*/
    width: 29%;
    line-height: 8vh;
  }

  input {
    float: left;
    /*position: relative;*/
    width: 51%;
    background: rgba(0, 0, 0, 0);
    border: none;
    font-size: 0.5rem;
    outline: none;
    font-family: 幼圆;
  }

  .logo {
    width: 20%;
    height: 8vh;
    float: right;
  }

  .logo input {
    display: none;
    width: 100%;
    height: 100%;
  }

  .mid-message {
    width: 100%;
    height: 16vh;
    border-bottom:1px solid #d8d8d8;
  }

  .address {
    width: 100%;
    height: 8vh;
    line-height: 8vh;
  }

  select {
    float: left;
    width: 71%;
    color: #06af54;
    height: 8vh;
    border: none;
    outline: none;
    -webkit-appearance: none;
    background: rgba(0, 0, 0, 0);
    font-size: 0.5rem;
    font-family: 幼圆;
  }

  .phone {
    width: 100%;
    height: 8vh;
    border-bottom: 1px solid #d8d8d8;
  }

  .password {
    width: 100%;
    height: 8vh;
    border-bottom: 1px solid #d8d8d8;
  }

  .foot-message {
    position: relative;
    width: 100%;
    height: 12vh;
  }

  .agree {
    position:relative;
    width: 100%;
    height: 6vh;
    line-height: 6vh;
    text-align: center;
    float: left;
  }

  .agree img {
    vertical-align:middle ;
    width: 0.6rem;
    height: 0.6rem;
  }

  .agree span{
    vertical-align:middle ;
    font-size: 0.3rem;
  }

  .register {
    width: 100%;
    height: 6vh;
  }

  .register input {
    width: 100%;
    height: 100%;
    font-size: 0.5rem;
    font-family: 幼圆;
    border-radius: 1vmin;
    letter-spacing: 2vmin;
  }
  option{
    width: 3rem;
    height: 2rem;
  }
</style>
