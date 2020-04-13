<template>
  <div>
    <img :src="photoAddress" />
    <p>{{ name }}</p>
  </div>
</template>

<script>
export default {
  name: "single",
  data() {
    return {
      photoAddress: require("@/assets/logo.png"),
      name: "内蒙古工业大学"
    };
  },
  methods: {},
  components: {}
};
</script>

<style scoped>
div {
  width: 100%;
  height: 50px;
}
img {
  width: 40px;
  height: 40px;
  float: left;
  margin: 5px 10px;
  border-radius: 5px;
}
p {
  float: left;
  width: 315px;
  height: 49px;
  line-height: 49px;
  border-bottom: 1px solid #e6e6e6;
}
</style>
