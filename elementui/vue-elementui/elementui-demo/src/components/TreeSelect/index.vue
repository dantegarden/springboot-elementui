<template>
  <div class="el-tree-select">
    <el-input
      :placeholder="placeholder"
      v-model="selectedLabel"
      icon="caret-bottom"
      @click.native="isShowSelect = !isShowSelect">
    </el-input>
    <transition name="fade">
      <el-tree ref="tree" v-show="isShowSelect"
               empty-text="暂无数据"
               node-key="id"
               :data="treeData"
               :props="defaultProps"
               @node-click="handleNodeClick"
               :filter-node-method="filterNode"
               accordion
               class="objectTree">
      </el-tree>
    </transition>
  </div>
</template>

<script type="text/ecmascript-6">
  export default {
    name: "TreeSelect",
    model: {
      prop: 'value',
      event: 'select'
    },
    props: {
      value:{
        type: Number,
      },
      treeData: {
        type: Array,
        default: function () {
          return [];
        }
      },
      defaultProps:{
        type: Object,
        default: function () {
          return {
            id: "id",
            label: 'orgName',
            children: 'children'
          };
        }
      },
      placeholder:{
        type: String,
        default: '请选择节点'
      }
    },
    data() {
      return {
        selectedLabel: '',
        isShowSelect: false
      }
    },
    methods: {
      syncModel(){
        this.$emit('select', this.selectedValue)
      },
      handleNodeClick(data, Node){
        this.selectedLabel = data[this.defaultProps.label]
        this.selectedValue = data.id;
        // 关闭选择器
        this.isShowSelect = false;
        this.syncModel()
      },
      filterNode(value, data) {
        if (!value) return true;
        return data[this.defaultProps.label].indexOf(value) !== -1;
      },
      setCheckedNode(val){
        if(val){
          var node = this.$refs.tree.getNode(val);
          this.selectedLabel = node.data[this.defaultProps.label]
        }else{
          this.selectedLabel = ''
        }
      },
      cboxMouseLeave(e){
        if(!$(e.target).closest('.el-tree-select')[0]){
           this.isShowSelect = false;
        }
      }
    },
    watch: {
      selectedLabel(val) {
        this.$refs.tree.filter(val);
      },
      value(val){
        this.setCheckedNode(val);
      }
    },
    mounted(){
      this.setCheckedNode(this.value);

      let body = document.querySelector('body')
      body.addEventListener('click',this.cboxMouseLeave,false)
    },
    beforeDestroy() {
      let body = document.querySelector('body')
      body.removeEventListener('click', this.cboxMouseLeave);
    }
  }
</script>

<style scoped>
  .objectTree {
    position: absolute;
    overflow: auto;
    z-index: 100;
    width: 100%;
    min-height: 200px;
    background-color: #fff;
    background-image: none;
    border-radius: 4px;
    border: 1px solid #dcdfe6;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
    color: #606266;
  }
  .fade-enter-active, .fade-leave-active {
    transition: opacity .5s
  }
  .fade-enter, .fade-leave-active {
    opacity: 0
  }
</style>
