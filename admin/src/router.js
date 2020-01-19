import Vue from 'vue'
import Router from 'vue-router'
import Main from './views/Main.vue'
import Login from './views/Login.vue'

import ItemEdit from './views/FactoryEdit.vue'
import ItemList from './views/FactoryList.vue'
import UserTypeEdit from './views/UserTypeEdit.vue'
import UserTypeList from './views/UserTypeList.vue'
import DeptEdit from './views/DeptEdit.vue'
import DeptList from './views/DeptList.vue'
import EmpTypeEdit from './views/EmpTypeEdit.vue'
import EmpTypeList from './views/EmpTypeList.vue'
import RoleUserEdit from './views/RoleUserEdit.vue'
import RoleUserList from './views/RoleUserList.vue'
import SysUserEdit from './views/SysUserEdit.vue'
import SysUserList from './views/SysUserList.vue'

Vue.use(Router)

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [{
      path: '/login',
      name: 'login',
      component: Login,
      meta: {
        isPublic: true
      }
    },
    {
      path: '/',
      name: 'main',
      component: Main,
      children: [

        {
          path: "/factory/create",
          component: ItemEdit
        },
        {
          path: "/factory/edit/:id",
          component: ItemEdit,
          props: true
        },
        {
          path: "/factory/list",
          component: ItemList
        },
        {
          path: "/userType/create",
          component: UserTypeEdit
        },
        {
          path: "/userType/edit/:id",
          component: UserTypeEdit,
          props: true
        },
        {
          path: "/userType/list",
          component: UserTypeList
        },
        {
          path: "/dept/create",
          component: DeptEdit
        },
        {
          path: "/dept/edit/:id",
          component: DeptEdit,
          props: true
        },
        {
          path: "/dept/list",
          component: DeptList
        },
        {
          path: "/empType/create",
          component: EmpTypeEdit
        },
        {
          path: "/empType/edit/:id",
          component: EmpTypeEdit,
          props: true
        },
        {
          path: "/empType/list",
          component: EmpTypeList
        },
        {
          path: "/roleUser/create",
          component: RoleUserEdit
        },
        {
          path: "/roleUser/edit/:id",
          component: RoleUserEdit,
          props: true
        },
        {
          path: "/roleUser/list",
          component: RoleUserList
        },
        {
          path: "/sysUser/create",
          component: SysUserEdit
        },
        {
          path: "/sysUser/edit/:id",
          component: SysUserEdit,
          props: true
        },
        {
          path: "/sysUser/list",
          component: SysUserList
        },
      ]
    },
  ]
})
router.beforeEach((to, from, next) => {//客户端路由限制
  if (!to.meta.isPublic && !localStorage.token) {
    return next('/login')
  }
  next()
})
export default router