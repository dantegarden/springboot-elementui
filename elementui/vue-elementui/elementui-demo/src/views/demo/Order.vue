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
            <el-button type="success" v-if="hasPerm('demo:add')" @click.native="add">新增</el-button>
            <el-button type="danger"  v-if="hasPerm('demo:delete')" @click.native="deleteSelected">批量删除</el-button>
            <el-tooltip class="el-tooltip" effect="dark" content="下载数据" placement="bottom">
              <el-button icon="el-icon-download" @click="exportExcel"></el-button>
            </el-tooltip>
            <el-upload ref="uploader" v-if="hasPerm('demo:add')" name="uploadFile" style="float:left"
              :action="uploadUrl"
              :with-credentials="true"
              :limit="1"
              :show-file-list="false"
              :auto-upload="true"
              :beforeUpload="beforeUpload"
              :onError="onUploadError"
              :onSuccess="onUploadSuccess"
              :on-exceed="onExceed" >
              <el-tooltip class="el-tooltip" effect="dark" content="导入数据" placement="bottom">
                <el-button icon="el-icon-upload2"></el-button>
              </el-tooltip>
            </el-upload>
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
                         @click="remove(scope.row.id)">删除</el-button>
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

        uploadUrl: api.importOrders

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
      remove(id){
        this.$confirm('确定删除此订单?', '提示', {
          confirmButtonText: '确定',
          showCancelButton: false,
          type: 'warning'
        }).then(() => {
          api.removeOrders([id]).then(res=>{
            this.getOrderList();
            this.$message.success("删除成功");
          })
        })
      },
      deleteSelected(){
        this.$confirm('确定删除所选订单?', '提示', {
          confirmButtonText: '确定',
          showCancelButton: false,
          type: 'warning'
        }).then(() => {
          api.removeOrders(this.multipleSelection.map(m=>m.id)).then(res=>{
            this.getOrderList();
            this.$message.success("删除成功");
          })
        })
      },
      //导出excel
      exportExcel(e){
        api.exportOrderList({queryCondition: this.queryCondition})
      },
      beforeUpload (file) {
        if(file.type!=="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"){
          this.$message.error('只支持xlsx格式的文件！')
          return false;
        }
      },
      //导入excel 超出文件数量限制
      onExceed (files, fileList) {
        this.$message.error('提示：只能导入单个文件！')
      },
      onUploadSuccess (res, file, fileList) {
        // this.fileIds = response.fileIds
        if(res.status){
          this.getOrderList();
          this.$message.success('导入成功！')
        }else{
          this.$message.error('导入失败！')
        }
      },
      onUploadError (response, file, fileList) {
        this.$message.error('服务器或网络异常，导入失败！')
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
