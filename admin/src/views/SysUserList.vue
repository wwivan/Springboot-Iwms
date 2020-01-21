<template>
  <div>
    <h1>职位列表</h1>
    <el-table :data="sysUsers">
      <el-table-column prop="id"
                       label="ID"
                       width="230">
      </el-table-column>
      <!-- <el-table-column prop="parent.name"
                       label="上级分类">
      </el-table-column> -->
      <el-table-column prop="userName"
                       label="管理员">
      </el-table-column>
<!--      <el-table-column prop="icon"-->
<!--                       label="图标">-->
<!--        <template slot-scope="scope">-->
<!--          <img :src="scope.row.icon"-->
<!--               alt=""-->
<!--               style="height:3rem">-->
<!--        </template>-->
<!--      </el-table-column>-->
      <el-table-column fixed="right"
                       label="操作"
                       width="180">
        <template slot-scope="scope">
          <el-button type="primary"
                     size="small"
                     @click="$router.push(`/sysUser/edit/${scope.row.id}`)">编辑</el-button>
          <el-button type="text"
                     size="small"
                     @click="remove(scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        sysUsers: []
      };
    },
    methods: {
      async fetch() {
        const res = await this.$http.get("sysUser/list");
        this.sysUsers = res.data.data;
        if(res.data.code==-1){
          this.$message({
            type: "error",
            message: res.data.message
          });
          this.$router.push("/login");
        }


      },
      async remove(row) {
        this.$confirm(`是否确定要删除角色"${row.userName}"`, "提示", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(async () => {
          await this.$http.post("empType/delete",{sysUserId:row.id});
          this.$message({
            type: "success",
            message: "删除成功!"
          });
          this.fetch();
        });
      }
    },
    created() {
      this.fetch();
    }
  };
</script>