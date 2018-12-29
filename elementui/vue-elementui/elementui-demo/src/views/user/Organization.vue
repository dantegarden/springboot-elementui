<template>
  <div class="app-container">
    <div class="filter-container">
      <el-form :inline="true" :model="queryCondition">
        <el-form-item label="机构名称">
          <el-input v-model="queryCondition.orgName" placeholder="请输入机构名称"></el-input>
        </el-form-item>
        <el-form-item label="机构代码">
          <el-input v-model="queryCondition.orgCode" placeholder="请输入机构代码"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="getList">查询</el-button>
        </el-form-item>
        <el-form-item>
          <el-button type="success" icon="plus" v-if="hasPerm('organization:add')" @click="showAdd">
            添加根级机构
          </el-button>
        </el-form-item>
      </el-form>
    </div>
    <tree-table :data="data" :evalFunc="func"  :expandAll="expandAll"  border>
      <el-table-column label="机构名称">
        <template slot-scope="scope">
          <span>{{scope.row.orgName}}</span>
        </template>
      </el-table-column>
      <el-table-column label="机构代码">
        <template slot-scope="scope">
          <span>{{scope.row.orgCode}}</span>
        </template>
      </el-table-column>
      <el-table-column label="是否直属">
        <template slot-scope="scope">
          <span>{{ $dataTrans(scope.row.isDirectlyUnder, 'DirectlyUnder') }}</span>
        </template>
      </el-table-column>
      <el-table-column align="center" label="管理" width="300" v-if="hasPerm('organization:add') || hasPerm('organization:update') || hasPerm('organization:delete') ">
        <template slot-scope="scope">
            <el-button v-if="hasPerm('organization:add')" type="success" @click="showAdd(scope.row)" >
              添加
            </el-button>
            <el-button v-if="hasPerm('organization:update')" type="primary" @click="showUpdate(scope.row)" >
              修改
            </el-button>
            <el-button v-if="hasPerm('organization:delete')" type="danger" @click="removeOrganization(scope.row.id)">
              删除
            </el-button>
        </template>
      </el-table-column>
    </tree-table>

    <el-dialog :title="dialogTitles[dialogStatus]" :visible.sync="dialogFormVisible" width="75%">
      <el-form class="small-space" :model="tempOrganization" label-position="left" label-width="200px"
               style='width: 100%; margin-left:50px;'>
        <el-form-item label="机构代码" required>
          <el-input type="text" v-model="tempOrganization.orgCode" style="width: 250px;"></el-input>
        </el-form-item>
        <el-form-item label="机构名称" required>
          <el-input type="text" v-model="tempOrganization.orgName" style="width: 250px;"></el-input>
        </el-form-item>
        <el-form-item label="是否是直属部门" required>
          <el-radio v-for="item in dataDict['DirectlyUnder']" :key="item.value"
                    v-model="tempOrganization.isDirectlyUnder" :label="parseInt(item.value)">{{item.label}}</el-radio>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button v-if="dialogStatus=='create'" type="success" @click="createOrganization">创 建</el-button>
        <el-button type="primary" v-else @click="updateOrganization">修 改</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script type="text/ecmascript-6">
  import api from '@/api'
  import treeToArray from '@/components/TreeTable/customEval'
  import TreeTable from '@/components/TreeTable'

  export default {
    props: [],
    components:{TreeTable},
    data() {
      return {
        dataDict: [],

        queryCondition: {
          orgCode: '',
          orgName: ''
        },

        func: treeToArray,
        expandAll: false,
        data: [],

        dialogStatus: 'create',
        dialogFormVisible: false,
        dialogTitles: {
          update: '编辑',
          create: '新建下属部门'
        },
        tempOrganization: {
          id: '',
          orgName: '',
          orgCode: '',
          isDirectlyUnder: 0
        }
      }
    },
    methods: {
      getList(){
        api.getOrgList().then(res=>{
          if(res.code==200){
            this.data = res.data
          }
        })
      },
      showAdd(row){
        //显示新增对话框
        this.tempOrganization.orgName = '';
        this.tempOrganization.orgCode = '';
        this.tempOrganization.id = null;
        this.tempOrganization.parent = row.id ? {id: row.id}: null;
        this.tempOrganization.children = [];
        this.tempOrganization.isDirectlyUnder = 0;
        this.dialogStatus = "create"
        this.dialogFormVisible = true
      },
      showUpdate(row){
        this.tempOrganization.orgName = row.orgName;
        this.tempOrganization.orgCode = row.orgCode;
        this.tempOrganization.id = row.id;
        this.tempOrganization.parent = {id: row.parent.id};
        this.tempOrganization.children = null;
        this.tempOrganization.isDirectlyUnder = row.isDirectlyUnder;
        this.dialogStatus = "update"
        this.dialogFormVisible = true
      },
      createOrganization(){
        api.addOrg(this.tempOrganization).then(() => {
          this.getList();
          this.dialogFormVisible = false
          this.expandAll = true
        })
      },
      updateOrganization(){
        api.updateOrg(this.tempOrganization).then(()=>{
          this.getList();
          this.dialogFormVisible = false
          this.expandAll = true
        })
      },
      removeOrganization(id){
        this.$confirm('确定删除此部门及其下属部门?', '提示', {
          confirmButtonText: '确定',
          showCancelButton: false,
          type: 'warning'
        }).then(() => {
          api.deleteOrg(id).then(res=>{
            if(res.status){
              this.getList()
            }else{
              this.$message.error(res.message);
            }
          })
        })
      }
    },
    created: async function(){
      this.dataDict = await this.$dataDict(['DirectlyUnder'])
      this.getList()
    }
  }
</script>

<style scoped>
</style>
