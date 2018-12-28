<template>
  <div class="app-container">
    <div class="filter-container mainBox">
      <field-filter class="filter" :field-selections="keyMap.rows" v-model="queryCondition.fieldFilter"
                    @onUseFieldFilter="onUseFieldFilter"
                    @afterUseFilter="afterUseFilter"
                    @onDeleteFilter="onDeleteFilter"></field-filter>
      <table-header-filter class="filter" :field-selections="keyMap.rows" v-model="queryCondition.rowKeys"
                           placeholder="请选择表头项"
                           @onSelectKey="onSelectKey1"
                           @afterSelectKey="afterSelectKey"
                           @onDeleteKey="onDeleteKey"></table-header-filter>
      <table-header-filter class="filter" :field-selections="keyMap.cols" v-model="queryCondition.colKeys"
                           placeholder="请选择列头项"
                           @onSelectKey="onSelectKey2"
                           @afterSelectKey="afterSelectKey"
                           @onDeleteKey="onDeleteKey"></table-header-filter>

      <button class="blueBtn" @click="query()">搜索</button>
      <div class="collect">
        <button class="blueBtn po-re" id="shouBtn" @click="showCollection">收藏</button>
        <div class="shou" >
          <ul v-if="collectionFieldFilter.length>0">
            <li v-for="(item,index) in collectionFieldFilter" @click="useCollection(index)"
                :class="{'on': item.inUse}">
              <span>{{item.collectionName}}</span>
              <img @click.stop.prevent="deleteCollection(item.id)" src="/static/images/delete_icon.png?imageView2/1/w/80/h/80" width="16" class="user-avatar"/>
            </li>
          </ul>
          <p>保存当前搜索</p>
          <p>
            <input placeholder="请输入标签" v-model="currentCollectionName"/>
          </p>
          <p>
            <button class="blueBtn" @click="addCollection">保存</button>
          </p>
        </div>
      </div>

      <button class="blueBtn" @click="downloadExcel()">导出</button>
    </div>

    <div class="table-container">
      <pivot-table v-if="ready" ref="myTable" :list="rawData" :rows="getRows" :cols="getCols" :keyMap="keyMap"></pivot-table>
    </div>

  </div>
</template>

<script type="text/ecmascript-6">
  import api from '@/api'
  import PivotTable from '@/components/PivotTable'
  import FieldFilter from '@/components/FieldFilter'
  import TableHeaderFilter from '@/components/TableHeaderFilter'

  export default {
    props: [],
    components: {
      PivotTable,
      TableHeaderFilter,
      FieldFilter
    },
    data() {
      return {
        ready: false,

        keyMap: {rows:[], cols:[]},
        rows: [],
        cols: [],
        rawData: [],
        queryCondition: {
          fieldFilter: [],
          //子集
          rowKeys: ["区域", "省份"],
          colKeys: ["月份", "大类", "小类"]
        },
        collectionFieldFilter: [],
        currentCollectionName: "",
      }
    },
    computed:{
      getRows(){
        return this.queryCondition.rowKeys;
      },
      getCols(){
        return this.queryCondition.colKeys;
      }
    },
    methods: {
      query: async function(){
        await this.getRawData();
        this.$refs.myTable.reload();
      },
      getRawData: async function(){
        let res = await api.getPivotData(this.queryCondition)
        this.rawData = res.data
      },
      getTableConfig: async function(){
        let res = await api.getTableConfig()
        this.keyMap = res.data
        this.rows = res.data.rows.map(f => f.label)
        this.cols = res.data.cols.map(f => f.label)
        this.collectionFieldFilter = res.data.collectionFieldFilter
      },
      onUseFieldFilter(event){
        console.log(event)
      },
      afterUseFilter(){
        this.query();
        this.cleanCollectionInUse();
      },
      onDeleteFilter(index){
        this.query()
        this.cleanCollectionInUse()
      },
      onSelectKey1(event){
        if(this.queryCondition.colKeys.includes(event.current.label)){
          event.$vm.lock=true //中断选择事件
        }
      },
      onSelectKey2(event){
        if(this.queryCondition.rowKeys.includes(event.current.label)) event.$vm.lock=true
      },
      afterSelectKey(kv){
        this.query()
        this.cleanCollectionInUse()
      },
      onDeleteKey(){
        this.query()
        this.cleanCollectionInUse()
      },
      useCollection(index){
        this.cleanCollectionInUse()
        let currentCollectionItem = this.collectionFieldFilter[index]
        currentCollectionItem.inUse = true;
        this.queryCondition = this.objDeepCopy(currentCollectionItem.queryCondition);
        this.query()
      },
      addCollection(){
        let collectionItem = {
          collectionName: this.currentCollectionName,
          queryCondition: this.queryCondition
        }
        api.addCollection(collectionItem).then(res=>{
          this.collectionFieldFilter = res.data
          this.currentCollectionName = ''
        })
      },
      deleteCollection(index){
        api.delCollection(index).then(res=>{
          this.collectionFieldFilter = res.data
        })
      },
      cleanCollectionInUse(){
        this.collectionFieldFilter = this.collectionFieldFilter.map(n=>{n.inUse = false; return n;})
      },
      objDeepCopy(source) {
        var sourceCopy = source instanceof Array ? [] : {};
        for (var item in source) {
          sourceCopy[item] = typeof source[item] === 'object' ? this.objDeepCopy(source[item]) : source[item];
        }
        return sourceCopy;
      },
      showCollection(){
        $(".shou").slideDown('slow');
      },
      cboxMouseLeave(e){
        console.log(e.target)
        if(!$(e.target).closest('.shou')[0] && e.target.id!="shouBtn"){
          $(".shou").slideUp('slow')
        }
      },
      downloadExcel(e){
        this.$refs.myTable.downloadExcel("交叉表","mySheet")
      },
      initFilter() {
        let body = document.querySelector('body')
        body.addEventListener('click',this.cboxMouseLeave,false)
      }
    },
    created: async function(){
      await this.getTableConfig()
      await this.getRawData()
      this.ready = true
    },
    mounted(){
      this.initFilter()
    },
    beforeDestroy() {
      let body = document.querySelector('body')
      body.removeEventListener('click', this.cboxMouseLeave);
    }
  }
