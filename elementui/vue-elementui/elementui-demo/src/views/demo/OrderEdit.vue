<template>
  <div>
    <el-row>
        <el-form ref="form" :model="formdata" :rules="rules" label-width="80px">
          <el-col :span="16">
            <el-form-item label="订单号" prop="orderSn">
              <el-input v-model="formdata.orderSn" placeholder="请输入订单号"></el-input>
            </el-form-item>
            <el-form-item label="订单状态" prop="orderStatus">
              <el-select v-model="formdata.orderStatus" filterable placeholder="请选择订单状态" >
                <el-option
                  v-for="item in dataDict['OrderStatus']"
                  :key="item.value"
                  :label="item.label"
                  :value="parseInt(item.value)">
                </el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="下单日期" prop="orderTime">
              <el-date-picker
                v-model="formdata.orderTime"
                type="datetime"
                value-format="yyyy-MM-dd HH:mm:ss"
                placeholder="选择下单时间" >
              </el-date-picker>
            </el-form-item>
            <el-form-item label="客户" prop="customer.id">
              <el-select
                v-model="formdata.customer.id"
                filterable
                remote
                reserve-keyword
                placeholder="查找并选择客户"
                :remote-method="remoteCustomers"
                :loading="c_loading" >
                <el-option
                  v-for="item in customers"
                  :key="item.id"
                  :label="item.name"
                  :value="item.id">
                </el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="备注" prop="note">
              <el-input
                type="textarea"
                :rows="2"
                placeholder="请输入内容"
                v-model="formdata.note">
              </el-input>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="订单项">
              <el-table
                :data="orderItems"
                border
                height="250">
                <el-table-column
                  type="index"
                  width="50">
                </el-table-column>
                <el-table-column
                  prop="goods.goodsName"
                  label="商品名">
                </el-table-column>
                <el-table-column
                  prop="retailPrice"
                  label="单价"
                  width="180">
                </el-table-column>
                <el-table-column
                  prop="number"
                  label="数量"
                  width="180">
                </el-table-column>
                <el-table-column
                  prop="totalPrice"
                  label="总价"
                  width="180">
                </el-table-column>
                <el-table-column label="操作" align="right" width="300">
                  <template slot="header" slot-scope="scope">
                    <el-button
                      size="mini" type="success"
                      @click="showOrderItemDialog('add', scope.row)">新增商品</el-button>
                  </template>
                  <template slot-scope="scope">
                    <el-button
                      size="mini"
                      @click="showOrderItemDialog('update', scope.row)">编辑</el-button>
                    <el-button
                      size="mini"
                      type="danger"
                      @click="removeOrderItem(scope.$index, scope.row)">删除</el-button>
                  </template>
                </el-table-column>
              </el-table>
            </el-form-item>

            <el-form-item>
              <el-button type="primary" @click="onSubmit">{{mode=="add"?'创建':'修改'}}</el-button>
              <el-button @click="onCancel">取消</el-button>
              <el-button @click="onReset">重置</el-button>
            </el-form-item>
          </el-col>
        </el-form>

    </el-row>

    <el-dialog :title="dialogTitles[dialogStatus]" :visible="dialogFormVisible" width="50%">
      <el-form ref="dialogForm" class="small-space" :model="tempOrderItem" label-position="left" label-width="80px"
               style='width: 300px; margin-left:50px;'>
        <el-form-item label="商品" prop="goods.id" verify >
          <el-select
            v-model="tempOrderItem.goods.id"
            filterable
            remote
            reserve-keyword
            placeholder="查找并选择商品"
            :remote-method="remoteGoods"
            :loading="g_loading"
            @change="selectGoods">
            <el-option
              v-for="item in goods"
              :key="item.id"
              :label="item.goodsName"
              :value="item.id">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="原单价" prop="originPrice">
          <el-input :value="tempOrderItem.originPrice" placeholder="请选择商品" readonly></el-input>
        </el-form-item>
        <el-form-item label="现单价" prop="retailPrice" verify number :gt="0">
          <el-input v-model.number="tempOrderItem.retailPrice"  placeholder="请输入现单价" @change="onRetailPriceChange"></el-input>
        </el-form-item>
        <el-form-item label="数量" prop="number" verify int :gt="0">
          <el-input-number v-model="tempOrderItem.number" :min="1" :max="999" @change="onRetailPriceChange"></el-input-number>
        </el-form-item>
        <el-form-item label="总价" prop="totalPrice" verify number :gt="0">
          <el-input v-model.number="tempOrderItem.totalPrice"  placeholder="请输入总价"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button v-if="dialogStatus=='create'" type="success" @click="saveOrderItem">创 建</el-button>
        <el-button v-else type="primary" @click="saveOrderItem">修 改</el-button>
      </div>
    </el-dialog>


  </div>
</template>

