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
  height: 1.5rem;
}
img {
  width: 1.3rem;
  height: 1.3rem;
  float: left;
  margin: 0.1rem 0.1rem;
  border-radius: 0.2rem;
}
p {
  margin-left: 1.6rem;
  font-size: 0.5rem;
  line-height: 1.5rem;
  border-bottom: 1px solid #dedede;
}
</style>
