<template>
  <div class="app-container">
    <div class="filter-container">
      <el-form :inline="true" :model="queryCondition">
        <el-form-item label="角色名">
          <el-input v-model="queryCondition.roleName" placeholder="请输入角色名"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="getList">查询</el-button>
        </el-form-item>
        <el-form-item>
          <el-button type="success" icon="plus" v-if="hasPerm('user:add')" @click="showCreate">
            添加角色
          </el-button>
        </el-form-item>
      </el-form>
    </div>
    <el-table :data="list" v-loading.body="listLoading" element-loading-text="数据加载中" border fit highlight-current-row>
      <el-table-column align="center" label="序号" width="55">
        <template slot-scope="scope">
          <span v-text="scope.$index + 1"> </span>
        </template>
      </el-table-column>
      <el-table-column align="center" label="角色" prop="roleName" width="150"></el-table-column>
      <el-table-column align="center" label="用户">
        <template slot-scope="scope">
          <div v-for="user in scope.row.users">
            <div v-text="user.nickname" style="display: inline-block;vertical-align: middle;"></div>
          </div>
        </template>
      </el-table-column>
      <el-table-column align="center" label="菜单&权限" width="420">
        <template slot-scope="scope">
          <el-tag v-if="scope.row.roleName=='管理员'" type="success">全部</el-tag>
          <div v-else>
            <div v-for="menu in scope.row.menus" style="text-align: left">
              <span style="width: 100px;display: inline-block;text-align: right ">{{menu.menuName}}</span>
              <el-tag v-for="perm in menu.permissions" :key="perm.permissionName" v-text="perm.permissionName"
                      style="margin-right: 3px;"
                      type="primary"></el-tag>
            </div>
          </div>
        </template>
      </el-table-column>
      <el-table-column align="center" label="管理" width="220" v-if="hasPerm('role:update') ||hasPerm('role:delete') ">
        <template slot-scope="scope">
          <div v-if="scope.row.roleName!='管理员'">
            <el-button v-if="hasPerm('role:update')" type="primary" icon="edit" @click="showUpdate(scope.$index)" >
              修改
            </el-button>
            <el-button v-if=" scope.row.users && scope.row.users.length===0 && hasPerm('role:delete')" type="danger"
                       icon="delete"
                       @click="removeRole(scope.$index)">
              删除
            </el-button>
          </div>
        </template>
      </el-table-column>
    </el-table>

      <el-dialog :title="dialogTitles[dialogStatus]" :visible.sync="dialogFormVisible" width="75%">
      <el-form class="small-space" :model="tempRole" label-position="left" label-width="100px"
               style='width: 100%; margin-left:50px;'>
        <el-form-item label="角色名称" required>
          <el-input type="text" v-model="tempRole.roleName" style="width: 250px;"></el-input>
        </el-form-item>
        <el-form-item label="菜单&权限" required>
          <div v-for=" (menu,_index) in allPermission" :key="menu.menuName">
            <span style="width: 100px;display: inline-block;">
              <el-button :type="isMenuNone(_index)? '':(isMenuAll(_index)?'success':'primary')" size="mini"
                         style="width:80px;"
                         @click="checkAll(_index)">{{menu.menuName}}</el-button>
            </span>
            <div style="display: inline-block;margin-left:20px;">
              <el-checkbox-group v-model="tempRole.permissions">
                <el-checkbox v-for="perm in menu.permissions" :label="perm.id" @change="checkRequired(perm,_index)"
                             :key="perm.id">
                  <span :class="{requiredPerm:perm.requiredPermission===1}">{{perm.permissionName}}</span>
                </el-checkbox>
              </el-checkbox-group>
            </div>
          </div>
          <p style="color:#848484;">说明:红色权限为对应菜单内的必选权限</p>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button v-if="dialogStatus=='create'" type="success" @click="createRole">创 建</el-button>
        <el-button type="primary" v-else @click="updateRole">修 改</el-button>
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
        list: [],//表格的数据
        listLoading: false,//数据加载等待动画
        multipleSelection: [],
        queryCondition: {
          roleName: ''
        },

        allPermission: [],
        dialogStatus: 'create',
        dialogFormVisible: false,
        dialogTitles: {
          update: '编辑',
          create: '新建用户'
        },
        tempRole: {
          id: '',
          roleName: '',
          permissions: [],
        }
      }
    },
    methods: {
      getList() {
        //查询列表
        this.listLoading = true;
        api.getRoleList({queryCondition: this.queryCondition}).then(res => {
          if(res.code==200){
            this.listLoading = false;
            this.list = res.data;
          }
        })
      },
      getAllPermisson(){
        api.getAllPermission().then(res => {
          this.allPermission = res.data;
        })
      },
      showCreate(){
        //显示新增对话框
        this.tempRole.roleName = '';
        this.tempRole.id = '';
        this.tempRole.permissions = [];
        this.tempRole.deleteStatus = '1';
        this.dialogStatus = "create"
        this.dialogFormVisible = true
      },
      showUpdate($index){
        let role = this.list[$index];
        this.tempRole.roleName = role.roleName;
        this.tempRole.id = role.roleId;
        this.tempRole.permissions = [];
        for (let i = 0; i < role.menus.length; i++) {
          let perm = role.menus[i].permissions;
          for (let j = 0; j < perm.length; j++) {
            this.tempRole.permissions.push(perm[j].id);
          }
        }
        this.dialogStatus = "update"
        this.dialogFormVisible = true
      },
      createRole(){
        if (!this.checkRoleNameUnique() || !this.checkPermissionNum()) return;
        api.addRole(this.tempRole).then(() => {
          this.getList();
          this.dialogFormVisible = false
        })
      },
      updateRole(){
        if (!this.checkRoleNameUnique() || !this.checkPermissionNum()) return;
        api.updateRole(this.tempRole).then(() => {
          this.getList();
          this.dialogFormVisible = false
        })
      },
      removeRole($index){
        this.$confirm('确定删除此角色?', '提示', {
          confirmButtonText: '确定',
          showCancelButton: false,
          type: 'warning'
        }).then(() => {
          let role = this.list[$index]
          api.deleteRole(role.roleId).then(res=>{
            if(res.code==200){
              this.getList()
            }
          })
        })
      },
      checkPermissionNum() {
        //校验至少有一种权限
        if (this.tempRole.permissions.length === 0) {
          this.$message.error("请至少选择一种权限");
          return false;
        }
        return true;
      },
      checkRoleNameUnique(roleId) {
        //校验名称重复
        let roleName = this.tempRole.roleName;
        if (!roleName) {
          this.$message.error("请填写角色名称");
          return false;
        }
        let roles = this.list;
        let result = true;
        for (let j = 0; j < roles.length; j++) {
          if (roles[j].roleName === roleName && (!roleId || roles[j].id !== roleId  )) {
            this.$message.error("角色名称已存在");
            result = false;
            break;
          }
        }
        return result;
      },
      isMenuNone(_index) {
        //判断本级菜单内的权限是否一个都没选
        let menu = this.allPermission[_index].permissions;
        let result = true;
        for (let j = 0; j < menu.length; j++) {
          if (this.tempRole.permissions.includes(menu[j].id)) {
            result = false;
            break;
          }
        }
        return result;
      },
      isMenuAll(_index) {
        //判断本级菜单内的权限是否全选了
        let menu = this.allPermission[_index].permissions;
        let result = true;
        for (let j = 0; j < menu.length; j++) {
          if (this.tempRole.permissions.indexOf(menu[j].id) < 0) {
            result = false;
            break;
          }
        }
        return result;
      },
      checkAll(_index) {
        //点击菜单   相当于全选按钮
        let v = this;
        if (v.isMenuAll(_index)) {
          //如果已经全选了,则全部取消
          v.noPerm(_index);
        } else {
          //如果尚未全选,则全选
          v.allPerm(_index);
        }
      },
      allPerm(_index) {
        //全部选中
        let menu = this.allPermission[_index].permissions;
        for (let j = 0; j < menu.length; j++) {
          this.addUnique(menu[j].id, this.tempRole.permissions)
        }
      },
      noPerm(_index) {
        //全部取消选中
        let menu = this.allPermission[_index].permissions;
        for (let j = 0; j < menu.length; j++) {
          let idIndex = this.tempRole.permissions.indexOf(menu[j].id);
          if (idIndex > -1) {
            this.tempRole.permissions.splice(idIndex, 1);
          }
        }
      },
      addUnique(val, arr) {
        //数组内防重复地添加元素
        let _index = arr.indexOf(val);
        if (_index < 0) {
          arr.push(val);
        }
      },
      checkRequired(_perm, _index) {
        //本方法会在勾选状态改变之后触发
        let permId = _perm.id;
        if (this.tempRole.permissions.indexOf(permId) > -1) {
          //选中事件
          //如果之前未勾选本权限,现在勾选完之后,tempRole里就会包含本id
          //那么就要将必选的权限勾上
          this.makeReuqiredPermissionChecked(_index);
        } else {
          //取消选中事件
          if (_perm.requiredPerm === 1) {
            //如果是必勾权限,就把本菜单的权限全部移出
            //(其实也可以提示用户本权限是菜单里的必选,请先取消勾选另外几个权限,交互太麻烦,此处就直接全部取消选中了)
            this.noPerm(_index);
          }
        }
      },
      makeReuqiredPermissionChecked(_index) {
        //将本菜单必选的权限勾上
        let menu = this.allPermission[_index].permissions;
        for (let j = 0; j < menu.length; j++) {
          let perm = menu[j];
          if (perm.requiredPermission === 1) {
            //找到本菜单的必选权限,将其勾上
            this.addUnique(perm.id, this.tempRole.permissions)
          }
        }
      }
    },
    created(){
      this.getList();
      this.getAllPermisson();
    }
  }
</script>

<style scoped>
</style>