</script>

<style scoped>
  .fontW {
    font-weight: bold;
  }

  .mainBox {
    margin:15px auto;
    font-size: 14px;
    box-sizing: border-box;
  }

  ul,
  li {
    list-style: none;
  }

  .mainBox:after {
    display: block;
    clear: both;
    content: "";
    visibility: hidden;
    height: 0;
  }

  .mainBox * {
    margin: 0;
    padding: 0;
  }

  .mainBox > div.filter {
    width: 22%;
    /*margin: 0 5px;*/
    float: left;
    position: relative;
    margin-top: 2px;
    margin-left: 2%;
  }
  .mainBox>div.cbox1:nth-of-type(3){margin-right: 10px;}
  .checkBox1,
  .checkBox2 {
    border: solid 1px rgb(149, 149, 149);
  }

  .checkBox1 {
    height: 35px;
    position: relative;
  }

  .checkBox1 > img {
    position: absolute;
    top: 50%;
    margin-top: -8px;
    left: 16px;
    /*z-index: 3;*/
  }

  .checkBox1 input {
    width: 99%;
    height: 100%;
    border: none;
    padding-left: 36px;
    font-size: 12px;
    margin-left: 1px;
    outline: none;
  }
  .checkBox2 input{
    padding-left: 10px;
  }
  .checkBox2 {
    display: none;
    position: absolute;
    left: -1px;
    right: -1px;
    top: 33px;
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

  .checkBox2 input, .checkBox2 select{
    width: 80%;
    height: 32px;
    border: solid 1px rgb(210, 210, 210);
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

  .add1 {
    position: absolute;
    top: -1px;
    left: -1px;
    right: -1px;
    background-color: #fff;
    padding-top: 6px;
    padding-left: 4px;
    border: solid 1px rgb(149, 149, 149);
    min-height: 35px;
    /*display: none;*/
    z-index: 2;
  }

  .add1 span {
    border: 1px solid #ccc;
    background-color: #eee;
    margin-right: 6px;
    margin-bottom: 6px;
    display: block;
    float: left;
    font-size: 12px;
    padding: 1px 2px;
  }

  img,
  span,
  button {
    vertical-align: middle;
  }

  .checkBox2 > div ul {
    margin-left: 36px;
  }

  .checkBox2 > div ul:after {
    display: block;
    clear: both;
    content: "";
    visibility: hidden;
    height: 0;
  }

  .checkBox2 > div ul li {
    margin-top: 20px;
    float: left;
    width: 33%;
    padding-left: 20px;
    cursor: pointer;
  }

  .checkBox2 > div ul li.on {
    background: url("/static/images/checked_icon.png?imageView2/1/w/80/h/80") no-repeat;
    background-size: 16px;
    background-position: left;
  }
  .po-re{position: relative;}
  .collect { position: relative; display: inline-block; }
  .shou{position: absolute;text-align: left;
    background-color: #fff;
    color: #000;display: none;z-index: 2;
    border: 1px solid #959595;padding: 10px;top: 35px;}
  .shou ul{border-bottom: solid 1px #ddd;padding-bottom: 10px;margin-bottom: 10px;}
  .shou ul li{padding: 3px 6px 3px 25px;}
  .shou ul li.on{
    background: url(/static/images/checked_icon.png?imageView2/1/w/80/h/80) no-repeat;
    background-size: 16px;
    background-position:4px;
  }
  .shou ul li:after {
    display: block;
    clear: both;
    content: "";
    visibility: hidden;
    height: 0;
  }
  .shou ul li img{
    float: right;margin-top: 3px;
  }
  .shou ul li:hover{
    background-color: #eee;
  }
  .shou input{
    margin-top: 10px;
    margin-bottom: 10px;
  }
</style>
