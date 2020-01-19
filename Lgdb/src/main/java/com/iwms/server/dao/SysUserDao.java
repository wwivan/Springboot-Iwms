package com.iwms.server.dao;

import com.iwms.server.entity.SysUser;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SysUserDao extends MongoRepository<SysUser,String> {
    SysUser findByUserName(String userName);
}
