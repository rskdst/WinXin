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
            <a href="#"><img src="@/assets/wo/大于号.png" style="margin: 0;width: 14px;height: 14px"></a>
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
    height: 150px;
    background: #ffffff;
  }
  .w-header a{
    float: right;
    margin-right: 20px;
    margin-top: 10px;
    width: 25px;
    height: 25px;
  }
  .w-message{
    float: left;
    margin-top: 20px;
    width: 100%;
    height: 75px;
  }
  .w-message img:first-child{
    float: left;
    width: 75px;
    height: 75px;
    margin-left: 20px;
    border-radius: 5px;
  }
  .w-message h2{
    float: left;
    margin-left: 10px;
    width: 245px;
    height: 1em;
  }
  .Qr-code{
    float: left;
    margin-left: 10px;
    margin-top: 30px;
    width: 245px;
    height: 20px;
    font-size: 14px;
    line-height: 20px;
    color: #838383;
  }
  .code{
    width: 14px;
    height: 14px;
    float: right;
    margin-top: 3px;
  }
  .Qr-code a{
    width: 14px;
    height: 14px;
    text-decoration: none;
    float: right;
    margin: 3px 0 3px 15px;
    line-height: 14px;
  }
  .w-pay{
    width: 100%;
    height: 50px;
    margin: 10px 0;
    background: #ffffff;
  }
  .w-other{
    width: 100%;
    height: 200px;
    background: #ffffff;
  }
  .w-setup{
    width: 100%;
    height: 50px;
    margin-top: 10px;
    background: #ffffff;
  }
  .w-pay img:first-child{
    float: left;
    width: 26px;
    height: 26px;
    margin: 12px 20px;
  }
  .w-pay div{
    float: left;
    width: 309px;
    height: 50px;
    line-height: 50px;
    color: black;
  }
  .jump{
    width: 14px;
    height: 14px;
    margin: 18px 25px 18px 0;
    float: right;
  }
  .h4{
    display: inline-block;
    width: 80%;
  }
  .w-other img:nth-child(odd){
    float: left;
    width: 26px;
    height: 26px;
    margin: 12px 20px;
  }
  .w-other div{
    float: left;
    width: 309px;
    height: 49px;
    line-height: 49px;
    color: black;
    border-bottom: 1px solid #e6e6e6;
  }
  .w-other a{
    width: 100%;
    height: 50px;
  }
  .w-setup div{
    float: left;
    width: 309px;
    height: 50px;
    line-height: 50px;
    color: black;
  }
  .w-setup img:first-child{
    float: left;
    width: 26px;
    height: 26px;
    margin: 12px 20px;
  }
</style>
