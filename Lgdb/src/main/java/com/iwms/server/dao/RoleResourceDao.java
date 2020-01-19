package com.iwms.server.dao;

import com.iwms.server.entity.RoleResource;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleResourceDao extends MongoRepository<RoleResource,String> {
}
