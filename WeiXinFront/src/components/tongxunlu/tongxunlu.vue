<template>
  <div>
    <div class="t-header">
      <single></single>
      <single></single>
    </div>
  </div>
</template>

<script>
  import {get,post} from '../../main'
  import single from './single'
  export default {
    name: "TongXunLu",
    data(){
      return{
        msg:"",
      }
    },
    components: {
      single
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
