package com.iwms.server.controller;

import com.iwms.server.base.Response;
import com.iwms.server.entity.Factory;
import com.iwms.server.entity.SystemReq;
import com.iwms.server.service.FactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/factory")
public class FactoryController {
    @Autowired
    FactoryService factoryService;

    /**
     * 新增工厂
     * @param factory
     * @return
     */
    @RequestMapping("/addFactory")
    public Response addFactory(@RequestBody Factory factory) {
        String factoryName = factory.getFactoryName();
        Factory factory1 = factoryService.findByName(factoryName);
        if (factory1 != null) {
            return Response.failed(-1, "工厂已存在");
        } else {
            factoryService.addFactory(factory);
            return Response.success(0, "添加工厂成功");
        }

    }

    /**
     * 查看工厂列表
     * @return
     */
    @RequestMapping("/list")
    public Response allFactory() {
        List<Factory> all = factoryService.findAll();
        return Response.success(all);
    }

    /**
     * 通过id查找工厂
     * @param req
     * @return
     */
    @RequestMapping("/findOne")
    public Response findFactoryById(@RequestBody SystemReq req) {
        Factory factory = factoryService.findById(req);
        return Response.success(factory);
    }

    /**
     * 删除单个工厂
     * @param req
     * @return
     */
    @RequestMapping("/delete")
    public Response deleteById(@RequestBody SystemReq req){
        factoryService.deleteById(req);
        return Response.success(0,"删除成功");
    }

    /**
     * 更新工厂信息
     * @param factory
     * @return
     */
    @RequestMapping("/update")
    public Response updateById(@RequestBody Factory factory){
        String id = factory.getId();
        factoryService.updateById(id,factory);
        return Response.success(0,"更新成功");
    }
}
