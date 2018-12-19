<template>
  <div class="app-container">
    <div class="filter-container mainBox">
      <div class="cbox1">
        <div class="checkBox1" id="click1">
          <img
            src="/static/images/search_icon.png?imageView2/1/w/80/h/80"
            width="16"
            class="user-avatar"
          />
          <input type="text" placeholder="搜索" />
          <div class="add1">
            <span>
              原因-原因-原因
              <img
                src="/static/images/delete_item_icon.png?imageView2/1/w/80/h/80"
                width="12"
                class="user-avatar"
              />
            </span>
          </div>
        </div>
        <div class="checkBox2">
          <p class="fontW title">添加自定义筛选</p>
          <div>
            <p>
              <input type="text" placeholder="请选择" />
              <img
                src="/static/images/delete_icon.png?imageView2/1/w/80/h/80"
                width="16"
                class="user-avatar"
              />
            </p>
            <p><input type="text" placeholder="请选择" /></p>
            <p><input type="text" placeholder="请选择" /></p>
          </div>

          <div>
            <span class="huo">或</span>
            <p>
              <input type="text" placeholder="请选择" />
              <img
                src="/static/images/delete_icon.png?imageView2/1/w/80/h/80"
                width="16"
                class="user-avatar"
              />
            </p>
            <p><input type="text" placeholder="请选择" /></p>
            <p><input type="text" placeholder="请选择" /></p>
          </div>

          <div>
            <p>
              <button class="blueBtn" id="blueBtn">添加</button>
              <button class="whiteBtn">
                <img
                  src="/static/images/add_icon.png?imageView2/1/w/80/h/80"
                  width="16"
                  class="user-avatar"
                />
                <span>添加条件</span>
              </button>
            </p>
          </div>
        </div>
      </div>

      <div class="cbox1">
        <div class="checkBox1" id="click2">
          <img
            src="/static/images/search_icon.png?imageView2/1/w/80/h/80"
            width="16"
            class="user-avatar"
          />
          <input type="text" placeholder="搜索" />
          <div class="add1">
            <span>
              原因-原因-原因
              <img
                src="/static/images/delete_item_icon.png?imageView2/1/w/80/h/80"
                width="12"
                class="user-avatar"
              />
            </span>
          </div>
        </div>
        <div class="checkBox2">
          <p class="fontW title">请选择</p>
          <div>
            <ul>
              <li>年份</li>
              <li>月份</li>

            </ul>
          </div>
        </div>
      </div>

    </div>
    <div class="table-container">
      <pivot-table :list="rawData" :rows="rows" :cols="cols"></pivot-table>
    </div>
  </div>
</template>

