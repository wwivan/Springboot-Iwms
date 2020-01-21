package com.iwms.server.controller;

import com.iwms.server.base.Response;
import com.iwms.server.entity.SysUser;
import com.iwms.server.service.SysUserService;
import com.iwms.server.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@CrossOrigin
public class LoginController {
    @Autowired
    SysUserService sysUserService;

    /**
     * 系统管理员登录
     * @param req
     * @return
     */
    @RequestMapping("/sysUser")
    public Response SysUserLogin(@RequestBody SysUser req){
        String userName = req.getUserName();
        SysUser sysUser = sysUserService.findByName(userName);
        boolean login = sysUserService.login(req);
        if(!login){
            return Response.failed(-1,"登陆失败");
        }else{
            String token= JwtUtil.sign(sysUser.toString());
            return Response.success(token);
        }
    }
}
