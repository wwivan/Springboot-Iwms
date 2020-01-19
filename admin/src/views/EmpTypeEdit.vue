<template>
    <div>
        <h1>{{id?'编辑':'新增'}}职位</h1>
        <el-form label-width="120px"
                 @submit.native.prevent="save">
            <el-form-item label="上级分类">
              <el-select v-model="model.deptId">
                <el-option v-for="item in parents"
                           :key="item.id"
                           :label="item.deptName"
                           :value="item.id"></el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="职位类型">
                <el-input v-model="model.empTypeName"></el-input>
            </el-form-item>

            <el-form-item>
                <el-button type="primary"
                           native-type="submit">保存
                </el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
    export default {
        props: {
            id: {}
        },
        data() {
            return {
                model: {
                    id:undefined,
                    empTypeName:undefined,
                    deptId:undefined
                },
                parents:[]
            };
        },
        methods: {
            async save() {
                let res;
                if (this.id) {
                    this.model.id = this.id;
                    res = await this.$http.post("empType/update", this.model);
                } else {
                    res = await this.$http.post("empType/add", this.model);
                }
                this.$router.push("/empType/list");
                this.$message({
                    type: "success",
                    message: res.data.message
                });
            },
            async fetch() {
                const res = await this.$http.post(`empType/findOne`, {empTypeId: this.id});
                this.model = res.data.data;
            },
            async fetchParents(){
                const res = await this.$http.get("dept/list");
                this.parents = res.data.data
            }
        },
        created() {
            this.fetchParents();
            this.id && this.fetch();
        }
    };
</script>
<style>
</style>