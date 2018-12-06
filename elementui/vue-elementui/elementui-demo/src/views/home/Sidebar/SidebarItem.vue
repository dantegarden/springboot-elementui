<template>
  <div class="menu-wrapper">
    <template v-for="item in routes" v-if="item.meta&&!item.meta.hidden">

      <router-link v-if="!item.children" :to="item.path">
        <el-menu-item  :index="item.path">
          <template slot="title">
            <svg-icon v-if="item.meta.icon" :icon-class="item.meta.icon"></svg-icon>
            <i v-else-if="item.meta.el_icon" :class="item.meta.el_icon"></i>
            <span v-if="item.meta.title">{{item.meta.title}}</span>
          </template>
        </el-menu-item>
      </router-link>

      <router-link v-else-if="item.children.length===1 && !item.children[0].hidden && item.children[0].path===''" :to="item.path">
        <el-menu-item :index="item.path">
          <template slot="title">
            <svg-icon v-if="item.children[0].meta && item.children[0].meta.icon" :icon-class="item.children[0].meta.icon"></svg-icon>
            <i v-else-if="item.children[0].meta && item.children[0].meta.el_icon" :class="item.children[0].meta.el_icon"></i>
            <span v-if="item.children[0].meta && item.children[0].meta.title">{{item.children[0].meta.title}}</span>
          </template>
        </el-menu-item>
      </router-link>


      <!--<router-link v-if="item.children.length===1 && !item.children[0].children" :to="item.path+'/'+item.children[0].path" :key="item.children[0].name">-->
        <!--<el-menu-item :index="item.path+'/'+item.children[0].path" class='submenu-title-noDropdown'>-->
          <!--<svg-icon v-if="item.children[0].meta&&item.children[0].meta.icon" :icon-class="item.children[0].meta.icon"></svg-icon>-->
          <!--<span v-if="item.children[0].meta&&item.children[0].meta.title">{{item.children[0].meta.title}}</span>-->
        <!--</el-menu-item>-->
      <!--</router-link>-->

      <el-submenu v-else :index="item.path">
        <!--一级菜单-->
        <template slot="title">
          <svg-icon v-if="item.meta&&item.meta.icon" :icon-class="item.meta.icon"></svg-icon>
          <i v-else-if="item.meta&&item.meta.el_icon" :class="item.meta.el_icon"></i>
          <span v-if="item.meta&&item.meta.title">{{item.meta.title}}</span>
        </template>
        <!--二级菜单-->
        <template v-for="child in item.children" v-if="child.meta && !child.meta.hidden">
          <sidebar-item v-if="child.children&&child.children.length>0" :routes="[child]" :key="child.path" class="nest-menu" ></sidebar-item>

          <router-link v-else :to="item.path+'/'+child.path" :key="item.path+'/'+child.path">
            <el-menu-item :index="item.path+'/'+child.path">
              <svg-icon v-if="child.meta&&child.meta.icon" :icon-class="child.meta.icon"></svg-icon>
              <i v-else-if="child.meta&&child.meta.el_icon" :class="child.meta.el_icon"></i>
              <span v-if="child.meta&&child.meta.title">{{child.meta.title}}</span>
            </el-menu-item>
          </router-link>
        </template>
      </el-submenu>

    </template>
  </div>
</template>

<script>
export default {
  name: 'SidebarItem',
  props: {
    routes: {
      type: Array
    }
  }
}
</script>
