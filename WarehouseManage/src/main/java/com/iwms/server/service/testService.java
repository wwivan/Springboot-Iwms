package com.iwms.server.service;

import com.iwms.server.dao.testDao;
import com.iwms.server.entity.test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class testService {
    @Autowired
    testDao testDao;
    public void add(test req){
        testDao.save(req);
    }
}
