<template>
    <div>
        <h1>{{id?'编辑':'新增'}}用户</h1>
        <el-form label-width="120px"
                 @submit.native.prevent="save">
            <el-tabs value="basic"
                     type="border-card">
                <el-tab-pane label="基本信息"
                             name="basic">
                    <el-form-item label="用户名">
                        <el-input v-model="model.username"></el-input>
                    </el-form-item>
                    <el-form-item label="密码">
                        <el-input v-model="model.password" type="password"></el-input>
                    </el-form-item>
                    <el-form-item label="手机号码">
                        <el-input v-model="model.mobile"></el-input>
                    </el-form-item>
                    <el-form-item label="openId">
                        <el-input v-model="model.openId"></el-input>
                    </el-form-item>
                    <el-form-item label="职位">
                        <el-select v-model="model.empType">
                            <el-option v-for="item in empTypes"
                                       :key="item.id"
                                       :label="item.empTypeName"
                                       :value="item.empTypeName"></el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="部门主管"
                                  v-if="!(model.empType=='销售主管'||model.empType=='采购主管'||model.empType=='财务主管')">
                        <el-select v-model="model.directorId">
                            <el-option v-for="item in directors"
                                       :key="item.id"
                                       :label="item.username"
                                       :value="item.id"></el-option>
                        </el-select>
                    </el-form-item>
                </el-tab-pane>
                <el-tab-pane label="角色资源添加"
                             name="detail">
                    <el-button size="small"
                               @click="model.factoryUserTypeMapList.push({})">
                        <i class="el-icon-plus"></i>
                        添加角色资源
                    </el-button>
                    <el-row type="flex"
                            style="flex-wrap:wrap">
                        <el-col :md="12"
                                v-for="(item,i) in model.factoryUserTypeMapList"
                                :key="i">
                            <el-form-item label="选择工厂">
                                <el-select v-model="model.factoryUserTypeMapList[i].fid">
                                    <el-option v-for="item in factories"
                                               :key="item.id"
                                               :label="item.factoryName"
                                               :value="item.id"></el-option>
                                </el-select>
                            </el-form-item>
                            <el-form-item label="用户类型">
                                <el-select v-model="model.factoryUserTypeMapList[i].utid">
                                    <el-option v-for="item in userTypes"
                                               :key="item.id"
                                               :label="item.type"
                                               :value="item.id"></el-option>
                                </el-select>
                            </el-form-item>
                            <el-form-item>
                                <el-button type="danger" size="samll" @click="model.factoryUserTypeMapList.splice(i,1)">
                                    删除
                                </el-button>
                            </el-form-item>
                        </el-col>
                    </el-row>
                </el-tab-pane>
            </el-tabs>
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
                    id: undefined,
                    directorId: undefined,
                    openId: undefined,
                    empType: undefined,
                    factoryUserTypeMapList: [
                        {
                            fid: undefined,
                            utid: undefined
                        }
                    ]
                },
                directors: [],
                empTypes: [],
                factoryUserTypeMapLists: [],
                userTypes: [],
                factories: []

            };
        },
        methods: {
            async save() {
                let res;
                if (this.id) {
                    this.model.id = this.id;
                    res = await this.$http.post("roleUser/update", this.model);
                } else {
                    res = await this.$http.post("roleUser/add", this.model);
                }
                this.$router.push("/roleUser/list");
                this.$message({
                    type: "success",
                    message: res.data.message
                });
            },
            async fetch() {
                const res = await this.$http.post(`roleUser/findOne`, {roleUserId: this.id});
                this.model = res.data.data;
            },
            async fetchDirectors() {
                const res = await this.$http.get("roleUser/list");
                this.directors = res.data.data
            },
            async fetchEmpTypes() {
                const res = await this.$http.get("empType/list");
                this.empTypes = res.data.data
            },
            async fetchUserTypes() {
                const res = await this.$http.get("userType/list");
                this.userTypes = res.data.data
            },
            async fetchFactories() {
                const res = await this.$http.get("factory/list");
                this.factories = res.data.data
            }
        },
        created() {
            this.fetchFactories();
            this.fetchUserTypes();
            this.fetchEmpTypes();
            this.fetchDirectors();
            this.id && this.fetch();
        }
    };
</script>
<style>
</style>