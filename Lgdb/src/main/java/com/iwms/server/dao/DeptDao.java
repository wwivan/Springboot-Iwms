package com.iwms.server.dao;

import com.iwms.server.entity.Department;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DeptDao extends MongoRepository<Department,String> {
    Department findDepartmentByDeptName(String deptName);
}
