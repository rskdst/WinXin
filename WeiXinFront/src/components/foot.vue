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
    line-height: 90%;
  }

  ul {
    margin: 0;
    padding: 0;
    width: 100%;
    font-size: 0.3rem;
  }

  a {
    display: block;
    position: relative;
    text-decoration: none;
  }


  img {
    height: 0.6rem;
    width: 0.6rem;
    position: absolute;
    display: inline-block;
    left: 0.45rem;
    top: 0.2rem;
    /*margin: 0 auto;*/
    text-align: center;
  }

  li {
    margin: 0 auto;
    padding: 0;
    list-style: none;
    width: 1.5rem;
    float: left;
    text-align: center;
  }

  ul li:first-child {
    margin-left: 0.1rem;
    margin-right: 1.2rem;
  }

  ul li:nth-child(1) {
    margin-right: 1.2rem;
  }

  ul li:nth-child(2) {
    margin-right: 1.2rem;
  }

  ul li:last-child {
    float: right;
  }

  span {
    position: relative;
    top: 0.9rem;
  }

</style>
