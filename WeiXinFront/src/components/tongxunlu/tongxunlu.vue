<template>
  <h1>{{msg}}</h1>
</template>

<script>
  import {get,post} from '../../main'
  export default {
    name: "TongXunLu",
    data(){
      return{
        msg:"",
      }
    },
    created() {
      post("api/tongxunlu/",{}).then(res=>{
        this.msg = res.data;

      }).catch(err=>{
          console.log(err);
      })
    }

  }
</script>

<style scoped>

</style>
