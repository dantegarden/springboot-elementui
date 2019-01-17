<template>
  <div class="el-select"
       :class="[selectSize ? 'el-select--' + selectSize : '']"
       @click.stop="toggleMenu"
       v-clickoutside="handleClose">
    <div class="el-select__tags" ref="tags"
         :style="{ 'max-width': inputWidth - 32 + 'px', width: '100%' }"
         v-if="fieldFilter.length>0">
      <span>
        <el-tag v-for="(item,index) in fieldFilter"
                :closable="!selectDisabled"
                :size="collapseTagSize"
                type="info"
                @close="deleteFieldFilter(index)"
                disable-transitions>
          <span class="el-select__tags-text">{{item.label}}</span>
        </el-tag>
      </span>
      <input
        type="text"
        class="el-select__input"
        :class="[selectSize ? `is-${ selectSize }` : '']"
        :disabled="selectDisabled"
        :style="{ 'flex-grow': '1', width: inputLength / (inputWidth - 32) + '%', 'max-width': inputWidth - 42 + 'px' }"
        ref="input">
    </div>

    <el-input
      type="text"
      ref="reference"
      readonly="readonly"
      autocomplete="off"
      :placeholder="fieldFilter.length>0?'':placeholder"
      :size="selectSize"
      :disabled="selectDisabled"
      :class="{ 'is-focus': visible }">
      <template slot="suffix">
        <i  :class="['el-select__caret', 'el-input__icon', 'el-icon-' + iconClass]"></i>
      </template>
    </el-input>

    <transition
      name="el-zoom-in-top"
      @after-leave="doDestroy">
      <el-select-menu
        ref="popper"
        :append-to-body="popperAppendToBody"
        v-show="visible" style="width:100%;">

        <div ref="box" class="checkBox2">
          <p class="fontW title">添加自定义筛选</p>
          <div v-for="(item,iindex) in currentFieldFilter.query">
            <span class="huo" v-if="currentFieldFilter.query.length>1 && iindex>0">或</span>
            <p>
              <el-select v-model="item[0]" size="small" placeholder="请选择" :popper-append-to-body="false" @change="onFieldChange(iindex)">
                <el-option
                  v-for="kv in fieldSelections"
                  :key="kv.field"
                  :label="kv.label"
                  :value="kv.field">
                </el-option>
              </el-select>
              <img @click="clearFieldFilter(iindex)" src="/static/images/delete_icon.png?imageView2/1/w/80/h/80" width="16" class="user-avatar"/>
            </p>
            <p>
              <el-select v-model="item[1]" size="small" placeholder="请选择" :popper-append-to-body="false">
                <el-option
                  v-for="kv in currentFieldFilter.structure[iindex][1]"
                  :key="kv.value"
                  :label="kv.label"
                  :value="kv.value">
                </el-option>
              </el-select>
            </p>
            <p>
              <el-input v-if="currentFieldFilter.structure[iindex][0]==='STRING'" v-model="item[2]" size="small" placeholder="请输入文字"></el-input>
              <el-input v-if="currentFieldFilter.structure[iindex][0]==='NUMBER'" v-model.number="item[2]" size="small" placeholder="请输入数字"></el-input>
              <el-select v-if="currentFieldFilter.structure[iindex][0]==='SELECTION'" v-model="item[2]" size="small" placeholder="请选择" :popper-append-to-body="false">
                <el-option
                  v-for="item in currentFieldFilter.structure[iindex][2][currentFieldFilter.structure[iindex][3]]"
                  :key="item.value"
                  :label="item.label"
                  :value="parseInt(item.value)">
                </el-option>
              </el-select>
              <el-date-picker
                v-if="currentFieldFilter.structure[iindex][0]==='DATE'" size="small" :appendToBody="false"
                v-model="item[2]"
                type="datetime"
                value-format="yyyy-MM-dd HH:mm:ss"
                placeholder="请选择时间" >
              </el-date-picker>
            </p>
          </div>

          <div>
            <p>
              <el-button size="small" type="primary" @click="useFieldFilter">应用</el-button>
              <el-button size="small" icon="el-icon-circle-plus"  @click="addFieldFilter" >添加条件</el-button>
            </p>
          </div>
        </div>
      </el-select-menu>
    </transition>
  </div>
</template>

