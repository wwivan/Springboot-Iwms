package com.iwms.server.controller;

import com.iwms.server.base.Response;
import com.iwms.server.entity.SysUser;
import com.iwms.server.entity.SystemReq;
import com.iwms.server.service.SysUserService;
import com.iwms.server.util.JwtToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sysUser")
@CrossOrigin
public class SysUserController {
    @Autowired
    SysUserService sysUserService;

    /**
     * 添加系统管理员
     * @param req
     * @return
     */
    @RequestMapping("/add")
    public Response addSysUser(@RequestBody SysUser req){
        String userName = req.getUserName();
        SysUser sysUser = sysUserService.findByName(userName);
        if(sysUser!=null){
            return Response.failed(-1,"系统管理员已存在");
        }else{
            sysUserService.addSysUser(req);
            return Response.success(0,"添加成功");
        }
    }

    /**
     * 查询所有系统管理员
     * @return
     */
    @JwtToken
    @RequestMapping("/list")
    public Response findAll(){
        List<SysUser> all = sysUserService.findAll();
        return Response.success(all);
    }

    /**
     * 通过id查询系统管理员
     * @param req
     * @return
     */
    @RequestMapping("/findOne")
    public Response findOne(@RequestBody SystemReq req){
        SysUser sysUser = sysUserService.findById(req);
        return Response.success(sysUser);
    }

    /**
     * 通过id删除系统管理员
     * @param req
     * @return
     */
    @RequestMapping("/delete")
    public Response deleteById(@RequestBody SystemReq req){
        sysUserService.deleteById(req);
        return Response.success(0,"删除成功");
    }

    /**
     * 更新系统管理员信息
     * @param req
     * @return
     */
    @RequestMapping("/update")
    public Response updateById(@RequestBody SysUser req){
        String id = req.getId();
        sysUserService.updateById(id,req);
        return Response.success(0,"更新成功");
    }
}
