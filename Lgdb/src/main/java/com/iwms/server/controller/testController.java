package com.iwms.server.controller;

import com.iwms.server.base.Response;
import com.iwms.server.dao.testDao;
import com.iwms.server.entity.test;
import com.iwms.server.service.testService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/test")
public class testController {
    @Autowired
    testService testService;
    @RequestMapping("/test")
    public Response hello(@RequestBody test req) {
        testService.add(req);
        return Response.success(req);
    }
}
