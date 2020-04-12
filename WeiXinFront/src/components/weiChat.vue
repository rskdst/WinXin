<template>
  <div id="weiChat">
    <div id="w-header">
      <biaoti :setMsgNum="msgNum"></biaoti>
    </div>
    <div id="content">
      <transition mode="out-in">
        <weixin @getMsgNum="getMsgNum" v-if="flag==weixin"></weixin>
      </transition>
      <transition mode="out-in">
        <TongXunLu v-if="flag==tongxunlu"></TongXunLu>
      </transition>
    </div>

    <div id="w-footer">
      <foot @switch="Switch"></foot>
    </div>
  </div>
</template>

<script>
  import biaoti from "./head"
  import foot from "./foot"
  import weixin from "./weixin/weixin"
  import TongXunLu from "./tongxunlu/tongxunlu"

  export default {
    name: "weiChat",
    data() {
      return {
        msgNum: "",
        flag: 0,
        weixin: 0,
        tongxunlu: 1,


      }
    },
    components: {
      biaoti,
      foot,
      weixin,
      TongXunLu,
    },
    methods: {
      getMsgNum(data) {
        let n = 0;
        data.forEach(function (d) {
          n += d.num
        });
        this.msgNum = n;
      },
      Switch(data) {
        this.flag = data

      }
    },
    mounted() {
      let n = 0;
      this.$children[1].msgList.forEach(function (data) {
        n += data.num
      });
      this.msgNum = n;

    }
  }


</script>

<style scoped>
  .v-enter,
  .v-leave-to {
    opacity: 0;
    transform: translateX(150px);
  }

  .v-enter-active,
  .v-leave-active {
    transition: all 0.5s ease;
  }
  *{
    font-family: 幼圆;
  }
  #weiChat {
    width: 100%;
    height: 812px;
    /*background: red;*/
    position: relative;
  }

  #w-header {
    width: 100%;
    height: 50px;
    background: #EEEEEE;
    position: relative;
  }

  #content {
    background: #FFFFFF;
  }

  #w-footer {
    width: 100%;
    height: 50px;
    position: absolute;
    bottom: 0;
    background: #F7F7F7;
  }
</style>
