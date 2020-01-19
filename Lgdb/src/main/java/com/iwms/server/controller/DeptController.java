package com.iwms.server.controller;

import com.iwms.server.base.Response;
import com.iwms.server.entity.Department;
import com.iwms.server.entity.SystemReq;
import com.iwms.server.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    DeptService deptService;

    /**
     * 添加部门
     * @param req
     * @return
     */
    @RequestMapping("/add")
    public Response addDept(@RequestBody Department req){
        Department department = deptService.findByName(req.getDeptName());
        if(department!=null){
            return Response.failed(-1,"部门已存在");
        }else{
            deptService.addDept(req);
            return Response.success(0,"添加成功");
        }
    }

    /**
     * 查看部门列表
     * @return
     */
    @RequestMapping("/list")
    public Response findAll(){
        List<Department> all = deptService.findAll();
        return Response.success(all);
    }

    /**
     * 通过id查询部门
     * @param req
     * @return
     */
    @RequestMapping("/findOne")
    public Response findOne(@RequestBody SystemReq req){
        Department department = deptService.findById(req);
        return Response.success(department);
    }

    /**
     * 删除部门
     * @param req
     * @return
     */
    @RequestMapping("/delete")
    public Response deleteById(@RequestBody SystemReq req){
        deptService.deleteById(req);
        return Response.success(0,"删除成功");
    }

    /**
     * 更新部门信息
     * @param req
     * @return
     */
    @RequestMapping("/update")
    public Response updateById(@RequestBody Department req){
        String id = req.getId();
        deptService.updateById(id,req);
        return Response.success(0,"更新成功");
    }

}
