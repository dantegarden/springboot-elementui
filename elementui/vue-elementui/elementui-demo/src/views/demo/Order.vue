<template>
  <div>
    订单管理
  </div>
</template>

<script type="text/ecmascript-6">
  import api from "@/api"

  export default {
    props: [],
    data() {
      return {
        orderList:[],
        pageNum: 1,
        pageSize: 10,
        queryCondition: {
          orderSn : '11111'
        }
      }
    },
    methods: {
      getOrderList(){
        api.getOrderList({queryCondition: this.queryCondition, page: this.pageNum, size: this.pageSize}).then(res=>{
          if(res.code==200){
            this.orderList = res.data
          }
        })
      }
    },
    created(){
      this.getOrderList()
    }
  }
</script>

<style scoped>
</style>
