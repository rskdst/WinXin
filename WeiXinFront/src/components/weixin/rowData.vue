<template>
  <div class="message"  @click="showTip">
    <div class="logo">
      <span class="tip" v-show="!remindflag">{{number}}</span>
      <span class="remind" v-show="remindflag"></span>
      <img class="photo" v-bind:src="address" alt="">
    </div>
    <div class="detail">
      <div class="prompt">
        <h5>{{name}}</h5>
        <span>{{content}}</span>
      </div>
      <ul>
        <li>{{time}}</li>
        <li>
          <img src="@/assets/weixin/不提醒.png" v-if="remindflag">
        </li>
      </ul>
    </div>
  </div>
</template>

<script>

  export default {

    name: "rowData",
    props:[
      "msg"
    ],
    data(){
      return{
        number:this.msg.num,
        name:this.msg.name,
        content:this.msg.content,
        address:this.msg.logo,
        time:this.msg.time,
        remindflag:this.msg.remindflag,
      }
    },
    methods: {
      showTip() {
        this.flag = !this.flag
      },
    },

  }

</script>

<style scoped>
  .message {
    width: 100%;
    height: 60px;
    background: #FFFFFF;
    position: relative;
    margin: 1px auto;
  }

  .logo {
    width: 60px;
    height: 60px;
    position: absolute;

  }
  .photo{
    width: 50px;
    height: 50px;
    border-radius: 5px 5px;
    margin-left: 5px;
    margin-top: 5px;

  }

  .tip{
    padding: 0;
    position: absolute;
    right: 0;
    width: 20px;
    height: 20px;
    background: red;
    color:white;
    line-height: 20px;
    text-align: center;
    border-radius: 50%;
  }
  .remind{
    padding: 0;
    position: absolute;
    right: 0;
    width: 10px;
    height: 10px;
    background: red;
    border-radius: 50%;
  }

  .detail {
    display: inline-block;
    width: 315px;
    height: 100%;
    border-bottom: 1px solid #F3F3F3;
    /*border-bottom: 1px solid red;*/
    position: absolute;
    right: 0;
  }

  .prompt {
    display: inline-block;
    width: 255px;
    height: 50px;
    margin: 5px 0;
    overflow: hidden;
  }

  h5 {
    display: inline-block;
    width: 100%;
    height: 25px;
    line-height: 25px;
    padding-left: 5px;

  }

  span {
    display: inline-block;
    width: 100%;
    height: 25px;
    font-size: 10px;
    line-height: 25px;
    padding-left: 5px;
    color: #B0B0B0;
  }

  ul {
    padding: 0;
    list-style: none;
    display: inline-block;
    width: 60px;
    height: 60px;
    position: absolute;
    right: 0;
    bottom: 0;
    color: #B0B0B0;
  }

  li:first-child, li:last-child {
    height: 30px;
    font-size: 10px;
    line-height: 30px;
    text-align: center;
  }

  li img {
    width: 15px;
    height: 15px;
  }
</style>
