package com.iwms.server.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * 职位
 */
@Data
public class EmployeeType {
    @Id
    private String id;
    private String empTypeName;
    private String deptId;
}
