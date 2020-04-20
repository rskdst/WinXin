<template>
    <div style="background: #ededed">
      <div class="w-header">
        <a href="#">
          <img src="@/assets/wo/照相机.png" alt="">
        </a>
        <!-- 个人信息-->
        <div class="w-message">
          <img src="static/images/touxiang_2.png" alt="">
          <h2>徳</h2>
          <div class="Qr-code">
            <span>微信号：x-aiteme</span>
            <a href="#"><img src="@/assets/wo/大于号.png" style="margin: 0;width: 0.4rem;height: 0.4rem"></a>
            <img class="code" src="@/assets/wo/二维码.png">
          </div>
        </div>
      </div>
      <!-- 支付-->
      <div class="w-pay">
        <a href="#" style="display: block">
          <img src="@/assets/wo/微信支付.png">
          <div>
            <h4 class="h4">支付</h4>
            <img src="@/assets/wo/大于号.png" class="jump">
          </div>
        </a>
      </div>
      <!-- 其他-->
      <div class="w-other">
        <a href="#" style="display: block">
          <img src="@/assets/wo/立方体.png">
          <div>
            <h4 class="h4">收藏</h4>
            <img src="@/assets/wo/大于号.png" class="jump">
          </div>
        </a>
        <a href="#" style="display: block">
          <img src="@/assets/wo/相册.png">
          <div>
            <h4 class="h4">相册</h4>
            <img src="@/assets/wo/大于号.png" class="jump">
          </div>
        </a>
        <a href="#" style="display: block">
          <img src="@/assets/wo/卡包.png">
          <div>
            <h4 class="h4">卡包</h4>
            <img src="@/assets/wo/大于号.png" class="jump">
          </div>
        </a>
        <a href="#" style="display: block">
          <img src="@/assets/wo/表情.png">
          <div style="border-bottom: none">
            <h4 class="h4">表情</h4>
            <img src="@/assets/wo/大于号.png" class="jump">
          </div>
        </a>
      </div>
      <!-- 设置-->
      <div class="w-setup">
        <a href="#" style="display: block">
          <img src="@/assets/wo/设置.png">
          <div style="border-bottom: none">
            <h4 class="h4">设置</h4>
            <img src="@/assets/wo/大于号.png" class="jump">
          </div>
        </a>
      </div>
    </div>
</template>

<script>
    export default {
        name: "wo"
    }
</script>

<style scoped>
  .w-header{
    width: 100%;
    height: 5rem;
    background: #ffffff;
  }
  .w-header a{
    float: right;
    margin-right: 0.2rem;
    margin-top: 0.3rem;
    width: 1rem;
    height: 1rem;
  }
  .w-message{
    float: left;
    width: 100%;
    height: 3.7rem;
  }
  .w-message img:first-child{
    float: left;
    width: 2rem;
    height: 2rem;
    margin-left: 0.5rem;
    border-radius: 0.1rem;
  }
  .w-message h2{
    float: left;
    margin-left: 0.4rem;
    width: 6rem;
    font-size: 1rem;
    height: 1rem;
  }
  .Qr-code{
    float: left;
    margin-left: 0.5rem;
    width: 6.9rem;
    height: 1rem;
    font-size: 0.4rem;
    line-height: 1.5rem;
    color: #838383;
  }
  .code{
    width: 0.4rem;
    height: 0.4rem;
    float: right;
    margin-right: 0.5rem;
    padding-top: 0.6rem;
  }
  .Qr-code a{
    width: 0.4rem;
    height: 0.4rem;
    margin-top: 0.6rem;
    text-decoration: none;
    float: right;
    line-height: 1.5rem;
  }
  .Qr-code a img{
    width: 0.4rem;
    height: 0.4rem;
  }
  .w-pay{
    width: 100%;
    height: 1.5rem;
    margin: 0.3rem 0;
    background: #ffffff;
  }
  .w-other{
    width: 100%;
    height: 6rem;
    background: #ffffff;
  }
  .w-setup{
    width: 100%;
    height: 1.5rem;
    margin-top: 0.3rem;
    background: #ffffff;
  }
  .w-pay img:first-child{
    float: left;
    width: 0.8rem;
    height: 0.8rem;
    margin: 0.35rem 0.4rem;
  }
  .w-pay div{
    float: left;
    width: 8rem;
    height: 1.5rem;
    line-height: 1.5rem;
    color: black;
  }
  .jump{
    width: 0.4rem;
    height: 0.4rem;
    margin: 0.55rem 0;
    float: right;
  }
  .h4{
    display: inline-block;
    width: 7rem;
    font-size: 0.5rem;
  }
  .w-other img:nth-child(odd){
    float: left;
    width: 0.8rem;
    height: 0.8rem;
    margin: 0.35rem 0.4rem;
  }
  .w-other div{
    float: left;
    width: 8rem;
    height: 1.5rem;
    line-height: 1.5rem;
    color: black;
    border-bottom: 1px solid #e6e6e6;
  }
  .w-other a{
    width: 100%;
    height: 1.5rem;
  }
  .w-setup div{
    float: left;
    width: 8rem;
    height: 1.5rem;
    line-height: 1.5rem;
    color: black;
  }
  .w-setup img:first-child{
    float: left;
    width: 0.8rem;
    height: 0.8rem;
    margin: 0.35rem 0.4rem;
  }
</style>
