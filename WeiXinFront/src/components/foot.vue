<template>
  <div class="content">

      <ul>
        <li v-for="(detail,i) in list" :key="detail.name" @click="changeIndex(i)">
          <a href="#">
            <img :src="index==i?detail.Active:detail.Img">
            <span :style="{color:index==i?detail.ActiveColor:detail.Color}">{{detail.name}}</span>
          </a>
        </li>
      </ul>

  </div>
</template>

<script>
  export default {
    name: "foot",
    data() {
      return {
        index: 0,
        list: [
          {
            Active: require("../assets/weixin/消息1.png"),
            Img: require("../assets/weixin/消息.png"),
            ActiveColor: "#1afa29",
            Color: "black",
            name: "微信"
          },
          {
            Active: require("../assets/weixin/通讯录1.png"),
            Img: require("../assets/weixin/通讯录.png"),
            ActiveColor: "#1afa29",
            Color: "black",
            name: "通讯录"
          },
          {
            Active: require("../assets/weixin/发现1.png"),
            Img: require("../assets/weixin/发现.png"),
            ActiveColor: "#1afa29",
            Color: "black",
            name: "发现"
          },
          {
            Active: require("../assets/weixin/我的1.png"),
            Img: require("../assets/weixin/我的.png"),
            ActiveColor: "#1afa29",
            Color: "black",
            name: "我"
          },
        ]

      }
    },
    methods: {
      changeIndex(index) {
        this.index = index;
        this.$emit("switch", this.index,this.list[this.index])
      }
    }
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
  }

  ul {
    margin: 0;
    padding: 0;
    width: 100%;
    font-size: 10px;
  }

  a {
    display: block;
    position: relative;
    text-decoration: none;
  }


  img {
    height: 20px;
    width: 20px;
    position: absolute;
    display: inline-block;
    left: 15px;
    top: 5px;
    /*margin: 0 auto;*/
    text-align: center;
  }

  li {
    margin: 0 auto;
    padding: 0;
    list-style: none;
    width: 50px;
    float: left;
    text-align: center;
  }

  ul li:first-child {
    margin-right: 10px;
  }

  ul li:nth-child(1) {
    margin-right: 55px;
  }

  ul li:nth-child(2) {
    margin-right: 55px;
  }

  ul li:last-child {
    float: right;
    margin-left: 10px;
  }

  span {
    position: relative;
    top: 10px;
  }

</style>
