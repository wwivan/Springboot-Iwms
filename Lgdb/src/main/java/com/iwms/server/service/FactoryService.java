package com.iwms.server.service;

import com.iwms.server.dao.FactoryDao;
import com.iwms.server.entity.Factory;
import com.iwms.server.entity.SystemReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FactoryService {
    @Autowired
    FactoryDao factoryDao;
    public void addFactory(Factory factory){
        factory.setCreateTime(new Date());
        factory.setLastTime(new Date());
        factoryDao.save(factory);
    }
    public List<Factory> findAll(){
        List<Factory> all = factoryDao.findAll();
        return all;
    }
    public Factory findById(SystemReq req){
        String factoryId = req.getFactoryId();
        Factory factory = factoryDao.findById(factoryId).get();
        return factory;
    }

    public Factory findByName(String factoryName){
        Factory factory = factoryDao.findFactoryByFactoryName(factoryName);
        return factory;
    }
    public void deleteById(SystemReq req){
        String factoryId = req.getFactoryId();
        factoryDao.deleteById(factoryId);
    }
    public void updateById(String id, Factory factory){
        factory.setId(id);
        factory.setLastTime(new Date());
        factoryDao.save(factory);
    }

}