<script type="text/ecmascript-6">
  import PivotTable from '@/components/PivotTable'

  export default {
    props: [],
    components:{
      PivotTable
    },
    data() {
      return {
        rows: ["年份","月份"],
        cols: ["2014年度","大类","小类","细项"],
        rawData: [
          {year:"2014",month: "1月", art: "摘要",  value: "10"},
          {year:"2014",month: "1月", art: "摘要",  value: "10"},
          {year:"2014",month: "1月", art: "贷方金额",  value: 1490.545},
          {year:"2014",month: "1月", art: "借方金额",  value: 0},
          {year:"2014",month: "1月", art: "余额",  value: 10},
          {year:"2014",month: "2月", art: "余额",  value: 10},
          {year:"2014",month: "1月", art: "借或贷",  value: "借"},
          //{year:"2014",month: "1月", art: "借或贷",  value: "贷"},
          {year:"2014",month: "2月", art: "借或贷",  value: "贷"},
          {year:"2014",month: "1月", art: "费用明细", type:1, mixtype:"直接从事研发活动人员", mixtype2:"工资薪金", value: "1%"},
          {year:"2014",month: "1月", art: "费用明细", type:1, mixtype:"直接从事研发活动人员", mixtype2:"五险一金", value: 2},
          {year:"2014",month: "1月", art: "费用明细", type:1, mixtype:"外聘研发人员的劳务费", value: 3},
          {year:"2014",month: "1月", art: "费用明细", type:2, mixtype:"研发活动直接消耗", mixtype2:"材料", value: 4},
          {year:"2014",month: "1月", art: "费用明细", type:2, mixtype:"研发活动直接消耗", mixtype2:"燃料", value: 5},
          {year:"2014",month: "1月", art: "费用明细", type:2, mixtype:"研发活动直接消耗", mixtype2:"动力费用", value: 6},
          {year:"2014",month: "1月", art: "费用明细", type:2, mixtype:"用于中间试验和产品试制的模具、工艺装备开发及制造费", value: 7},
          {year:"2014",month: "1月", art: "费用明细", type:2, mixtype:"用于不构成固定资产的样品、样机及一般测试手段购置费", value: 8},
          {year:"2014",month: "1月", art: "费用明细", type:2, mixtype:"用于试制产品的检验费", value: 9},
          {year:"2014",month: "1月", art: "费用明细", type:2, mixtype:"用于研发活动的仪器、设备的运行维护、调整、检验、维修等费用", value: 10},
          {year:"2014",month: "1月", art: "费用明细", type:2, mixtype:"通过经营租赁方式租入的用于研发活动的仪器、设备租赁费", value: 11},
          {year:"2014",month: "1月", art: "费用明细", type:3, mixtype:"用于研发活动的仪器的折旧费", value: 12},
          {year:"2014",month: "1月", art: "费用明细", type:3, mixtype:"用于研发活动的设备的折旧费", value: 13},
          {year:"2014",month: "1月", art: "费用明细", type:4, mixtype:"用于研发活动的软件的摊销费用", value: 14},
          {year:"2014",month: "1月", art: "费用明细", type:4, mixtype:"用于研发活动的专利权的摊销费用", value: 15},
          {year:"2014",month: "2月", art: "费用明细", type:1, mixtype:"直接从事研发活动人员", mixtype2:"工资薪金", value: "16%"},
          {year:"2014",month: "2月", art: "费用明细", type:1, mixtype:"直接从事研发活动人员", mixtype2:"五险一金", value: 17},
          {year:"2014",month: "2月", art: "费用明细", type:1, mixtype:"外聘研发人员的劳务费", value: 18},
          {year:"2014",month: "2月", art: "费用明细", type:2, mixtype:"研发活动直接消耗", mixtype2:"材料", value: 19},
          {year:"2014",month: "2月", art: "费用明细", type:2, mixtype:"研发活动直接消耗", mixtype2:"燃料", value: 20},
          {year:"2014",month: "2月", art: "费用明细", type:2, mixtype:"研发活动直接消耗", mixtype2:"动力费用", value: 21},
          {year:"2014",month: "2月", art: "费用明细", type:2, mixtype:"用于中间试验和产品试制的模具、工艺装备开发及制造费", value: 22},
          {year:"2014",month: "2月", art: "费用明细", type:2, mixtype:"用于不构成固定资产的样品、样机及一般测试手段购置费", value: 23},
          {year:"2014",month: "2月", art: "费用明细", type:2, mixtype:"用于试制产品的检验费", value: 24},
          {year:"2014",month: "2月", art: "费用明细", type:2, mixtype:"用于研发活动的仪器、设备的运行维护、调整、检验、维修等费用", value: 25},
          {year:"2014",month: "2月", art: "费用明细", type:2, mixtype:"通过经营租赁方式租入的用于研发活动的仪器、设备租赁费", value: 26},
          {year:"2014",month: "2月", art: "费用明细", type:3, mixtype:"用于研发活动的仪器的折旧费", value: 27},
          {year:"2014",month: "2月", art: "费用明细", type:3, mixtype:"用于研发活动的设备的折旧费", value: 28},
          {year:"2014",month: "2月", art: "费用明细", type:4, mixtype:"用于研发活动的软件的摊销费用", value: 29},
          {year:"2014",month: "2月", art: "费用明细", type:4, mixtype:"用于研发活动的专利权的摊销费用", value: 30},
          {year:"2014",month: "2月", art: "费用明细", type:1, mixtype:"直接从事研发活动人员", mixtype2:"工资薪金", value: "17%"},
          {year:"2014",month: "2月", art: "费用明细", type:1, mixtype:"直接从事研发活动人员", mixtype2:"五险一金", value: 10},
          {year:"2014",month: "2月", art: "费用明细", type:1, mixtype:"外聘研发人员的劳务费", value: 10},

          {year:"2015", month:"1月", art: "余额",  value: 11},
          {year:"2015", month:"2月", art: "借或贷",  value: "借"},
          {year:"2016", month:"1月", art: "余额",  value: 12},
          {year:"2016", month:"2月", art: "借或贷",  value: "借"},
          {year:"2017", month:"1月", art: "余额",  value: 12},
          {year:"2017", month:"2月", art: "余额",  value: 12},
          {year:"2017", month:"3月", art: "余额",  value: 12},
          {year:"2017", month:"4月", art: "余额",  value: 12},
          {year:"2017", month:"5月", art: "余额",  value: 12},
          {year:"2017", month:"6月", art: "借或贷",  value: "借"},
          {year:"2017", month:"7月", art: "借或贷",  value: "借"},
          {year:"2017", month:"8月", art: "借或贷",  value: "借"},
          {year:"2017", month:"9月", art: "借或贷",  value: "借"},
          {year:"2018", month:"1月", art: "余额",  value: 12},
          {year:"2018", month:"2月", art: "借或贷",  value: "借"},
        ]
      }
    },
    methods: {


    },
    mounted(){
      // this.pivotTable = this.initPivot()
      $("#click1").click(function () {

        $("#click1 +.checkBox2").slideToggle();

      })
      $("#click2").click(function () {

        $("#click2 +.checkBox2").slideToggle();

      })
      $("#click3").click(function () {

        $("#click3 +.checkBox2").slideToggle();

      })


      $("#blueBtn").click(function () {
        $("#click1 .add1").show();
      })


      $(".checkBox2>div ul li").each(function(index){
        $(this).click(function(){
          // to do something
          // index计数
          $(".checkBox2>div ul li").eq(index).addClass("on");
          $("#click2 .add1").show();
        });

      });
    }
  }
