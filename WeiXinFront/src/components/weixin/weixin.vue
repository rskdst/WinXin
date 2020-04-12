<template>
  <div>
    <row-data v-for="(msg,i) in msgList" :key="i" :msg="msg"></row-data>
  </div>

</template>

<script>
  import rowData from "./rowData"

  export default {
    name: "weixin",
    components: {
      rowData
    },
    data(){
      return{
        msgList:[
          {logo:"../../static/images/touxiang_2.png",num:1,name:"常威",content:"我是你爸爸",time:"今天",remindflag: false},
          {logo:"../../static/images/touxiang_1.png",num:2,name:"刘敬",content:"我是你爸爸",time:"19:25",remindflag: true},
          {logo:"../../static/images/touxiang_2.png",num:3,name:"常威",content:"你是我爸爸",time:"昨天",remindflag: true},
          {logo:"../../static/images/touxiang_1.png",num:4,name:"常威",content:"你是我爸爸",time:"前天",remindflag: false}
       ],
      }
    },
    methods:{

    },
    watch:{
      msgList:{
        handler(val, oldVal){
          this.$emit("getMsgNum",val)
        },
        deep:true //true 深度监听
      }
    }

  }
</script>

<style scoped>

</style>
