<template>
  <div id="app">
    <el-container style="height: auto; border: 1px solid #eee">
      <!--<el-header>Header</el-header>-->
      <el-container>

        <el-aside width="201px">
          <left-menu></left-menu>
        </el-aside>
        <el-main>
          <slot></slot>
        </el-main>

      </el-container>
    </el-container>
  </div>
</template>

<script>
  import LeftMenu from '../leftMenu/leftMenu'
  export default {
    name: "frame",
    data() {
      return {
        msg: 'Welcome to Your Vue.js App',
        date: ''
      }
    },
    components: {
      'left-menu': LeftMenu
    }
  }
</script>

<style scoped>

</style>
