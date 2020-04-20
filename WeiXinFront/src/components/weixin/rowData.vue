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
    height: 1.5rem;
    background: #FFFFFF;
    position: relative;
    margin: 1px auto;
  }

  .logo {
    width: 1.5rem;
    height: 1.5rem;
    position: absolute;

  }
  .photo{
    width: 1.3rem;
    height: 1.3rem;
    border-radius: 0.2rem;
    margin-left: 0.1rem;
    margin-top: 0.1rem;

  }

  .tip{
    padding: 0;
    position: absolute;
    right: 0;
    width: 0.4rem;
    height: 0.4rem;
    background: red;
    color:white;
    font-size: 0.3rem;
    line-height: 0.4rem;
    text-align: center;
    border-radius: 50%;
  }
  .remind{
    padding: 0;
    position: absolute;
    right: 0;
    width: 0.3rem;
    height: 0.3rem;
    background: red;
    border-radius: 50%;
  }

  .detail {
    display: inline-block;
    width: 8.5rem;
    height: 100%;
    border-bottom: 1px solid #dedede;
    position: absolute;
    right: 0;
  }

  .prompt {
    display: inline-block;
    width: 7rem;
    height: 1.1rem;
    margin: 0.2rem 0 0.2rem 0.3rem;
    overflow: hidden;
  }

  h5 {
    display: inline-block;
    width: 100%;
    height: 0.6rem;
    font-size: 0.4rem;
    line-height: 0.6rem;

  }

  span {
    display: inline-block;
    width: 100%;
    height: 0.5rem;
    font-size: 0.3rem;
    line-height: 0.5rem;
    color: #B0B0B0;
  }

  ul {
    padding: 0;
    list-style: none;
    display: inline-block;
    width: 1rem;
    height: 1.5rem;
    position: absolute;
    right: 0;
    bottom: 0;
    color: #B0B0B0;
  }

  li:first-child, li:last-child {
    height: 0.75rem;
    font-size: 0.3rem;
    line-height: 0.75rem;
    text-align: center;
  }

  li img {
    width: 0.3rem;
    height: 0.3rem;
  }
</style>
