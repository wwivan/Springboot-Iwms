package com.iwms.server.controller;

import com.iwms.server.base.Response;
import com.iwms.server.entity.SystemReq;
import com.iwms.server.entity.UserType;
import com.iwms.server.service.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/userType")
public class UserTypeController {
    @Autowired
    UserTypeService userTypeService;

    /**
     * 添加用户类型
     * @param req
     * @return
     */
    @RequestMapping("/add")
    public Response addUserType(@RequestBody UserType req){
        UserType userType = userTypeService.findByName(req.getType());
        if (userType!=null){
            return Response.failed(-1,"角色已存在");
        }else{
            userTypeService.addUserType(req);
            return Response.success(0,"添加角色成功");
        }
    }

    /**
     * 所有角色列表
     * @return
     */
    @RequestMapping("/list")
    public Response findAll(){
        List<UserType> all = userTypeService.findAll();
        return Response.success(all);
    }

    /**
     * 通过id查询单个角色
     * @param req
     * @return
     */
    @RequestMapping("/findOne")
    public Response findOne(@RequestBody SystemReq req){
        UserType userType = userTypeService.findById(req);
        return Response.success(userType);
    }

    /**
     * 删除单个角色
     * @param req
     * @return
     */
    @RequestMapping("/delete")
    public Response deleteById(@RequestBody SystemReq req){
        userTypeService.deleteById(req);
        return Response.success(0,"删除成功");
    }

    /**
     * 更新角色信息
     * @param req
     * @return
     */
    @RequestMapping("/update")
    public Response updateById(@RequestBody UserType req){
        String id = req.getId();
        userTypeService.updateById(id,req);
        return Response.success(0,"更新成功");
    }
}
