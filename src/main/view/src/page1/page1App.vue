<template>
  <div id="app">
    <page-frame>666</page-frame>
  </div>
</template>

<script>

  import Frame from '../components/frame/frame'


  export default {
    name: 'app',
    data() {
      return {

      }
    },
    components: {
      'page-frame': Frame
    }
  }
</script>

<style scoped>
  .msgBox{
    font-size: 3px;
  }
</style>
