package com.iwms.server.controller;

import com.iwms.server.base.Response;
import com.iwms.server.entity.RoleUser;
import com.iwms.server.entity.SystemReq;
import com.iwms.server.service.RoleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.iwms.server.util.Util.isMobile;

@RestController
@CrossOrigin
@RequestMapping("/roleUser")
public class RoleUserController {
    @Autowired
    RoleUserService roleUserService;

    /**
     * 添加用户
     *
     * @param req
     * @return
     */
    @RequestMapping("/add")
    public Response addRoleUser(@RequestBody RoleUser req) {
        String mobile = req.getMobile();
        RoleUser roleUser = roleUserService.findByMobile(mobile);
        if (roleUser != null) {
            return Response.failed(-1, "用户已存在");
        }else if(!isMobile(mobile)){
            return Response.failed(-1,"手机号码不正确");
        } else {
            roleUserService.addRoleUser(req);
            return Response.success(0,"添加用户成功");
        }
    }

    /**
     * 查看用户列表
     *
     * @return
     */
    @RequestMapping("/list")
    public Response findAll() {
        List<RoleUser> all = roleUserService.findAll();
        return Response.success(all);
    }

    /**
     * 通过id查询用户
     * @param req
     * @return
     */
    @RequestMapping("/findOne")
    public Response findOne(@RequestBody SystemReq req) {
        return Response.success(roleUserService.findById(req));
    }

    /**
     * 通过id删除用户
     * @param req
     * @return
     */
    @RequestMapping("/delete")
    public Response deleteById(@RequestBody SystemReq req){
        roleUserService.deleteById(req);
        return Response.success(0,"删除用户成功");
    }

    /**
     * 更新用户信息
     * @param req
     * @return
     */
    @RequestMapping("/update")
    public Response updateById(@RequestBody RoleUser req){
        String mobile = req.getMobile();
        String id = req.getId();
        if(!isMobile(mobile)){
            return Response.failed("手机号码不正确");
        }else{
            roleUserService.updateById(id,req);
            return Response.success(0,"更新成功");
        }

    }
}
