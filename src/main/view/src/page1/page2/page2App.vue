<template>
  <div id="app">
    <page-frame>page2</page-frame>
  </div>
</template>


<script>
  import Frame from '../../components/frame/frame'

  export default {
    name: "app",
    data() {
      return {
        msg: 'This is Page 2'
      }
    },
    components: {
      'page-frame': Frame
    }
  }
</script>

<style scoped>

</style>
