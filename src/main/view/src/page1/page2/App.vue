<template>
    <div id="app">
      <div class="msgBox">
        {{msg}}
      </div>

    </div>
</template>

<script>
    export default {
        name: "app",
      data(){
          return {
            msg: 'This is Page 2'
          }
      }
    }
</script>

<style scoped>
.msgBox{
  font-size: 32px;
}
</style>
