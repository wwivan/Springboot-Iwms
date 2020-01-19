<template>
    <div>
        <h1>{{id?'编辑':'新增'}}部门</h1>
        <el-form label-width="120px"
                 @submit.native.prevent="save">
            <!-- <el-form-item label="上级分类">
              <el-select v-model="model.parent">
                <el-option v-for="item in parents"
                           :key="item._id"
                           :label="item.name"
                           :value="item._id"></el-option>
              </el-select>
            </el-form-item> -->
            <el-form-item label="部门">
                <el-input v-model="model.deptName"></el-input>
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
                    deptName:undefined
                }
            };
        },
        methods: {
            async save() {
                let res;
                if (this.id) {
                    this.model.id = this.id;
                    res = await this.$http.post("dept/update", this.model);
                } else {
                    res = await this.$http.post("dept/add", this.model);
                }
                this.$router.push("/dept/list");
                this.$message({
                    type: "success",
                    message: res.data.message
                });
            },
            async fetch() {
                const res = await this.$http.post(`dept/findOne`, {deptId: this.id});
                this.model = res.data.data;
            }
        },
        created() {
            this.id && this.fetch();
        }
    };
</script>
<style>
</style>