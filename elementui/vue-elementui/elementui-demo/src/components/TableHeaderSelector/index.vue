<template>
  <el-select v-model="fieldSelector" multiple :placeholder="placeholder" @change="onChange" @remove-tag="onRemoveTag">
    <el-option
      v-for="item in options"
      :key="item.field"
      :label="item.label"
      :value="item.label"
      :disabled="disabledOptions.includes(item.label)">
    </el-option>
  </el-select>

</template>

<script type="text/ecmascript-6">
  export default {
    name: "TableHeaderSelector",
    model: {
      prop: 'fieldSelector',
      event: 'selector'
    },
    props: {
      fieldSelector: { //选项
        type: Array,
        default: function () {
          return [];
        }
      },
      options: { //选项
        type: Array,
        default: function () {
          return [];
        }
      },
      disabledOptions: {
        type: Array,
        default: function () {
          return [];
        }
      },
      placeholder: {
        type: String,
        default: function(){
          return '请选择'
        }
      }
    },
    data() {
      return {
        lock: false
      }
    },
    methods: {
      syncModel(){
        this.$emit('selector', this.fieldSelector)
      },
      onChange(e){
        this.syncModel()
        this.$emit('afterSelectKey', this.fieldSelector)
      },
      onRemoveTag(e){
        this.$emit('onDeleteKey', e);
      }
    }
  }
</script>

<style>
</style>
