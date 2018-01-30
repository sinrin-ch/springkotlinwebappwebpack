<template>
  <div id="app">
    <h1  class="msgBox">{{msg}}</h1>
  </div>
</template>

<script>
  export default {
    name: "app",
    data() {
      return {msg: 'This Page1'}
    }
  }
</script>

<style scoped>
  .msgBox{
    font-size: 3px;
  }
</style>
