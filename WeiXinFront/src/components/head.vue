<template>
  <div class="content">
    <h4>{{setName}}</h4>
    <span v-show="numShow">({{setMsgNum}})</span>
    <ul>
      <li @click.stop="add"><img src="@/assets/weixin/添加.png"></li>
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
      'numShow',
    ],
    data() {
      return {
      }
    },
    methods: {
      add(){
        this.$emit("addFlag", 1)
      }
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
    font-size: 0.5rem;
    line-height: 1.5rem;
    /*background: aliceblue;*/
  }

  h4 {
    display: inline;
    font-size: 0.5rem;
    margin-left: 0.2rem;
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
    width: 1rem;
    margin-right: 0.2rem;
    float: right;
    text-align: right;

  }

  li img {
    width: 0.6rem;
    height: 0.6rem;
    /*margin-right: 12.5px;*/
    margin-top: 0.4rem;
  }


</style>