<script type="text/ecmascript-6">
  import Emitter from 'element-ui/src/mixins/emitter';
  import Focus from 'element-ui/src/mixins/focus';
  import Locale from 'element-ui/src/mixins/locale';
  import ElSelectMenu from 'element-ui/packages/select/src/select-dropdown';
  import Clickoutside from 'element-ui/src/utils/clickoutside';
  import { addResizeListener, removeResizeListener } from 'element-ui/src/utils/resize-event';

  export default {
    mixins: [Emitter, Locale, Focus('reference')],
    name: "PivotFilter",
    directives: { Clickoutside },
    components: { ElSelectMenu,  },
    model: {
      prop: 'fieldFilter',
      event: 'filter'
    },

    inject: {
      elForm: {
        default: ''
      },

      elFormItem: {
        default: ''
      }
    },
    props: {
      fieldFilter: { //选项
        type: Array,
        default: function () {
          return [];
        }
      },
      fieldSelections: { //选项
        type: Array,
        default: function () {
          return [];
        }
      },
      placeholder: {
        type: String,
        default() {
          return '请选择';
        }
      },
      size: String,
      disabled: Boolean,
      popperAppendToBody: {
        type: Boolean,
        default: true
      }
    },
    data() {
      return {
        currentFieldFilter: {
          label: '',
          relation: 'and',
          query: [["", "", ""]],
          structure: [["STRING", []]]
        },
        inputLength: 20,
        inputWidth: 0,
        initialInputHeight: 0,
        visible:false,
        lock: false
      }
    },
    computed: {
      _elFormItemSize() {
        return (this.elFormItem || {}).elFormItemSize;
      },
      collapseTagSize() {
        return ['small', 'mini'].indexOf(this.selectSize) > -1
          ? 'mini'
          : 'small';
      },
      selectSize() {
        return this.size || this._elFormItemSize || (this.$ELEMENT || {}).size;
      },
      selectDisabled() {
        return this.disabled || (this.elForm || {}).disabled;
      },
      iconClass() {
        return  this.visible ? 'arrow-up is-reverse' : 'arrow-up';
      }
    },
    methods: {
      syncModel(){
        this.$emit('filter', this.fieldFilter)
      },
      toggleMenu() {
        this.visible = !this.visible;
      },
      handleClose() {
        this.visible = false;
      },
      doDestroy() {
        this.$refs.popper && this.$refs.popper.doDestroy();
      },
      resetInputWidth() {
        this.inputWidth = this.$refs.reference.$el.getBoundingClientRect().width;
      },
      resetInputHeight() {
        this.$nextTick(() => {
          if (!this.$refs.reference) return;
          let inputChildNodes = this.$refs.reference.$el.childNodes;
          let input = [].filter.call(inputChildNodes, item => item.tagName === 'INPUT')[0];
          const tags = this.$refs.tags;
          const sizeInMap = this.initialInputHeight || 40;
          input.style.height = this.fieldFilter.length === 0
            ? sizeInMap + 'px'
            : Math.max(
            tags ? (tags.clientHeight + (tags.clientHeight > sizeInMap ? 6 : 0)) : 0,
            sizeInMap
          ) + 'px';
          if (this.visible) {
            //this.broadcast('ElSelectDropdown', 'updatePopper');
          }
        });
      },
      handleResize() {
        this.resetInputWidth();
        this.resetInputHeight();
      },
      onFieldChange: async function(iindex){
        let formItems = this.currentFieldFilter.query[iindex]
        let fieldInfo = this.fieldSelections.find(f=> f.field===formItems[0])
        console.log(fieldInfo)
        let formStructure = []
        formStructure.push(fieldInfo.type)
        formStructure.push(fieldInfo.relations)
        if(fieldInfo.type==="SELECTION"){
          formStructure.push( await this.$dataDict([fieldInfo.dict]) )
          formStructure.push(fieldInfo.dict)
        }
        //数组赋值重新渲染页面
        this.$set(this.currentFieldFilter.structure, iindex, formStructure)
      },
      useFieldFilter(){
        let currentFieldFilter = this.currentFieldFilter

        this.lock = false
        this.$emit('onUseFieldFilter', {$vm: this, current: currentFieldFilter});
        if(!this.lock){
          let labels = [];
          let index = 0;
          let check_flag = currentFieldFilter.query.every(item => {
            if(item[0]==="" || item[1]==="" || item[2]===""){
              this.$message.error('筛选条件不能为空')
              return false
            }else{
              let field_kv = this.fieldSelections.find(kv => kv.field === item[0])

              let field_structure = this.currentFieldFilter.structure[index];
              let relation_kv = field_structure[1].find(kv => kv.value === item[1])

              let value_kv = item[2]
              if(field_structure[0]=="SELECTION"){
                value_kv = field_structure[2][field_structure[3]].find(i=>i.value==value_kv).label
              }
              labels.push(field_kv.label+ " " +relation_kv.label+ " " + value_kv+"; " );
              index++;
              return true
            }
          })
          if(check_flag){
            currentFieldFilter.label = labels.join(currentFieldFilter.relation === "or"?'或':'且')
            this.fieldFilter.push(currentFieldFilter)
            this.currentFieldFilter = {
              label: '',
              relation: 'and',
              query: [["", "", ""]],
              structure: [["STRING", []]]
            }
            this.syncModel();
          }
        }

        this.$emit('afterUseFilter');
      },
      addFieldFilter(){
        this.currentFieldFilter.query.push(["", "", ""])
        this.currentFieldFilter.structure.push(["STRING", []])
        this.currentFieldFilter.relation = "or";
      },
      deleteFieldFilter(index){
        this.fieldFilter.splice(index, 1)
        this.syncModel()
        this.$emit('onDeleteFilter', index);
      },
      clearFieldFilter(index){
        if(this.currentFieldFilter.query.length==1){return}
        this.currentFieldFilter.query.splice(index,1)
        this.currentFieldFilter.structure.splice(index,1)
        if(this.currentFieldFilter.query.length==1){
          this.currentFieldFilter.relation = "and";
        }
      },
      cboxMouseLeave(e){ //阻止默认事件，阻止冒泡
        console.log(e)
        e.stopPropagation()
        e.preventDefault();
      },
    },
    mounted() {
      this.$refs.box.addEventListener('click',this.cboxMouseLeave, false)
      //addResizeListener(this.$el, this.handleResize);

      const reference = this.$refs.reference;
      if (reference && reference.$el) {
        const sizeMap = {
          medium: 36,
          small: 32,
          mini: 28
        };
        this.initialInputHeight = reference.$el.getBoundingClientRect().height || sizeMap[this.selectSize];
      }
      this.resetInputHeight();
      this.$nextTick(() => {
        if (reference && reference.$el) {
          this.inputWidth = reference.$el.getBoundingClientRect().width;
        }
      });
    },
    beforeDestroy() {
      this.$refs.box.removeEventListener('click', this.cboxMouseLeave);
    },
    watch: {
      selectDisabled() {
        this.$nextTick(() => {
          this.resetInputHeight();
        });
      },
      fieldFilter: {
        handler(newValue, oldValue) {
          this.$nextTick(()=>{
            this.resetInputHeight();
          })
        },
        deep: true
      }
    }
  }
