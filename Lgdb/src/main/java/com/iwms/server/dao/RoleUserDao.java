package com.iwms.server.dao;

import com.iwms.server.entity.RoleUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleUserDao extends MongoRepository<RoleUser,String> {
    RoleUser findByMobile(String mobile);
}
