<template>
  <div id="app">
    <page-frame><main-frame></main-frame></page-frame>
  </div>
</template>

<script>
  import Frame from './components/frame/frame'
  import Main from './components/form/homeMain'

  export default {
    name: 'app',
    data() {
      return {

      }
    },
    components: {
      'page-frame': Frame,
      'main-frame': Main
    }
  }
</script>

<style lang="scss">

</style>
