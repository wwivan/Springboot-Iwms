<template>
    <div>
        <h1>{{id?'编辑':'新增'}}工厂</h1>
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
            <el-tabs value="basic"
                     type="border-card">
                <el-tab-pane label="基本信息"
                             name="basic">
                    <el-form-item label="工厂名称">
                        <el-input v-model="model.factoryName"></el-input>
                    </el-form-item>
                    <el-form-item label="管理员">
                        <el-input v-model="model.administrators"></el-input>
                    </el-form-item>
                    <el-form-item label="地址">
                        <el-input v-model="model.address"></el-input>
                    </el-form-item>
                    <el-form-item label="电话">
                        <el-input v-model="model.tel"></el-input>
                    </el-form-item>
                    <el-form-item label="简介">
                        <el-input v-model="model.descn"></el-input>
                    </el-form-item>
                </el-tab-pane>
                <el-tab-pane label="详细信息"
                             name="detail">
                    <el-form-item label="入库流程">
                        <el-input v-model="model.inProcess"></el-input>
                    </el-form-item>
                    <el-form-item label="出库流程">
                        <el-input v-model="model.outProcess"></el-input>
                    </el-form-item>
                    <el-form-item label="联系人">
                        <el-input v-model="model.contacts"></el-input>
                    </el-form-item>
                    <el-form-item label="联系人电话">
                        <el-input v-model="model.contactsPhone"></el-input>
                    </el-form-item>
                    <el-form-item label="联系人邮箱">
                        <el-input v-model="model.contactsEmail"></el-input>
                    </el-form-item>
                    <el-form-item label="状态">
                        <el-select v-model="model.status">
                            <el-option v-for="item of status"
                                       :key="item.status"
                                       :label="item.name"
                                       :value="item.status"></el-option>
                        </el-select>
                    </el-form-item>

                    <el-form-item label="图标">
                        <el-upload class="avatar-uploader"
                                   :action="uploadUrl"
                                   name="upload"
                                   v-model="model.logo"
                                   :on-success="handleAvatarSuccess"
                        >
                            <img v-if="model.logo"
                                 :src="model.logo"
                                 class="avatar">
                            <i v-else
                               class="el-icon-plus avatar-uploader-icon"></i>
                        </el-upload>
                    </el-form-item>
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
                    logo: undefined,
                    factoryName: undefined,
                    administrators: undefined,
                    address: undefined,
                    tel: undefined,
                    descn: undefined,
                    inProcess: undefined,
                    outProcess: undefined,
                    contacts: undefined,
                    contactsPhone: undefined,
                    contactsEmail: undefined,
                    status: undefined,
                    createTime: undefined,
                    lastTime: undefined
                },
                ruleForm: {},
                status: [
                    {
                        status: 0,
                        name: "关闭"
                    },
                    {
                        status: 1,
                        name: "使用"
                    }
                ]
            };
        },
        methods: {
            //这个才是最主要的
            handleAvatarSuccess(res) {
                this.model.logo = res.data
            },

            async save() {
                let res;
                if (this.id) {
                    this.model.id = this.id;
                    res = await this.$http.post(`factory/update`, this.model);
                } else {
                    res = await this.$http.post("factory/addFactory", this.model);
                }
                this.$router.push("/factory/list");
                this.$message({
                    type: "success",
                    message: res.data.message
                });
            },
            async fetch() {
                const res = await this.$http.post(`factory/findOne`, {factoryId: this.id});
                this.model = res.data.data;
            }
        },
        created() {
            this.id && this.fetch();
        }
    };
</script>
<style>
    .avatar-uploader .el-upload {
        border: 1px dashed #d9d9d9;
        border-radius: 6px;
        cursor: pointer;
        position: relative;
        overflow: hidden;
    }

    .avatar-uploader .el-upload:hover {
        border-color: #409eff;
    }

    .avatar-uploader-icon {
        font-size: 28px;
        color: #8c939d;
        width: 178px;
        height: 178px;
        line-height: 178px;
        text-align: center;
    }

    .avatar {
        width: 178px;
        height: 178px;
        display: block;
    }
</style>