package com.iwms.server.dao;

import com.iwms.server.entity.test;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface testDao extends MongoRepository<test,String> {
}
