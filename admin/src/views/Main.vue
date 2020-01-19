<template>
    <el-container style="height: 100vh;">
        <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
            <el-menu router :default-openeds="['3']" unique-opened :default-active="$route.path">
                <el-submenu index="1">
                    <template slot="title">
                        <i class="el-icon-message"></i>内容管理
                    </template>
                    <el-menu-item-group>
                        <template slot="title">工厂管理</template>
                        <el-menu-item index="/factory/create">新增工厂</el-menu-item>
                        <el-menu-item index="/factory/list">工厂列表</el-menu-item>
                    </el-menu-item-group>
                    <el-menu-item-group>
                        <template slot="title">角色管理</template>
                        <el-menu-item index="/userType/create">新建角色</el-menu-item>
                        <el-menu-item index="/userType/list">角色列表</el-menu-item>
                    </el-menu-item-group>
                </el-submenu>

                <el-submenu index="2">
                    <template slot="title">
                        <i class="el-icon-message"></i>部门管理
                    </template>
                    <el-menu-item-group>
                        <template slot="title">部门管理</template>
                        <el-menu-item index="/dept/create">新建部门</el-menu-item>
                        <el-menu-item index="/dept/list">部门列表</el-menu-item>
                    </el-menu-item-group>
                    <el-menu-item-group>
                        <template slot="title">职位管理</template>
                        <el-menu-item index="/empType/create">新建职位</el-menu-item>
                        <el-menu-item index="/empType/list">职位列表</el-menu-item>
                    </el-menu-item-group>
                </el-submenu>

                <el-submenu index="3">
                    <template slot="title">
                        <i class="el-icon-menu"></i>运营管理
                    </template>
                    <el-menu-item-group>
                        <template slot="title">用户管理</template>
                        <el-menu-item index="/roleUser/create">新建用户</el-menu-item>
                        <el-menu-item index="/roleUser/list">用户列表</el-menu-item>
                    </el-menu-item-group>
                </el-submenu>

                <el-submenu index="4">
                    <template slot="title">
                        <i class="el-icon-message"></i>系统设置
                    </template>
                    <el-menu-item-group>
                        <template slot="title">系统管理员</template>
                        <el-menu-item index="/sysUser/create">新建管理员</el-menu-item>
                        <el-menu-item index="/sysUser/list">管理员列表</el-menu-item>
                    </el-menu-item-group>
                </el-submenu>
            </el-menu>
        </el-aside>

        <el-container>
            <el-header style="text-align: right; font-size: 12px">
                <el-dropdown>
                    <i class="el-icon-setting" style="margin-right: 15px"></i>
                    <el-dropdown-menu slot="dropdown">
                        <el-dropdown-item>查看</el-dropdown-item>
                        <el-dropdown-item>新增</el-dropdown-item>
                        <el-dropdown-item>删除</el-dropdown-item>
                    </el-dropdown-menu>
                </el-dropdown>
                <span>{{item.name}}</span>
            </el-header>

            <el-main>
                <router-view :key="$route.path"></router-view>
            </el-main>
        </el-container>
    </el-container>
</template>


<style>
    .el-header {
        background-color: #b3c0d1;
        color: #333;
        line-height: 60px;
    }

    .el-aside {
        color: #333;
    }
</style>

<script>
    export default {
        data() {
            return {
                item: {
                    date: "2016-05-02",
                    name: "王小虎",
                    address: "上海市普陀区金沙江路 1518 弄"
                },
                index:undefined
            };
        },
    };
</script>