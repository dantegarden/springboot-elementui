<template>
  <div class="app-container">
    <div class="filter-container">
      <el-form :inline="true" :model="queryCondition">
        <el-form-item label="用户名">
          <el-input v-model="queryCondition.username" placeholder="请输入用户名"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="handleCurrentChange(1)">查询</el-button>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" icon="plus" v-if="hasPerm('user:add')" @click="showCreate">
            添加
          </el-button>
        </el-form-item>
      </el-form>
    </div>

    <el-table :data="list" v-loading.body="listLoading" element-loading-text="数据加载中" border fit
              highlight-current-row @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55"></el-table-column>
      <el-table-column align="center" label="昵称" prop="nickname" style="width: 60px;"></el-table-column>
      <el-table-column align="center" label="角色" width="100">
        <template slot-scope="scope">
          <el-tag type="success" v-text="scope.row.roleName" v-if="scope.row.roleId===1"></el-tag>
          <el-tag type="primary" v-text="scope.row.roleName" v-else></el-tag>
        </template>
      </el-table-column>
      <el-table-column align="center" label="用户名" prop="username" style="width: 60px;"></el-table-column>
      <el-table-column align="center" label="创建时间" prop="createTime" width="170"></el-table-column>
      <el-table-column align="center" label="最近修改时间" prop="updateTime" width="170"></el-table-column>
      <el-table-column align="center" label="管理" width="220" v-if="hasPerm('user:update')">
        <template slot-scope="scope">
          <el-button type="primary" icon="edit" @click="showUpdate(scope.$index)">修改</el-button>
          <el-button type="danger" icon="delete" v-if="scope.row.userId!=userId "
                     @click="removeUser(scope.$index)">删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="pageNum"
      :page-size="pageSize"
      :total="total"
      :page-sizes="[10, 20, 50, 100]"
      layout="total, sizes, prev, pager, next, jumper">
    </el-pagination>

    <el-dialog :title="dialogTitles[dialogStatus]" :visible.sync="dialogFormVisible" width="50%">
      <el-form class="small-space" :model="tempUser" label-position="left" label-width="80px"
               style='width: 300px; margin-left:50px;'>
        <el-form-item label="用户名" required >
          <el-input type="text" v-model="tempUser.username" :disabled="dialogStatus!='create'"></el-input>
        </el-form-item>
        <el-form-item label="密码" v-if="dialogStatus=='create'" required>
          <el-input type="password" v-model="tempUser.password"></el-input>
        </el-form-item>
        <el-form-item label="新密码" v-else>
          <el-input type="password" v-model="tempUser.password" placeholder="不填则不修改"></el-input>
        </el-form-item>
        <el-form-item label="角色" required>
          <el-select v-model="tempUser.roleId" placeholder="请选择">
            <el-option
              v-for="item in roles"
              :key="item.id"
              :label="item.roleName"
              :value="item.id">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="昵称" required>
          <el-input type="text" v-model="tempUser.nickname"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button v-if="dialogStatus=='create'" type="success" @click="createUser">创 建</el-button>
        <el-button v-else type="primary" @click="updateUser">修 改</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script type="text/ecmascript-6">
  import api from '@/api'
  import {mapGetters} from 'vuex'

  export default {
    props: [],
    data() {
      return {
        total: 0, //分页组件--数据总条数
        list: [],//表格的数据
        listLoading: false,//数据加载等待动画
        pageNum: 1,//页码
        pageSize: 10,//每页条数,
        multipleSelection: [],
        queryCondition: {
          username: ''
        },

        dialogStatus: 'create',
        dialogFormVisible: false,
        dialogTitles: {
          update: '编辑',
          create: '新建用户'
        },
        roles: [],//角色列表
        tempUser: {
          username: '',
          password: '',
          nickname: '',
          roleId: '',
          id: ''
        }
      }
    },
    computed:{
      ...mapGetters([
        'userId'
      ])
    },
    methods: {
      getList() {
        //查询列表
        this.listLoading = true;
        api.getUserList({queryCondition: this.queryCondition, page: this.pageNum, size: this.pageSize}).then(res => {
          if(res.code==200){
            this.listLoading = false;
            this.list = res.data.list;
            this.total = res.data.total;
          }
        })
      },
      getAllRoles() {
        api.getAllRoles().then(res => {
          this.roles = res.data;
        })
      },
      showCreate() {
        //显示新增对话框
        this.tempUser.username = "";
        this.tempUser.password = "";
        this.tempUser.nickname = "";
        this.tempUser.roleId = "";
        this.tempUser.id = "";
        this.tempUser.deleteStatus = '1';
        this.dialogStatus = "create"
        this.dialogFormVisible = true
      },
      showUpdate($index){
        let user = this.list[$index];
        this.tempUser.username = user.username;
        this.tempUser.nickname = user.nickname;
        this.tempUser.roleId = user.roleId;
        this.tempUser.id = user.userId;
        this.tempUser.deleteStatus = '1';
        this.tempUser.password = '';
        this.dialogStatus = "update"
        this.dialogFormVisible = true
      },
      createUser(){
        api.addUser(this.tempUser).then(res=>{
          if(res.code===200){
            this.$message({
              message: "添加成功",
              type: 'success',
              duration: 1 * 1000,
              onClose: () => {
                this.getList();
                this.dialogFormVisible = false
              }
            })
          }
        })
      },
      updateUser(){
        api.updateUser(this.tempUser).then(res=>{
          if(res.code===200){
            this.$message({
              message: "修改成功, 权限将在重新登录后生效",
              type: 'success',
              duration: 1 * 1000,
              onClose: () => {
                this.getList()
                this.dialogFormVisible = false
              }
            })
          }
        })
      },
      removeUser($index){
        this.$confirm('确定删除此用户?', '提示', {
          confirmButtonText: '确定',
          showCancelButton: false,
          type: 'warning'
        }).then(() => {
          let user = this.list[$index]
          api.deleteUser(user.userId).then(res=>{
            if(res.code==200){
              this.getList()
            }
          })
        })
      },
      //改变分页大小
      handleSizeChange(val) {
        this.pageSize = val;
        this.handleCurrentChange(1)
      },
      //跳转页数
      handleCurrentChange(val) {
        this.pageNum = val;
        this.getList();
      },
      handleSelectionChange(val) {
        this.multipleSelection = val;
      },
    },
    created(){
      this.getList();
      if (this.hasPerm('user:add') || this.hasPerm('user:update')) {
        this.getAllRoles();
      }
    }
  }
</script>

<style scoped>
</style>
