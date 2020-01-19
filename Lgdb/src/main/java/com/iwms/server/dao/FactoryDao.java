package com.iwms.server.dao;

import com.iwms.server.entity.Factory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FactoryDao extends MongoRepository<Factory,String> {
    Factory findFactoryByFactoryName(String factoryName);
}
