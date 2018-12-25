<template>
  <div>
    <el-row type="flex" justify="center" class="navi-menu">
      <navi-menu></navi-menu>
    </el-row>
    <el-row class="navi-info">
      <navi-info></navi-info>
    </el-row>
  </div>
</template>

<script type="text/ecmascript-6">
  import NaviInfo from './NaviInfo'
  import NaviMenu from './NaviMenu'

  export default {
    name: 'NaviBar',
    components: {NaviInfo, NaviMenu},
    data() {
      return {}
    },
    methods: {}
  }
</script>

<style lang="scss" scoped>
  .navi-info,.navi-menu {
    background: #4DB3B3;
  }
</style>