</script>

<style scoped>
  .fontW {
    font-weight: bold;
  }

  ul,
  li {
    list-style: none;
  }
  .checkBox2 {
    position: absolute;
    left: -1px;
    right: -1px;
    z-index: 2;
    background-color: #fff;
  }

  .checkBox2 p {
    padding-left: 36px;
    margin-bottom: 4px;
    margin-top: 0;
  }

  .checkBox2 > p.title {
    margin-top: 19px;
  }

  .checkBox2 .el-select, .checkBox2 .el-input{
    width: 80%;
    height: 32px;
    /*border: solid 1px rgb(210, 210, 210);*/
    margin-right: 6px;
  }

  .checkBox2 > div {
    margin-bottom: 19px;
    position: relative;
  }

  .checkBox2 > div .huo {
    position: absolute;
    top: 8px;
    left: 16px;
  }

  .checkBox2 input::-webkit-input-placeholder {
    /* WebKit browsers */
    color: rgb(199, 199, 199);
  }

  .checkBox2 input :-moz-placeholder {
    /* Mozilla Firefox 4 to 18 */
    color: rgb(199, 199, 199);
  }

  .checkBox2 input::-moz-placeholder {
    /* Mozilla Firefox 19+ */
    color: rgb(199, 199, 199);
  }

  .checkBox2 input :-ms-input-placeholder {
    /* Internet Explorer 10+ */
    color: rgb(199, 199, 199);
  }
  button{cursor: pointer;}
  .blueBtn {
    width: 80px;
    height: 35px;
    color: #fff;
    font-size: 14px;
    background-color: rgb(38, 100, 195);
    border: none;
    margin-right: 5px;
    margin-top: 2px;
  }

  .whiteBtn {
    width: 110px;
    height: 35px;
    font-size: 14px;
    background-color: #fff;
    border-radius: 4px;
    color: rgb(51, 51, 51);
    border: solid 1px rgb(210, 210, 210);
  }

  img,
  span,
  button {
    vertical-align: middle;
  }

</style>
