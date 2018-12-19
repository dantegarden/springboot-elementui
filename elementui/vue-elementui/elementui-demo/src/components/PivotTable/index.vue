<template>
    <div ref="myPivotTable"></div>
</template>

<script>
  export default {
    name: "PivotTable",
    props: {
      list: {
        type: Array,
        default: function () {
          return [];
        }
      },
      rows: {
        type: Array,
        default: function () {
          return [];
        }
      },
      cols: {
        type: Array,
        default: function () {
          return [];
        }
      }
    },
    data(){
      return {

      }
    },
    components: {

    },
    methods: {
      initPivot(){
        var sumNumAndPrintString = $.pivotUtilities.aggregatorTemplates.sumNumAndPrintString;
        var numberFormat = $.pivotUtilities.numberFormat;
        var intFormat = numberFormat({digitsAfterDecimal: 2}); //数据显示的格式化 可选项：suffix:"元" thousandsSep:" ", decimalSep:","
        //intFormat = function(x){return x};

        var $table = $(this.$refs.myPivotTable)
        this.$table = $table;

        return $table.pivot(
          this.list,
          {
            rows: this.rows,
            cols: this.cols,
            aggregator: sumNumAndPrintString(intFormat)(["value"]),//sum(intFormat)(["value"])
            rendererName: "Table",
            //showColTotal: false,
            rendererOptions:{table:{
                // renderCell:function(){//自定义的渲染方法 filter筛选单元格，method是渲染方法
                //   return [{
                //     filter:{//"年份":"2014","月份":"2月",
                //       "2014年度":"费用明细",
                //       "大类":"一、人员人工费用",
                //       "小类":"直接从事研发活动人员",
                //       "细项":"工资薪金"},
                //     method:function(src, records, value, filters, rows, pivotData){
                //       var my_value = rows[6].value * rows[7].value;
                //       pivotData.setColValue(src, my_value);
                //       return src;
                //     }
                //   }
                //   ]
                // },
                // clickCallback:function(e, value, filters, pivotData){
                //   var names = [];
                //   pivotData.forEachMatchingRecord(filters,
                //     function(record){ names.push(record.value); });
                //   alert(names.join("\n"));
                // }
              }
            },
            derivedAttributes:{
              "年份": function(record){
                return record.year;
              },
              "月份":function(record){
                return record.month;
              },
              "2014年度":function(record){
                return record.art;
              },
              "大类":function(record){
                return record.type;
              },
              "小类":function(record){
                return record.mixtype;
              },
              "细项":function(record){
                return record.mixtype2;
              }
            },
            fixedRowHeader: true,
            fixedColHeader: true,
            //fnDrawCallback: function(pivotData){
            //	var totalColRow = pivotData.totalColRow;
            //	totalColRow[11].textContent = pivotData.getColValue(totalColRow[6])  * pivotData.getColValue(totalColRow[7]);
            //}
          },"zh"
        );
      }
    },
    mounted(){
      this.initPivot()
    }
  }
</script>

<style scoped>

</style>