</script>

<style scoped>
.fontW {
  font-weight: bold;
}
.mainBox {
  margin: auto;
  font-size: 14px;
  width: 1135px;
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
.mainBox > div {
  width: 360px;
  margin: 0 10px;
  float: left;
}
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
}
.checkBox1 input {
  width: 100%;
  height: 100%;
  border: none;
  padding-left: 36px;
  font-size: 12px;
}
.checkBox2 {
  display: none;
}
.checkBox2 p {
  padding-left: 36px;
  margin-bottom: 4px;
  margin-top: 0;
}
.checkBox2 > p.title {
  margin-top: 19px;
}
.checkBox2 input {
  width: 200px;
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
.blueBtn {
  width: 80px;
  height: 32px;
  color: #fff;
  font-size: 14px;
  background-color: rgb(38, 100, 195);
  border: none;
  margin-right: 5px;
}
.whiteBtn {
  width: 110px;
  height: 32px;
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
  display: none;
  z-index: 2;
}
.add1 span {
  border: solid 1px rgb(238, 238, 238);
  background-color: #ddd;
  margin-right: 6px;
  margin-bottom: 6px;
  display: block;
  float: left;
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
  background: url("/static/images/checked_icon.png?imageView2/1/w/80/h/80")
    no-repeat;
  background-size: 16px;
  background-position: left;
}
</style>
