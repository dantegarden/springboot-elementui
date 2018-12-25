<template>
  <el-container class="mainPage">
    <el-header height="120px">
      <navbar></navbar>
    </el-header>
    <el-container>
      <el-aside width="200px">Aside</el-aside>
      <el-main>
        <app-main></app-main>
      </el-main>
    </el-container>
  </el-container>
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
  .mainPage,
  .pageR{
    height: 100%;
  }
  .mainPage{

  }
  .mainPage:after{
    content: "";
    clear: both;
    display: block;
  }

</style>
