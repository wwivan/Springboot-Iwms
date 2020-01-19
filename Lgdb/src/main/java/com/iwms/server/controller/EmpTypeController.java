package com.iwms.server.controller;

import com.iwms.server.base.Response;
import com.iwms.server.entity.EmployeeType;
import com.iwms.server.entity.SystemReq;
import com.iwms.server.service.EmpTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/empType")
public class EmpTypeController {
    @Autowired
    EmpTypeService empTypeService;

    /**
     * 添加职位类型
     * @param req
     * @return
     */
    @RequestMapping("/add")
    public Response addEmpType(@RequestBody EmployeeType req){
        String empTypeName = req.getEmpTypeName();
        EmployeeType employeeType = empTypeService.findByName(empTypeName);
        if(employeeType!=null){
            return Response.failed(-1,"职位类型已存在");
        }else{
            empTypeService.addEmpType(req);
            return Response.success(0,"添加成功");
        }
    }

    /**
     * 查看职位类型列表
     * @return
     */
    @RequestMapping("/list")
    public Response findAll(){
        List<EmployeeType> all = empTypeService.findAll();
        return Response.success(all);
    }

    /**
     * 通过id查询职位类型
     * @param req
     * @return
     */
    @RequestMapping("/findOne")
    public Response findOne(@RequestBody SystemReq req){
        EmployeeType employeeType = empTypeService.findById(req);
        return Response.success(employeeType);
    }

    /**
     * 通过Id删除职位类型
     * @param req
     * @return
     */
    @RequestMapping("/delete")
    public Response deleteById(@RequestBody SystemReq req){
        empTypeService.deleteById(req);
        return Response.success(0,"删除成功");
    }

    /**
     * 更新职位类型信息
     * @param req
     * @return
     */
    @RequestMapping("/update")
    public Response updateById(@RequestBody EmployeeType req){
        String id = req.getId();
        empTypeService.updateById(id,req);
        return Response.success(0,"更新成功");
    }
}
