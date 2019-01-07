<template>
  <div class="app-container">

    <div class="filter-container">
      <el-form :inline="true" :model="queryCondition"  size="mini">
        <el-form-item label="订单编号">
          <el-input v-model="queryCondition.orderSn" placeholder="订单编号"></el-input>
        </el-form-item>
        <el-form-item label="订单状态">
          <el-select v-model="queryCondition.orderStatus" filterable placeholder="请选择">
            <el-option
              v-for="item in dataDict['OrderStatus']"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="下单时间">
          <el-date-picker
            v-model="queryCondition.orderTime"
            type="daterange"
            align="right"
            unlink-panels
            format="yyyy年MM月dd日"
            value-format="yyyy-MM-dd"
            range-separator="至"
            start-placeholder="开始日期"
            end-placeholder="结束日期"></el-date-picker>
        </el-form-item>
        <el-form-item>
          <el-button-group>
            <el-button type="primary" icon="el-icon-refresh" @click="getOrderList"></el-button>
            <el-button type="primary" icon="search" @click="query">查询</el-button>
            <el-button type="primary" v-if="hasPerm('demo:add')" @click.native="add">新增</el-button>
            <el-button type="danger"  v-if="hasPerm('demo:delete')" @click.native="deleteSelected">批量删除</el-button>
          </el-button-group>
        </el-form-item>
      </el-form>
    </div>

    <div class="table-container">
      <el-table ref="table" v-loading.body="listLoading" :data="orderList" border class="full"
                height="500" @selection-change="onSelectionChange" @sort-change='onSortChange'>
        <el-table-column type="selection" width="55" fixed="left"></el-table-column>
        <el-table-column align="center" sortable='custom' label="订单号" prop="orderSn" ></el-table-column>
        <el-table-column align="center" label="客户" prop="customer.name" ></el-table-column>
        <el-table-column align="center" label="收货地址" width="220" prop="customer.address" ></el-table-column>
        <el-table-column align="center" sortable='custom' label="订单总价" prop="orderPrice"></el-table-column>
        <el-table-column align="center" label="订单状态" >
          <template slot-scope="scope">{{ $dataTrans(scope.row.orderStatus, 'OrderStatus') }}</template>
        </el-table-column>
        <el-table-column align="center" sortable='custom' label="下单时间" prop="orderTime" ></el-table-column>
        <el-table-column align="center" label="管理" width="160" fixed="right">
          <template slot-scope="scope">
            <el-button-group>
              <el-button type="primary" icon="edit" v-if="hasPerm('demo:update')"
                         @click="update(scope.row.id)">修改</el-button>
              <el-button type="danger" icon="delete" v-if="hasPerm('demo:delete')"
                         @click="delete(scope.row.id)">删除</el-button>
            </el-button-group>
          </template>
        </el-table-column>
      </el-table>
    </div>

    <div class="pagination-container">
      <el-pagination
        @size-change="onSizeChange"
        @current-change="onCurrentChange"
        background
        :current-page="pageNum"
        :page-size="pageSize"
        :total="total"
        :page-sizes="[10, 20, 50, 100]"
        layout="total, sizes, prev, pager, next, jumper">
      </el-pagination>
    </div>

  </div>
</template>

<script type="text/ecmascript-6">
  import api from "@/api"

  export default {
    props: [],
    data() {
      return {
        dataDict: [],

        orderList:[],
        listLoading: false,
        pageNum: 1,
        pageSize: 10,
        total: 0, //分页组件--数据总条数
        orderBy: '',
        multipleSelection: [],
        queryCondition: {
          orderSn : '',
          orderTime: ['2017-10-01', '2018-12-11'],
          orderStatus: ''
        },


      }
    },
    methods: {
      getOrderList(){
        this.listLoading = true;
        api.getOrderList({queryCondition: this.queryCondition, page: this.pageNum, size: this.pageSize, orderBy: this.orderBy}).then(res=>{
          if(res.status){
            this.listLoading = false;
            this.orderList = res.data.list;
            this.total = res.data.total;
          }
        })
      },
      query(){
        this.pageNum = 1;
        this.getOrderList()
      },
      add(){
        this.$router.push({path:"/demo/order/edit", query:{action:'add'}})
      },
      update(id){
        this.$router.push({path:"/demo/order/edit", query:{action:'update', id: id}})
      },
      delete(id){
        alert(id)
      },
      deleteSelected(){

      },
      //改变分页大小
      onSizeChange(val) {
        this.pageSize = val;
        this.onCurrentChange(1)
      },
      //跳转页数
      onCurrentChange(val) {
        this.pageNum = val;
        this.getOrderList();
      },
      onSelectionChange(val){
        this.multipleSelection = val;
      },
      onSortChange(column){
        console.log(column)
        this.orderBy = [column.prop, column.order.startsWith("asc")?'asc':'desc'].join(' ')
        this.query()
      }
    },
    created: async function(){
      this.getOrderList()
      this.dataDict = await this.$dataDict(['OrderStatus'])
    }
  }
</script>

<style scoped>
  .full {
    width: 100%;
  }
  .pagination-container {
    float: right;
    margin-top: 10px;
  }

</style>
