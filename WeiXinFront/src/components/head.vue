<template>
  <div class="content">
    <h4>{{setName}}</h4>
    <span v-show="numShow">({{setMsgNum}})</span>
    <ul>
      <li><img src="@/assets/weixin/添加.png"></li>
      <li><img src="@/assets/weixin/搜索.png"></li>
    </ul>
  </div>
</template>

<script>
  export default {
    name: "biaoti",
    props: [
      'setMsgNum',
      'setName',
      'numShow'
    ],
    data() {
      return {
      }
    },
    methods: {

    },
  }
</script>

<style scoped>
  .content {
    width: 95%;
    height: 90%;
    position: relative;
    top: 3%;
    margin: 0 auto;
    line-height: 45px;
    /*background: aliceblue;*/
  }

  h4 {
    display: inline;
    margin-left: 10px;
  }

  a {
    display: inline;
  }

  ul {
    display: inline;
    list-style: none;
    margin-right: 0;
  }

  ul li {
    width: 50px;
    margin-right: 10px;
    float: right;
    text-align: right;

  }

  li img {
    width: 25px;
    height: 25px;
    /*margin-right: 12.5px;*/
    margin-top: 10px;
  }


</style>
