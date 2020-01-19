package com.iwms.server.dao;

import com.iwms.server.entity.UserType;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserTypeDao extends MongoRepository<UserType,String> {
    UserType findUserTypesByType(String type);
}
