<template>
  <section class="app-main">
    <transition :name="fade" mode="out-in">
      <keep-alive>     <!--使用keep-alive会将页面缓存-->
        <router-view v-if="$route.meta.cache"></router-view>
      </keep-alive>
    </transition>
    <transition :name="fade" mode="out-in">
      <router-view v-if="!$route.meta.cache"></router-view>
    </transition>
    <!--<transition name="fade" mode="out-in">-->
      <!--<router-view ></router-view>-->
    <!--</transition>-->
  </section>
</template>

<script type="text/ecmascript-6">
  export default {
    name: 'AppMain',
    props: [],
    data() {
      return {
        fade: 'fade'
      }
    },
    methods: {}
  }
</script>

<style scoped>
  .fade-enter-active{
    transition: all 0.25s;
  }
  .fade-leave-active{
    transition: all 0.25s;
  }
  .fade-enter, .fade-leave-active{
    opacity: 0;
  }
</style>
