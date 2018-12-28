<template>
    <div ref="myPivotTable"></div>
</template>

<script>
    import '../../libs/pivot/table2excel'

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
            },
            keyMap: {
                type: Object,
                default: function () {
                    return {};
                }
            }
        },
        data() {
            return {}
        },
        components: {},
        methods: {
            reload(config) {
                this.initPivot(config)
            },
            initPivot(config) {
                var $vm = this;

                var sumNumAndPrintString = $.pivotUtilities.aggregatorTemplates.sumNumAndPrintString;
                var numberFormat = $.pivotUtilities.numberFormat;
                var intFormat = numberFormat({digitsAfterDecimal: 2}); //数据显示的格式化 可选项：suffix:"元" thousandsSep:" ", decimalSep:","
                //intFormat = function(x){return x};

                var derivedAttributes = {}
                Object.keys(this.keyMap).forEach(key => {
                    if (["rows", "cols"].includes(key)) {
                        let entries = this.keyMap[key]
                        for (var i = 0; i < entries.length; i++) {
                            derivedAttributes[entries[i].label] = (function (num) {
                                return function (record) {
                                    return record[entries[num].field]
                                }
                            })(i)
                        }
                    }
                })

                var $table = $(this.$refs.myPivotTable)
                this.$table = $table;

                config = Object.assign({
                    rows: this.rows,
                    cols: this.cols,
                    aggregator: sumNumAndPrintString(intFormat)(["value"]),//sum(intFormat)(["value"])
                    rendererName: "Table",
                    //showColTotal: false,
                    rendererOptions: {
                        table: {
                            renderCell: function () {//自定义的渲染方法 filter筛选单元格，method是渲染方法
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
                            },
                            clickCallback: function (e, value, filters, pivotData) {
                                // var names = [];
                                // pivotData.forEachMatchingRecord(filters,
                                //   function(record){ names.push(record.value); });
                                // alert(names.join("\n"));
                                $vm.$emit('clickCallback', {value, filters, pivotData})
                            }
                        }
                    },
                    derivedAttributes: derivedAttributes,
                    fixedRowHeader: true,
                    fixedColHeader: true,
                    fnDrawCallback: function (pivotData) {
                        // var totalColRow = pivotData.totalColRow;
                        // totalColRow[11].textContent = pivotData.getColValue(totalColRow[6])  * pivotData.getColValue(totalColRow[7]);
                        $vm.$emit('fnDrawCallback', pivotData)
                    }
                }, config)

                return $table.pivot(
                    this.list,
                    config,
                    "zh"
                );
            },
            downloadExcel(fileName, sheetName) {
                this.reload({
                    fixedRowHeader: false,
                    fixedColHeader: false,
                })
                var table2excel = new Table2Excel({
                    defaultFileName: fileName
                });
                table2excel.export(this.$refs.myPivotTable.firstChild);
                this.reload({
                    fixedRowHeader: true,
                    fixedColHeader: true,
                })
            }
        },
        mounted() {
            this.initPivot()
        }
    }
</script>

<style scoped>
    @import '../../libs/pivot/pivot.css';
</style>
