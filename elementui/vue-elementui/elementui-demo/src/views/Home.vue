<template>
  <div class="app-wrapper" :class="{hideSidebar:!sidebar.opened}">
    <sidebar class="sidebar-container"></sidebar>
    <div class="main-container">
      <navbar></navbar>
      <app-main></app-main>
    </div>
  </div>
</template>

<script>
    import api from '../api'
    import Navbar from './home/Navbar'
    import AppMain from './home/AppMain'
    import Sidebar from './home/Sidebar'

    export default {
      components: {
        Navbar,
        AppMain,
        Sidebar
      },
      computed: {
        sidebar() {
          return this.$store.state.common.sidebar
        }
      },
      mounted() {
        this.load();
      },
      methods:{
        load() {
          console.log('home')
          // api.loadData().then(function(response){
          //   console.log(response);
          // });
        }
      }
    }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
  @import "../styles/mixin.scss";
  .app-wrapper {
    @include clearfix;
    position: relative;
    height: 100%;
    width: 100%;
  }
</style>
