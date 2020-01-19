package com.iwms.server.dao;

import com.iwms.server.entity.EmployeeType;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmpTypeDao extends MongoRepository<EmployeeType,String> {
    EmployeeType findByEmpTypeName(String empTypeName);
}
