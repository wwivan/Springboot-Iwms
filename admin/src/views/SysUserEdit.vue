<template>
    <div>
        <h1>{{id?'编辑':'新增'}}管理员</h1>
        <el-form label-width="120px"
                 @submit.native.prevent="save">
<!--            <template>-->
<!--                <el-radio v-model="radio" label="1">系统管理员</el-radio>-->
<!--                <el-radio v-model="radio" label="2">工厂管理员</el-radio>-->
<!--            </template>-->
            <el-form-item label="管理员类型">
                <el-select v-model="model.fid">
                    <el-option v-for="item in factories"
                               :key="item.id"
                               :label="item.factoryName"
                               :value="item.id"></el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="用户名">
                <el-input v-model="model.userName"></el-input>
            </el-form-item>
            <el-form-item label="密码">
                <el-input v-model="model.password" type="password"></el-input>
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
                radio: '1',
                model: {
                    id: undefined,
                    userName: undefined,
                    password: undefined,
                    fid: undefined
                },
                factories: [],
                admin:{
                    id:"admin",
                    factoryName: "超级管理员"
                }
            };
        },
        methods: {
            async save() {
                let res;
                if (this.id) {
                    this.model.id = this.id;
                    res = await this.$http.post("sysUser/update", this.model);
                } else {
                    res = await this.$http.post("sysUser/add", this.model);
                }
                this.$router.push("/sysUser/list");
                this.$message({
                    type: "success",
                    message: res.data.message
                });
            },
            async fetch() {
                const res = await this.$http.post(`sysUser/findOne`, {sysUserId: this.id});
                this.model = res.data.data;
            },
            async fetchFactories() {
                const res = await this.$http.get("factory/list");
                this.factories = res.data.data
                this.factories.push(this.admin)
            }
        },
        created() {
            this.fetchFactories();
            this.id && this.fetch();
        }
    };
</script>
<style>
</style>