<script type="text/ecmascript-6">
  import api from '@/api'

  export default {
    props: [],
    data() {
      return {
        mode: 'add',
        id: '',

        dataDict: [],
        formdata:{
          orderSn: '',
          orderStatus: '',
          orderTime: '',
          customer: {id:''},
          note:'',
          orderPrice: ''
        },
        rules: {
          orderSn: [{required:true, message:'必填', trigger:'blur'}],
          orderStatus: [{type:'number', required:true, message:'必选', trigger:'change'}],
          orderTime: [{required:true, message:'必填', trigger:'blur'}],
          "customer.id": [{type:'number', required:true, message:'必选', trigger:'change'}]
        },
        orderItems: [],
        customers: [],
        c_loading: false,
        goods: [],
        g_loading: false,

        dialogStatus: 'create',
        dialogFormVisible: false,
        dialogTitles: {
          update: '编辑',
          create: '新建订单项'
        },
        tempOrderItem:{
          originPrice: '',
          retailPrice: 0,
          number:1,
          totalPrice: 0,
          order:{id: ''},
          goods:{id: ''}
        }
      }
    },
    methods: {
      initForm(){
        if(this.mode=='update'){
          //返显的逻辑
          api.getOrder(this.id).then(res=>{
            if(res.code==200){
              this.formdata.orderSn = res.data.orderSn
              this.formdata.orderStatus = res.data.orderStatus
              this.formdata.orderTime = res.data.orderTime
              this.formdata.note = res.data.note
              this.formdata.orderPrice = res.data.orderPrice
              this.customers = [res.data.customer]
              this.formdata.customer = {id: res.data.customer.id}
            }
          })
        }
        this.getOrderItems();
      },
      getOrderItems(){
        api.getOrderItemList(this.id).then(res=>{
          this.orderItems =  res.data
          this.recalculateOrderPrice(); //重新结算orderPrice
        })
      },
      onSubmit(e){
        this.$refs.form.validate((valid) => {
          if (valid) {
            api.saveOrder({id: this.id, ...this.formdata}).then(res=>{
              this.$message.success({
                message: "保存成功",
                type: 'success',
                duration: 1 * 1000,
                onClose: () => {
                  this.$back()
                }
              });
            })
          }else{
            return false;
          }
        })
      },
      onCancel(e){
        this.$back()
      },
      onReset(e){ //重置表单
        this.$nextTick(()=>{
          this.$refs.form.resetFields();
        })
      },
      showOrderItemDialog(type, row){
        let b_type = type==="add"
        this.tempOrderItem.order = b_type?{id:this.id}:row.order;
        this.tempOrderItem.goods = b_type?{id:''}:row.goods;
        this.tempOrderItem.number = b_type?1:row.number;
        this.tempOrderItem.retailPrice = b_type?0:row.retailPrice;
        this.tempOrderItem.totalPrice = b_type?0:row.totalPrice;
        this.tempOrderItem.originPrice = b_type?0:row.goods.price;
        this.tempOrderItem.id = b_type?"":row.id;
        this.dialogStatus =  b_type?"create":"update"
        this.dialogFormVisible = true
        this.$nextTick(()=>{
          this.$refs.dialogForm.clearValidate();
        })
      },
      removeOrderItem(index, row){
        this.$confirm('确定删除此订单项?', '提示', {
          confirmButtonText: '确定',
          showCancelButton: false,
          type: 'warning'
        }).then(() => {
          api.removeOrderItem(row.id).then(res=>{
            this.getOrderItems();
            this.$message.success("删除成功");
          })
        })
      },
      saveOrderItem(){
        this.$refs.dialogForm.validate((valid) => {
          if (valid) {
            api.saveOrderItem(this.tempOrderItem).then(res=>{
              this.getOrderItems();
              this.dialogFormVisible = false
            })
          }else{
            return false;
          }
        })
      },
      remoteCustomers(query){ //动态加载可选项
        if (query !== '') {
          this.c_loading = true;
          api.getCustomersByName({'name': query}).then(res=>{
            if(res.code==200){
              this.customers = res.data
              this.c_loading = false;
            }
          })
        }else{
          this.customers = []
        }
      },
      remoteGoods(query){ //动态加载可选项
        if (query !== '') {
          this.g_loading = true;
          api.getGoodsByName({'name': query}).then(res=>{
            if(res.code==200){
              this.goods = res.data
              this.g_loading = false;
            }
          })
        }else{
          this.goods = []
        }
      },
      selectGoods(id){
        let selectedGoods = this.goods.find(n=>n.id==id)
        if(selectedGoods){
          this.tempOrderItem.originPrice = selectedGoods.price
        }
      },
      recalculateOrderPrice(){
        var orderPrice = 0
        this.orderItems.forEach(item => {
          orderPrice += item.totalPrice
        })
        this.formdata.orderPrice = orderPrice
      },
      onRetailPriceChange(e){
        this.tempOrderItem.totalPrice = this.tempOrderItem.number * this.tempOrderItem.retailPrice
      }
    },
    created: async function(){
      this.dataDict = await this.$dataDict(['OrderStatus'])
      this.mode = this.$route.query.action
      if(this.$route.query.id){
        this.id = this.$route.query.id
        this.initForm(); //更新返显的逻辑
      }else{
        api.addOrder().then(res=>{
          this.id = res.data
        })
      }
    }
  }
</script>

<style scoped>
 .el-select, .el-date-editor, .el-input-number, .el-table {
   width: 100%;
 }
</style>
