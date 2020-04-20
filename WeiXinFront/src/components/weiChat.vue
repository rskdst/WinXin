<template>
  <div id="weiChat">
    <div id="w-header" v-show="headflag">
      <biaoti :setMsgNum="msgNum" :setName="headName" :numShow="numShow"></biaoti>
    </div>
    <div id="content">
      <transition mode="out-in">
        <weixin @getMsgNum="getMsgNum" v-if="flag==weixin"></weixin>
      </transition>
      <transition mode="out-in">
        <TongXunLu v-if="flag==tongxunlu"></TongXunLu>
      </transition>
      <transition mode="out-in">
        <wo v-if="flag==wo"></wo>
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
  import wo from "./wo/wo"

  export default {
    name: "weiChat",
    data() {
      return {
        msgNum: "",
        flag: 0,
        headflag: true,
        headName:"微信",
        weixin: 0,
        tongxunlu: 1,
        wo: 3,
        numShow:true,
      }
    },
    components: {
      biaoti,
      foot,
      weixin,
      TongXunLu,
      wo,
    },
    methods: {
      // 获取未读消息的数量
      getMsgNum(data) {
        let n = 0;
        data.forEach(function (d) {
          n += d.num
        });
        this.msgNum = n;
      },
      // 切换主界面
      Switch(index,data) {
        if (index === 3) {
          this.numShow = false;
          this.headflag = false
        } else if(index === 0) {
          this.numShow = true;
          this.headflag = true
        }else {
          this.numShow = false;
          this.headflag = true
        }
        this.headName = data.name;
        this.flag = index

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

  * {
    font-family: 幼圆;
  }

  #weiChat {
    width: 100%;
    /*background: red;*/
    position: relative;
  }

  #w-header {
    width: 100%;
    height: 1.5rem;
    background: #EEEEEE;
    position: relative;
  }

  #content {
    background: #FFFFFF;
  }

  #w-footer {
    width: 100%;
    height: 1.5rem;
    position: absolute;
    bottom: 0;
    background: #F7F7F7;
  }
</style>
