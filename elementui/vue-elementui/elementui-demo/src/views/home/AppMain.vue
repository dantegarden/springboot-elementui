<template>
  <section class="app-main">
    <transition name="fade" mode="out-in">
      <router-view></router-view>
    </transition>
  </section>
</template>

<script type="text/ecmascript-6">
  export default {
    name: 'AppMain',
    props: [],
    data() {
      return {}
    },
    methods: {}
  }
</script>

<style>
</style>
