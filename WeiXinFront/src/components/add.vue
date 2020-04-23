<template>
  <div style="width:3.5rem;height:6.3rem;border-radius:1vmin;" @click.stop="showAdd">
    <div class="snajiao">
        <div></div>
    </div>
    <div class="content">
      <a href="#">
        <img src="@/assets/logo.png">
        <p>发起群聊</p>
      </a>
      <a href="#">
        <img src="@/assets/logo.png">
        <p>添加朋友</p>
      </a>
      <a href="#">
        <img src="@/assets/logo.png">
        <p>扫一扫</p>
      </a>
      <a href="#">
        <img src="@/assets/logo.png">
        <p>收付款</p>
      </a>
      <a href="#x">
        <img src="@/assets/logo.png">
        <p>帮助与反馈</p>
      </a>
    </div>
  </div>
</template>

<script>
export default {
    name:"add",
    props:[
      "addFlag",
    ],
    data () {
    return {

    }
  },
  methods: {
    showAdd(){
      this.$emit("addFlag",true)
    }
  },
  components: {

  }
}
</script>

<style scoped>
.snajiao{
    width: 100%;
    height: 0.15rem;
}
.snajiao div{
    width: 0.3rem;
    height: 0.3rem;
    position: absolute;
    right: 0.4rem;
    background: #4c4c4c;
    -webkit-transform: rotate(45deg);

}
.content{
    width: 100%;
    height: 5.2rem;
    background: #4c4c4c;
    border-radius: 1vmin;
}
a {
  width: 100%;
  height: 1rem;
}
a img{
  width: 0.5rem;
  height: 0.5rem;
  float: left;
  margin: 0.25rem 0.25rem;
}
a p{
  width: 2.5rem;
  height: 1rem;
  float: left;
  font-size: 0.3rem;
  line-height: 1rem;
  color: #ffffff;
}
a:nth-child(2) p,a:nth-child(3) p,a:nth-child(4) p{
  border-bottom: 1px solid #5e5e5e;
  border-top: 1px solid #5e5e5e;
  
}
a:nth-child(1) p{
  border-bottom: 1px solid #5e5e5e;
}
a:nth-child(5) p{
  border-top: 1px solid #5e5e5e;
}
</style>
